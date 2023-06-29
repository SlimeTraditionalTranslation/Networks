package io.github.sefiraat.networks.slimefun.network;

import io.github.sefiraat.networks.Networks;
import io.github.sefiraat.networks.utils.Theme;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.logging.Level;

public interface AdminDebuggable {

    String DEBUG_KEY = "network_debugging";

    default boolean isDebug(@Nonnull Location location) {
        String debug = BlockStorage.getLocationInfo(location, DEBUG_KEY);
        return Boolean.parseBoolean(debug);
    }

    default void setDebug(@Nonnull Location location, boolean value) {
        BlockStorage.addBlockInfo(location, DEBUG_KEY, String.valueOf(value));
    }

    default void toggle(@Nonnull Location location, @Nonnull Player player) {
        final boolean isDebug = isDebug(location);
        final boolean nextState = !isDebug;
        setDebug(location, nextState);
        player.sendMessage(Theme.SUCCESS + "此方塊的除錯已設定為：" + nextState + "。");
        if (nextState) {
            player.sendMessage(Theme.SUCCESS + "它將會持續到重啟伺服器後或是你將其關閉為止。");
        }
    }

    default void sendDebugMessage(@Nonnull Location location, @Nonnull String string) {
        if (isDebug(location)) {
            final String locationString = "W[" + location.getWorld().getName() + "] " +
                "X[" + location.getBlockX() + "] " +
                "Y[" + location.getBlockY() + "] " +
                "Z[" + location.getBlockZ() + "] ";
            Networks.getInstance().getJavaPlugin().getLogger().log(Level.INFO, locationString + " - " + string);
        }
    }
}
