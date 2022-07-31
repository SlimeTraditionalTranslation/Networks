package io.github.sefiraat.networks.slimefun.tools;

import de.jeff_media.morepersistentdatatypes.DataType;
import io.github.sefiraat.networks.slimefun.network.NetworkWirelessReceiver;
import io.github.sefiraat.networks.slimefun.network.NetworkWirelessTransmitter;
import io.github.sefiraat.networks.utils.Keys;
import io.github.sefiraat.networks.utils.Theme;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.Optional;

public class NetworkWirelessConfigurator extends SlimefunItem {

    private static final NamespacedKey TARGET_LOCATION = Keys.newKey("target-location");

    public NetworkWirelessConfigurator(ItemGroup itemGroup,
                                       SlimefunItemStack item,
                                       RecipeType recipeType,
                                       ItemStack[] recipe
    ) {
        super(itemGroup, item, recipeType, recipe);
        addItemHandler(
            new ItemUseHandler() {
                @Override
                public void onRightClick(PlayerRightClickEvent e) {
                    final Player player = e.getPlayer();
                    final Optional<Block> optional = e.getClickedBlock();
                    if (optional.isPresent()) {
                        final Block block = optional.get();
                        final SlimefunItem slimefunItem = BlockStorage.check(block);
                        if (Slimefun.getProtectionManager().hasPermission(player, block, Interaction.INTERACT_BLOCK)) {
                            final ItemStack heldItem = player.getInventory().getItemInMainHand();
                            final BlockMenu blockMenu = BlockStorage.getInventory(block);
                            if (slimefunItem instanceof NetworkWirelessTransmitter transmitter && player.isSneaking()) {
                                setTransmitter(transmitter, heldItem, blockMenu, player);
                            } else if (slimefunItem instanceof NetworkWirelessReceiver && !player.isSneaking()) {
                                setReceiver(heldItem, blockMenu, player);
                            }
                        } else {
                            player.sendMessage(Theme.ERROR + "必須以網路無線方塊為目標.");
                        }
                    }
                    e.cancel();
                }
            }
        );
    }

    private void setTransmitter(@Nonnull NetworkWirelessTransmitter transmitter,
                                @Nonnull ItemStack itemStack,
                                @Nonnull BlockMenu blockMenu,
                                @Nonnull Player player
    ) {
        final ItemMeta itemMeta = itemStack.getItemMeta();
        final Location location = PersistentDataAPI.get(itemMeta, TARGET_LOCATION, DataType.LOCATION);

        if (location == null) {
            player.sendMessage(Theme.ERROR + "未設定無線接收器");
            return;
        }

        if (location.getWorld() != blockMenu.getLocation().getWorld()) {
            player.sendMessage(Theme.ERROR + "無線接收器在不同的世界");
            return;
        }

        transmitter.addLinkedLocation(blockMenu.getBlock(), location);
        player.sendMessage(Theme.SUCCESS + "已設定傳輸器接收座標");
    }

    private void setReceiver(@Nonnull ItemStack itemStack, @Nonnull BlockMenu blockMenu, @Nonnull Player player) {
        final Location location = blockMenu.getLocation();
        final ItemMeta itemMeta = itemStack.getItemMeta();
        PersistentDataAPI.set(itemMeta, TARGET_LOCATION, DataType.LOCATION, location);
        itemStack.setItemMeta(itemMeta);
        player.sendMessage(Theme.SUCCESS + "無線接收器已設定.");
    }
}