package io.github.sefiraat.networks.slimefun.tools;

import io.github.sefiraat.networks.network.NetworkRoot;
import io.github.sefiraat.networks.slimefun.network.NetworkController;
import io.github.sefiraat.networks.utils.Theme;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

public class NetworkProbe extends SlimefunItem implements CanCooldown {

    private static final MessageFormat MESSAGE_FORMAT = new MessageFormat("{0}{1}: {2}{3}", Locale.ROOT);

    public NetworkProbe(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

    }

    @Override
    public void preRegister() {
        addItemHandler((ItemUseHandler) this::onUse);
    }

    protected void onUse(PlayerRightClickEvent e) {
        final Optional<Block> optional = e.getClickedBlock();
        if (optional.isPresent()) {
            final Block block = optional.get();
            final Player player = e.getPlayer();
            if (canBeUsed(player, e.getItem())) {
                final SlimefunItem slimefunItem = BlockStorage.check(block);
                if (slimefunItem instanceof NetworkController) {
                    e.cancel();
                    displayToPlayer(block, player);
                    putOnCooldown(e.getItem());
                }
            }
        }
    }

    private void displayToPlayer(@Nonnull Block block, @Nonnull Player player) {
        final NetworkRoot root = NetworkController.getNetworks().get(block.getLocation());
        if (root != null) {
            final int bridges = root.getBridges().size();
            final int monitors = root.getMonitors().size();
            final int importers = root.getImporters().size();
            final int exporters = root.getExporters().size();
            final int grids = root.getGrids().size();
            final int cells = root.getCells().size();
            final int wipers = root.getWipers().size();
            final int grabbers = root.getGrabbers().size();
            final int pushers = root.getPushers().size();
            final int purgers = root.getPurgers().size();
            final int crafters = root.getCrafters().size();
            final int powerNodes = root.getPowerNodes().size();
            final int powerDisplays = root.getPowerDisplays().size();
            final int encoders = root.getEncoders().size();

            final Map<ItemStack, Integer> allNetworkItems = root.getAllNetworkItems();
            final int distinctItems = allNetworkItems.size();
            long totalItems = allNetworkItems.values().stream().mapToLong(integer -> integer).sum();

            final String nodeCount = root.getNodeCount() >= root.getMaxNodes()
                ? Theme.ERROR + "" + root.getNodeCount() + "+"
                : String.valueOf(root.getNodeCount());

            final ChatColor c = Theme.CLICK_INFO.getColor();
            final ChatColor p = Theme.PASSIVE.getColor();

            player.sendMessage("------------------------------");
            player.sendMessage("            網路概要           ");
            player.sendMessage("------------------------------");

            player.sendMessage(MESSAGE_FORMAT.format(new Object[]{c, "網路橋", p, bridges}, new StringBuffer(), null).toString());
            player.sendMessage(MESSAGE_FORMAT.format(new Object[]{c, "監控器", p, monitors}, new StringBuffer(), null).toString());
            player.sendMessage(MESSAGE_FORMAT.format(new Object[]{c, "輸入器", p, importers}, new StringBuffer(), null).toString());
            player.sendMessage(MESSAGE_FORMAT.format(new Object[]{c, "輸出器", p, exporters}, new StringBuffer(), null).toString());
            player.sendMessage(MESSAGE_FORMAT.format(new Object[]{c, "網路格", p, grids}, new StringBuffer(), null).toString());
            player.sendMessage(MESSAGE_FORMAT.format(new Object[]{c, "單元", p, cells}, new StringBuffer(), null).toString());
            player.sendMessage(MESSAGE_FORMAT.format(new Object[]{c, "擦除器", p, wipers}, new StringBuffer(), null).toString());
            player.sendMessage(MESSAGE_FORMAT.format(new Object[]{c, "抓取器", p, grabbers}, new StringBuffer(), null).toString());
            player.sendMessage(MESSAGE_FORMAT.format(new Object[]{c, "推送器", p, pushers}, new StringBuffer(), null).toString());
            player.sendMessage(MESSAGE_FORMAT.format(new Object[]{c, "清理器", p, purgers}, new StringBuffer(), null).toString());
            player.sendMessage(MESSAGE_FORMAT.format(new Object[]{c, "製作器", p, crafters}, new StringBuffer(), null).toString());
            player.sendMessage(MESSAGE_FORMAT.format(new Object[]{c, "電量節點", p, powerNodes}, new StringBuffer(), null).toString());
            player.sendMessage(MESSAGE_FORMAT.format(new Object[]{c, "電量顯示器", p, powerDisplays}, new StringBuffer(), null).toString());
            player.sendMessage(MESSAGE_FORMAT.format(new Object[]{c, "編碼器", p, encoders}, new StringBuffer(), null).toString());
            player.sendMessage(MESSAGE_FORMAT.format(new Object[]{c, "不同物品數量", p, distinctItems}, new StringBuffer(), null).toString());
            player.sendMessage(MESSAGE_FORMAT.format(new Object[]{c, "總物品數量", p, totalItems}, new StringBuffer(), null).toString());

            player.sendMessage("------------------------------");
            player.sendMessage(MESSAGE_FORMAT.format(new Object[]{c, "總節點數量", p, nodeCount + "/" + root.getMaxNodes()}, new StringBuffer(), null).toString());
            if (root.isOverburdened()) {
                player.sendMessage(Theme.ERROR + "警告: " + Theme.PASSIVE +
                                       "你的網絡已達到或者超過最大節點限制. " +
                                       "超出限制的節點將不起作用, 這些節點可能 " +
                                       "並不總是相同的. 減少您的總節點數量."
                );
            }
        }
    }

    @Override
    public int cooldownDuration() {
        return 10;
    }
}
