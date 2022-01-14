package io.github.sefiraat.networks.slimefun.machines;

import io.github.sefiraat.networks.NetworkStorage;
import io.github.sefiraat.networks.network.NetworkRoot;
import io.github.sefiraat.networks.network.NodeDefinition;
import io.github.sefiraat.networks.network.NodeType;
import io.github.sefiraat.networks.network.SupportedRecipes;
import io.github.sefiraat.networks.slimefun.NetworkSlimefunItems;
import io.github.sefiraat.networks.slimefun.network.NetworkObject;
import io.github.sefiraat.networks.slimefun.tools.CraftingBlueprint;
import io.github.sefiraat.networks.utils.StackUtils;
import io.github.sefiraat.networks.utils.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.Map;

public class Packager extends NetworkObject {

    private static final int[] BACKGROUND = new int[]{
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 15, 17, 18, 20, 24, 25, 26, 27, 28, 29, 33, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44
    };

    private static final int[] RECIPE_SLOTS = new int[]{
        12, 13, 14, 21, 22, 23, 30, 31, 32
    };

    private static final int[] BLUEPRINT_BACK = new int[]{
        10, 28
    };

    private static final int BLANK_BLUEPRINT_SLOT = 19;
    private static final int ENCODE_SLOT = 16;
    private static final int OUTPUT_SLOT = 34;

    public static final CustomItemStack BLUEPRINT_BACK_STACK = new CustomItemStack(
        Material.BLUE_STAINED_GLASS_PANE, Theme.PASSIVE + "Blank Blueprint"
    );

    public static final CustomItemStack ENCODE_STACK = new CustomItemStack(
        Material.BLUE_STAINED_GLASS_PANE, Theme.PASSIVE + "Click to encode when valid"
    );

    public Packager(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe, NodeType.PACKAGER);
    }


    @Override
    public void postRegister() {
        new BlockMenuPreset(this.getId(), this.getItemName()) {

            @Override
            public void init() {
                drawBackground(BACKGROUND);
                drawBackground(BLUEPRINT_BACK_STACK, BLUEPRINT_BACK);

                addItem(ENCODE_SLOT, ENCODE_STACK, (player, i, itemStack, clickAction) -> false);
            }

            @Override
            public void newInstance(@Nonnull BlockMenu menu, @Nonnull Block b) {
                menu.addMenuClickHandler(ENCODE_SLOT, (player, i, itemStack, clickAction) -> {
                    tryEncode(player, menu);
                    return false;
                });
            }

            @Override
            public boolean canOpen(@Nonnull Block block, @Nonnull Player player) {
                return NetworkSlimefunItems.NETWORK_RECIPE_ENCODER.canUse(player, false)
                    && Slimefun.getProtectionManager().hasPermission(player, block.getLocation(), Interaction.INTERACT_BLOCK);
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow) {
                return new int[0];
            }
        };
    }

    public void tryEncode(@Nonnull Player player, @Nonnull BlockMenu blockMenu) {
        final NodeDefinition definition = NetworkStorage.getAllNetworkObjects().get(blockMenu.getLocation());

        if (definition.getNode() == null) {
            return;
        }

        final NetworkRoot root = definition.getNode().getRoot();
        final long networkCharge = root.getDownstreamCharge();

        if (networkCharge < 5000) {
            return;
        }

        if (blockMenu.getItemInSlot(OUTPUT_SLOT) != null) {
            return;
        }

        ItemStack blueprint = blockMenu.getItemInSlot(BLANK_BLUEPRINT_SLOT);

        if (!(SlimefunItem.getByItem(blueprint) instanceof CraftingBlueprint)) {
            return;
        }

        // Get the recipe input
        final ItemStack[] inputs = new ItemStack[RECIPE_SLOTS.length];
        int i = 0;
        for (int recipeSlot : RECIPE_SLOTS) {
            ItemStack stackInSlot = blockMenu.getItemInSlot(recipeSlot);
            if (stackInSlot == null) {
                inputs[i] = null;
            } else {
                inputs[i] = StackUtils.getAsQuantity(stackInSlot, 1);
            }
            i++;
        }

        ItemStack crafted = null;

        // Go through each slimefun recipe, test and set the ItemStack if found
        for (Map.Entry<ItemStack[], ItemStack> entry : SupportedRecipes.getRecipes().entrySet()) {
            if (SupportedRecipes.testRecipe(inputs, entry.getKey())) {
                crafted = entry.getValue().clone();
                break;
            }
        }

        // If no slimefun recipe found, try a vanilla one
        if (crafted == null) {
            crafted = Bukkit.craftItem(inputs.clone(), player.getWorld(), player);
        }

        // If no item crafted OR result doesn't fit, escape
        if (crafted.getType() == Material.AIR) {
            return;
        }

        final ItemStack blueprintClone = StackUtils.getAsQuantity(blueprint, 1);

        blueprint.setAmount(blueprint.getAmount() - 1);
        CraftingBlueprint.setBlueprint(blueprintClone, inputs, crafted);

        for (int recipeSlot : RECIPE_SLOTS) {
            ItemStack slotItem = blockMenu.getItemInSlot(recipeSlot);
            if (slotItem != null) {
                slotItem.setAmount(slotItem.getAmount() - 1);
            }
        }

        blockMenu.pushItem(blueprintClone, OUTPUT_SLOT);
        root.removeCharge(5000);
    }
}
