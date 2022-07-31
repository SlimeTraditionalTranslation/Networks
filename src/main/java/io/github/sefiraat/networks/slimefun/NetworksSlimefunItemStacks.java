package io.github.sefiraat.networks.slimefun;

import io.github.sefiraat.networks.slimefun.network.NetworkQuantumStorage;
import io.github.sefiraat.networks.slimefun.tools.NetworkRemote;
import io.github.sefiraat.networks.utils.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.text.MessageFormat;

/**
 * Creating SlimefunItemstacks here due to some items being created in Enums so this will
 * act as a one-stop-shop for the stacks themselves.
 */
@UtilityClass
public class NetworksSlimefunItemStacks {

    // Materials
    public static final SlimefunItemStack SYNTHETIC_EMERALD_SHARD;
    public static final SlimefunItemStack OPTIC_GLASS;
    public static final SlimefunItemStack OPTIC_CABLE;
    public static final SlimefunItemStack OPTIC_STAR;
    public static final SlimefunItemStack RADIOACTIVE_OPTIC_STAR;
    public static final SlimefunItemStack SHRINKING_BASE;
    public static final SlimefunItemStack SIMPLE_NANOBOTS;
    public static final SlimefunItemStack ADVANCED_NANOBOTS;
    public static final SlimefunItemStack AI_CORE;
    public static final SlimefunItemStack EMPOWERED_AI_CORE;
    public static final SlimefunItemStack PRISTINE_AI_CORE;
    public static final SlimefunItemStack INTERDIMENSIONAL_PRESENCE;

    // Network Items
    public static final SlimefunItemStack NETWORK_CONTROLLER;
    public static final SlimefunItemStack NETWORK_BRIDGE;
    public static final SlimefunItemStack NETWORK_MONITOR;
    public static final SlimefunItemStack NETWORK_IMPORT;
    public static final SlimefunItemStack NETWORK_EXPORT;
    public static final SlimefunItemStack NETWORK_GRABBER;
    public static final SlimefunItemStack NETWORK_PUSHER;
    public static final SlimefunItemStack NETWORK_VANILLA_GRABBER;
    public static final SlimefunItemStack NETWORK_VANILLA_PUSHER;
    public static final SlimefunItemStack NETWORK_WIRELESS_TRANSMITTER;
    public static final SlimefunItemStack NETWORK_WIRELESS_RECEIVER;
    public static final SlimefunItemStack NETWORK_PURGER;
    public static final SlimefunItemStack NETWORK_GRID;
    public static final SlimefunItemStack NETWORK_CRAFTING_GRID;
    public static final SlimefunItemStack NETWORK_CELL;
    public static final SlimefunItemStack NETWORK_GREEDY_BLOCK;
    public static final SlimefunItemStack NETWORK_QUANTUM_WORKBENCH;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_1;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_2;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_3;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_4;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_5;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_6;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_7;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_8;
    public static final SlimefunItemStack NETWORK_CAPACITOR_1;
    public static final SlimefunItemStack NETWORK_CAPACITOR_2;
    public static final SlimefunItemStack NETWORK_CAPACITOR_3;
    public static final SlimefunItemStack NETWORK_CAPACITOR_4;
    public static final SlimefunItemStack NETWORK_POWER_OUTLET_1;
    public static final SlimefunItemStack NETWORK_POWER_OUTLET_2;
    public static final SlimefunItemStack NETWORK_POWER_DISPLAY;
    public static final SlimefunItemStack NETWORK_RECIPE_ENCODER;
    public static final SlimefunItemStack NETWORK_AUTO_CRAFTER;
    public static final SlimefunItemStack NETWORK_AUTO_CRAFTER_WITHHOLDING;

    // Tools
    public static final SlimefunItemStack CRAFTING_BLUEPRINT;
    public static final SlimefunItemStack NETWORK_PROBE;
    public static final SlimefunItemStack NETWORK_REMOTE;
    public static final SlimefunItemStack NETWORK_REMOTE_EMPOWERED;
    public static final SlimefunItemStack NETWORK_REMOTE_PRISTINE;
    public static final SlimefunItemStack NETWORK_REMOTE_ULTIMATE;
    public static final SlimefunItemStack NETWORK_CRAYON;
    public static final SlimefunItemStack NETWORK_CONFIGURATOR;
    public static final SlimefunItemStack NETWORK_WIRELESS_CONFIGURATOR;
    public static final SlimefunItemStack NETWORK_RAKE_1;
    public static final SlimefunItemStack NETWORK_RAKE_2;
    public static final SlimefunItemStack NETWORK_RAKE_3;

    static {

        SYNTHETIC_EMERALD_SHARD = Theme.themedSlimefunItemStack(
            "NTW_SYNTHETIC_EMERALD_SHARD",
            new ItemStack(Material.LIME_DYE),
            Theme.CRAFTING,
            "人造綠寶石碎片",
            "一塊人造綠寶石碎片",
            "是資訊傳輸的",
            "骨幹."
        );

        OPTIC_GLASS = Theme.themedSlimefunItemStack(
            "NTW_OPTIC_GLASS",
            new ItemStack(Material.GLASS),
            Theme.CRAFTING,
            "光學玻璃",
            "一個簡單的玻璃,",
            "能夠傳輸少量位元的資訊."
        );

        OPTIC_CABLE = Theme.themedSlimefunItemStack(
            "NTW_OPTIC_CABLE",
            new ItemStack(Material.STRING),
            Theme.CRAFTING,
            "光纜",
            "一個簡單的線纜,",
            "能夠傳輸大量位元的資訊."
        );

        OPTIC_STAR = Theme.themedSlimefunItemStack(
            "NTW_OPTIC_STAR",
            new ItemStack(Material.NETHER_STAR),
            Theme.CRAFTING,
            "光學之星",
            "一種結晶星狀結構,",
            "能夠傳輸大量位元的資訊."
        );

        RADIOACTIVE_OPTIC_STAR = Theme.themedSlimefunItemStack(
            "NTW_RADIOACTIVE_OPTIC_STAR",
            getPreEnchantedItemStack(Material.NETHER_STAR, true, new Pair<>(Enchantment.ARROW_DAMAGE, 1)),
            Theme.CRAFTING,
            "輻射光學之星",
            "一種結晶星狀結構,",
            "能夠儲存瘋狂數量的位元的資訊."
        );

        SHRINKING_BASE = Theme.themedSlimefunItemStack(
            "NTW_SHRINKING_BASE",
            getPreEnchantedItemStack(Material.PISTON, true, new Pair<>(Enchantment.ARROW_DAMAGE, 1)),
            Theme.CRAFTING,
            "伸縮基地",
            "一種能夠使大東西變成",
            "小東西的先進構造."
        );

        SIMPLE_NANOBOTS = Theme.themedSlimefunItemStack(
            "NTW_SIMPLE_NANOBOTS",
            new ItemStack(Material.MELON_SEEDS),
            Theme.CRAFTING,
            "簡單的奈米機器人",
            "小小機器人, 可以幫你",
            "完成精確的任務."
        );

        ADVANCED_NANOBOTS = Theme.themedSlimefunItemStack(
            "NTW_ADVANCED_NANOBOTS",
            getPreEnchantedItemStack(Material.MELON_SEEDS, true, new Pair<>(Enchantment.ARROW_DAMAGE, 1)),
            Theme.CRAFTING,
            "進階奈米機器人",
            "小小機器人, 可以幫你",
            "完成精確的任務.",
            "這個版本更加的聰明, 更快速."
        );

        AI_CORE = Theme.themedSlimefunItemStack(
            "NTW_AI_CORE",
            new ItemStack(Material.BRAIN_CORAL_BLOCK),
            Theme.CRAFTING,
            "A.I. 核心",
            "一種迅速發展的人工智能,",
            "存在這個脆弱的外殼之中."
        );

        EMPOWERED_AI_CORE = Theme.themedSlimefunItemStack(
            "NTW_EMPOWERED_AI_CORE",
            new ItemStack(Material.TUBE_CORAL_BLOCK),
            Theme.CRAFTING,
            "授權 A.I. 核心",
            "一種盛行的人工智能,",
            "存在這個外殼之中."
        );

        PRISTINE_AI_CORE = Theme.themedSlimefunItemStack(
            "NTW_PRISTINE_AI_CORE",
            getPreEnchantedItemStack(Material.TUBE_CORAL_BLOCK, true, new Pair<>(Enchantment.ARROW_DAMAGE, 1)),
            Theme.CRAFTING,
            "初始版 A.I. 核心",
            "一種完美的人工智能,",
            "存在這個輪廓分明的外殼之中."
        );

        INTERDIMENSIONAL_PRESENCE = Theme.themedSlimefunItemStack(
            "NTW_INTERDIMENSIONAL_PRESENCE",
            getPreEnchantedItemStack(Material.ARMOR_STAND, true, new Pair<>(Enchantment.ARROW_DAMAGE, 1)),
            Theme.CRAFTING,
            "跨維度的存在",
            "一種人工智能已經",
            "成長得太過於強大,",
            "對於單一維度來說."
        );

        NETWORK_CONTROLLER = Theme.themedSlimefunItemStack(
            "NTW_CONTROLLER",
            new ItemStack(Material.BLACK_STAINED_GLASS),
            Theme.MACHINE,
            "網路控制器",
            "網路控制器是整個",
            "網路的大腦. 每個網路只能有一個."
        );

        NETWORK_BRIDGE = Theme.themedSlimefunItemStack(
            "NTW_BRIDGE",
            new ItemStack(Material.WHITE_STAINED_GLASS),
            Theme.MACHINE,
            "網路橋",
            "網路橋可以讓便宜的將",
            "你要接的網路對象接在一起."
        );

        NETWORK_MONITOR = Theme.themedSlimefunItemStack(
            "NTW_MONITOR",
            new ItemStack(Material.GREEN_STAINED_GLASS),
            Theme.MACHINE,
            "網路監控器",
            "網路監控器可以讓相鄰",
            "對象進行簡單的 輸入/輸出",
            "互動.",
            "",
            "目前支持:",
            "無限附加 - 儲存單元",
            "網路 - 網路記憶體外殼"
        );

        NETWORK_IMPORT = Theme.themedSlimefunItemStack(
            "NTW_IMPORT",
            new ItemStack(Material.RED_STAINED_GLASS),
            Theme.MACHINE,
            "網路輸入器",
            "網路輸入器將在",
            "其內部的任何物品, 輸入進網路,",
            "每黏液科技的tick 最多可以儲存九組.",
            "接受來自物流的物品."
        );

        NETWORK_EXPORT = Theme.themedSlimefunItemStack(
            "NTW_EXPORT",
            new ItemStack(Material.BLUE_STAINED_GLASS),
            Theme.MACHINE,
            "網路輸出器",
            "網路輸出器可以",
            "設置為不斷導出任何",
            "所指定的物品一組.",
            "接受從物流中提取的物品."
        );

        NETWORK_GRABBER = Theme.themedSlimefunItemStack(
            "NTW_GRABBER",
            new ItemStack(Material.MAGENTA_STAINED_GLASS),
            Theme.MACHINE,
            "網路抓取器",
            "網路抓取器將嘗試從",
            "選定的機器中抓取",
            "它第一個找到的物品."
        );

        NETWORK_PUSHER = Theme.themedSlimefunItemStack(
            "NTW_PUSHER",
            new ItemStack(Material.BROWN_STAINED_GLASS),
            Theme.MACHINE,
            "網路推送器",
            "網路推送器將嘗試",
            "推送匹配的物品",
            "到所選的機器中."
        );

        NETWORK_VANILLA_GRABBER = Theme.themedSlimefunItemStack(
            "NTW_VANILLA_GRABBER",
            new ItemStack(Material.ORANGE_STAINED_GLASS),
            Theme.MACHINE,
            "網路原版抓取器",
            "網路原版抓取器將會嘗試",
            "從原版容器中抓取",
            "第一個可抓取的物品.",
            "你需要通過網路抓取器",
            "來抓取這個節點的物品."
        );

        NETWORK_VANILLA_PUSHER = Theme.themedSlimefunItemStack(
            "NTW_VANILLA_PUSHER",
            new ItemStack(Material.LIME_STAINED_GLASS),
            Theme.MACHINE,
            "網路原版推送器",
            "網路原版推送器將嘗試推送",
            "任何在內的物品到",
            "選擇的原版容器中.",
            "你需要通過網路推送器",
            "來推送物品到這個節點."
        );

        NETWORK_WIRELESS_TRANSMITTER = Theme.themedSlimefunItemStack(
            "NTW_NETWORK_WIRELESS_TRANSMITTER",
            new ItemStack(Material.CYAN_STAINED_GLASS),
            Theme.MACHINE,
            "網路無線傳輸器",
            "網路無線傳輸器將會",
            "嘗試傳輸任何在內的",
            "物品到連結於同一個",
            "世界的網路無線接收器.",
            "使用網路無線配置器",
            "來設定無線傳輸器.",
            "每次傳輸需要 7500 網路能源."
        );

        NETWORK_WIRELESS_RECEIVER = Theme.themedSlimefunItemStack(
            "NTW_NETWORK_WIRELESS_RECEIVER",
            new ItemStack(Material.PURPLE_STAINED_GLASS),
            Theme.MACHINE,
            "網路無線接收器",
            "網路無線接受器能夠",
            "接收從連結在同一個",
            "世界的網路無線傳輸器",
            "內的物品.",
            "它將會在每 Tick 中",
            "嘗試接收推送的物品."
        );

        NETWORK_PURGER = Theme.themedSlimefunItemStack(
            "NTW_TRASH",
            new ItemStack(Material.OBSERVER),
            Theme.MACHINE,
            "網路清理器",
            "網路清理器將從",
            "網路中拉出匹配的物品,",
            "並立即丟入虛空銷毀.",
            "請小心使用!"
        );

        NETWORK_GRID = Theme.themedSlimefunItemStack(
            "NTW_GRID",
            new ItemStack(Material.NOTE_BLOCK),
            Theme.MACHINE,
            "網路格",
            "網路格可以顯示",
            "你所有在網路內的物品,",
            "並讓你直接輸入或輸出",
            "物品."
        );

        NETWORK_CRAFTING_GRID = Theme.themedSlimefunItemStack(
            "NTW_CRAFTING_GRID",
            new ItemStack(Material.REDSTONE_LAMP),
            Theme.MACHINE,
            "網路製作格",
            "網路製作格類似普通的網路格,",
            "但顯示的物品更少,",
            "可以允許你直接使用來自",
            "網路內的物品進行合成."
        );

        NETWORK_CELL = Theme.themedSlimefunItemStack(
            "NTW_CELL",
            new ItemStack(Material.HONEYCOMB_BLOCK),
            Theme.MACHINE,
            "網路單元",
            "網路單元是一個大型的",
            "儲存空間 (大型儲物箱),",
            "可以從網路與世界上",
            "進行訪問."
        );

        NETWORK_GREEDY_BLOCK = Theme.themedSlimefunItemStack(
            "NTW_GREEDY_BLOCK",
            new ItemStack(Material.SHROOMLIGHT),
            Theme.MACHINE,
            "網路貪婪方塊",
            "網路貪婪方塊可以",
            "設定一個物品,",
            "它將會貪婪的",
            "擁有一組物品. 如果傳入的",
            "物品不符合, 它們將不會",
            "進入網路."
        );

        NETWORK_QUANTUM_WORKBENCH = Theme.themedSlimefunItemStack(
            "NTW_QUANTUM_WORKBENCH",
            new ItemStack(Material.DRIED_KELP_BLOCK),
            Theme.MACHINE,
            "網路量子工作台",
            "可以讓你製作量子儲物箱."
        );


        NETWORK_QUANTUM_STORAGE_1 = Theme.themedSlimefunItemStack(
            "NTW_QUANTUM_STORAGE_1",
            new ItemStack(Material.WHITE_TERRACOTTA),
            Theme.MACHINE,
            "網路量子儲物箱 (4K)",
            "儲存 " + NetworkQuantumStorage.getSizes()[0] + " 個物品",
            "",
            "在一個量子奇點內儲存",
            "大量的物品."
        );

        NETWORK_QUANTUM_STORAGE_2 = Theme.themedSlimefunItemStack(
            "NTW_QUANTUM_STORAGE_2",
            new ItemStack(Material.LIGHT_GRAY_TERRACOTTA),
            Theme.MACHINE,
            "網路量子儲物箱 (32K)",
            "儲存 " + NetworkQuantumStorage.getSizes()[1] + " 個物品",
            "",
            "在一個量子奇點內儲存",
            "大量的物品."
        );

        NETWORK_QUANTUM_STORAGE_3 = Theme.themedSlimefunItemStack(
            "NTW_QUANTUM_STORAGE_3",
            new ItemStack(Material.GRAY_TERRACOTTA),
            Theme.MACHINE,
            "網路量子儲物箱 (262K)",
            "儲存 " + NetworkQuantumStorage.getSizes()[2] + " 個物品",
            "",
            "在一個量子奇點內儲存",
            "大量的物品."
        );

        NETWORK_QUANTUM_STORAGE_4 = Theme.themedSlimefunItemStack(
            "NTW_QUANTUM_STORAGE_4",
            new ItemStack(Material.BROWN_TERRACOTTA),
            Theme.MACHINE,
            "網路量子儲物箱 (2M)",
            "儲存 " + NetworkQuantumStorage.getSizes()[3] + " 個物品",
            "",
            "在一個量子奇點內儲存",
            "大量的物品."
        );

        NETWORK_QUANTUM_STORAGE_5 = Theme.themedSlimefunItemStack(
            "NTW_QUANTUM_STORAGE_5",
            new ItemStack(Material.BLACK_TERRACOTTA),
            Theme.MACHINE,
            "網路量子儲物箱 (16M)",
            "儲存 " + NetworkQuantumStorage.getSizes()[4] + " 個物品",
            "",
            "在一個量子奇點內儲存",
            "大量的物品."
        );

        NETWORK_QUANTUM_STORAGE_6 = Theme.themedSlimefunItemStack(
            "NTW_QUANTUM_STORAGE_6",
            new ItemStack(Material.PURPLE_TERRACOTTA),
            Theme.MACHINE,
            "網路量子儲物箱 (134M)",
            "儲存 " + NetworkQuantumStorage.getSizes()[5] + " 個物品",
            "",
            "在一個量子奇點內儲存",
            "大量的物品."
        );

        NETWORK_QUANTUM_STORAGE_7 = Theme.themedSlimefunItemStack(
            "NTW_QUANTUM_STORAGE_7",
            new ItemStack(Material.MAGENTA_TERRACOTTA),
            Theme.MACHINE,
            "網路量子儲物箱 (1B)",
            "儲存 " + NetworkQuantumStorage.getSizes()[6] + " 個物品",
            "",
            "在一個量子奇點內儲存",
            "大量的物品."
        );

        NETWORK_QUANTUM_STORAGE_8 = Theme.themedSlimefunItemStack(
            "NTW_QUANTUM_STORAGE_8",
            new ItemStack(Material.RED_TERRACOTTA),
            Theme.MACHINE,
            "網路量子儲物箱 (∞)",
            "儲存 ∞ 個物品... 幾乎",
            "",
            "在一個量子奇點內儲存",
            "大量的物品."
        );

        NETWORK_CAPACITOR_1 = Theme.themedSlimefunItemStack(
            "NTW_CAPACITOR_1",
            new ItemStack(Material.BROWN_GLAZED_TERRACOTTA),
            Theme.MACHINE,
            "網路電容 (1)",
            "網路電容可以獲取",
            "電力並將其儲存在",
            "網路中使用.",
            "",
            MessageFormat.format("{0}容量: {1}{2}", Theme.CLICK_INFO, Theme.PASSIVE, 1000)
        );

        NETWORK_CAPACITOR_2 = Theme.themedSlimefunItemStack(
            "NTW_CAPACITOR_2",
            new ItemStack(Material.GREEN_GLAZED_TERRACOTTA),
            Theme.MACHINE,
            "網路電容 (2)",
            "網路電容可以獲取",
            "電力並將其儲存在",
            "網路中使用.",
            "",
            MessageFormat.format("{0}容量: {1}{2}", Theme.CLICK_INFO, Theme.PASSIVE, 10000)
        );

        NETWORK_CAPACITOR_3 = Theme.themedSlimefunItemStack(
            "NTW_CAPACITOR_3",
            new ItemStack(Material.BLACK_GLAZED_TERRACOTTA),
            Theme.MACHINE,
            "網路電容 (3)",
            "網路電容可以獲取",
            "電力並將其儲存在",
            "網路中使用.",
            "",
            MessageFormat.format("{0}容量: {1}{2}", Theme.CLICK_INFO, Theme.PASSIVE, 100000)
        );

        NETWORK_CAPACITOR_4 = Theme.themedSlimefunItemStack(
                "NTW_CAPACITOR_4",
                new ItemStack(Material.GRAY_GLAZED_TERRACOTTA),
                Theme.MACHINE,
                "網路電容 (4)",
                "網路電容可以獲取",
                "電力並將其儲存在",
                "網路中使用.",
                "",
                MessageFormat.format("{0}容量: {1}{2}", Theme.CLICK_INFO, Theme.PASSIVE, 1000000)
        );

        NETWORK_POWER_OUTLET_1 = Theme.themedSlimefunItemStack(
            "NTW_POWER_OUTLET_1",
            new ItemStack(Material.YELLOW_GLAZED_TERRACOTTA),
            Theme.MACHINE,
            "網路電源插座 (1)",
            "可以從網路電容中",
            "拿取電力來為機器",
            "供電或反饋回",
            "能源網路中.",
            "",
            "以 20% 損失率運行.",
            "",
            MessageFormat.format("{0}最大傳輸: {1}{2}", Theme.CLICK_INFO, Theme.PASSIVE, 500)
        );

        NETWORK_POWER_OUTLET_2 = Theme.themedSlimefunItemStack(
            "NTW_POWER_OUTLET_2",
            new ItemStack(Material.RED_GLAZED_TERRACOTTA),
            Theme.MACHINE,
            "網路電源插座 (2)",
            "可以從網路電容中",
            "拿取電力來為機器",
            "供電或反饋回",
            "能源網路中.",
            "",
            "以 20% 損失率運行.",
            "",
            MessageFormat.format("{0}最大傳輸: {1}{2}", Theme.CLICK_INFO, Theme.PASSIVE, 2000)
        );

        NETWORK_POWER_DISPLAY = Theme.themedSlimefunItemStack(
            "NTW_POWER_DISPLAY",
            new ItemStack(Material.TINTED_GLASS),
            Theme.MACHINE,
            "網路電量顯示器",
            "網路電量顯示器",
            "將會顯示網路中的電量.",
            "很簡單, 對吧?"
        );

        NETWORK_RECIPE_ENCODER = Theme.themedSlimefunItemStack(
            "NTW_RECIPE_ENCODER",
            new ItemStack(Material.TARGET),
            Theme.MACHINE,
            "網路配方編碼器",
            "用於從輸入進的物品",
            "形成製作藍圖.",
            "",
            MessageFormat.format("{0}網路流失: {1}{2}/編碼", Theme.CLICK_INFO, Theme.PASSIVE, 20000)
        );

        NETWORK_AUTO_CRAFTER = Theme.themedSlimefunItemStack(
            "NTW_AUTO_CRAFTER",
            new ItemStack(Material.BLACK_GLAZED_TERRACOTTA),
            Theme.MACHINE,
            "網路自動製作器",
            "網路自動製作器接受",
            "製作藍圖. 當藍圖",
            "輸出物品被請求且",
            "網路中沒有該請求物品,",
            "它將會被自動製作出來",
            "當你有足夠的材料時.",
            "",
            MessageFormat.format("{0}網路流失: {1}{2}/製作", Theme.CLICK_INFO, Theme.PASSIVE, 64)
        );

        NETWORK_AUTO_CRAFTER_WITHHOLDING = Theme.themedSlimefunItemStack(
            "NTW_AUTO_CRAFTER_WITHHOLDING",
            new ItemStack(Material.WHITE_GLAZED_TERRACOTTA),
            Theme.MACHINE,
            "網路自動製作器 (預留版)",
            "網路自動製作器接受",
            "製作藍圖. 當藍圖",
            "輸出物品被請求且",
            "網路中沒有該請求物品,",
            "它將會被自動製作出來",
            "當你有足夠的材料時.",
            "",
            "預留版製作器將保持",
            "一組製作物在輸出區,",
            "並停止製作. 該一組物品",
            "可以在網路中看到,",
            "也可以使用物流.",
            "",
            MessageFormat.format("{0}網路流失: {1}{2}/製作", Theme.CLICK_INFO, Theme.PASSIVE, 128)
        );

        CRAFTING_BLUEPRINT = Theme.themedSlimefunItemStack(
            "NTW_CRAFTING_BLUEPRINT",
            new ItemStack(Material.BLUE_DYE),
            Theme.TOOL,
            "製作藍圖",
            "一張空的藍圖,",
            "可以用於儲存",
            "製作配方."
        );

        NETWORK_PROBE = Theme.themedSlimefunItemStack(
            "NTW_PROBE",
            new ItemStack(Material.CLOCK),
            Theme.TOOL,
            "網路探測器",
            "當使用在控制器上時,",
            "將會顯示這個網路上所有的節點資訊."
        );

        NETWORK_REMOTE = Theme.themedSlimefunItemStack(
            "NTW_REMOTE",
            new ItemStack(Material.PAINTING),
            Theme.TOOL,
            "網路遠端遙控",
            "無線的方式打開一個綁定的網路格.",
            "該網路格必須有區塊加載.",
            "",
            MessageFormat.format("{0}範圍: {1}{2}", Theme.CLICK_INFO, Theme.PASSIVE, NetworkRemote.getRanges()[0])
        );

        NETWORK_REMOTE_EMPOWERED = Theme.themedSlimefunItemStack(
            "NTW_REMOTE_EMPOWERED",
            new ItemStack(Material.ITEM_FRAME),
            Theme.TOOL,
            "網路遠端遙控 - 充能",
            "無線的方式打開一個綁定的網路格.",
            "該網路格必須有區塊加載.",
            "",
            MessageFormat.format("{0}範圍: {1}{2}", Theme.CLICK_INFO, Theme.PASSIVE, NetworkRemote.getRanges()[1])
        );

        NETWORK_REMOTE_PRISTINE = Theme.themedSlimefunItemStack(
            "NTW_REMOTE_PRISTINE",
            new ItemStack(Material.GLOW_ITEM_FRAME),
            Theme.TOOL,
            "網路遠端遙控 - 原始版",
            "無線的方式打開一個綁定的網路格.",
            "該網路格必須有區塊加載.",
            "",
            MessageFormat.format("{0}範圍: {1}{2}", Theme.CLICK_INFO, Theme.PASSIVE, "無限")
        );

        NETWORK_REMOTE_ULTIMATE = Theme.themedSlimefunItemStack(
            "NTW_REMOTE_ULTIMATE",
            getPreEnchantedItemStack(Material.GLOW_ITEM_FRAME, true, new Pair<>(Enchantment.ARROW_DAMAGE, 1)),
            Theme.TOOL,
            "網路遠端遙控 - 終極",
            "無線的方式打開一個綁定的網路格.",
            "該網路格必須有區塊加載.",
            "",
            MessageFormat.format("{0}範圍: {1}{2}", Theme.CLICK_INFO, Theme.PASSIVE, "跨維度")
        );

        NETWORK_CRAYON = Theme.themedSlimefunItemStack(
            "NTW_CRAYON",
            new ItemStack(Material.RED_CANDLE),
            Theme.TOOL,
            "網路蠟筆",
            "當使用在控制器時,",
            "這將在正在工作的特定方塊上",
            "顯示粒子效果."
        );

        NETWORK_CONFIGURATOR = Theme.themedSlimefunItemStack(
            "NTW_CONFIGURATOR",
            new ItemStack(Material.BLAZE_ROD),
            Theme.TOOL,
            "網路設定器",
            "用來複製貼上",
            "方向接口的",
            "設定.",
            "",
            MessageFormat.format("{0}右鍵點擊: {1}{2}", Theme.CLICK_INFO, Theme.PASSIVE, "添加設定"),
            MessageFormat.format("{0}Shift + 右鍵點擊: {1}{2}", Theme.CLICK_INFO, Theme.PASSIVE, "儲存設定")
        );

        NETWORK_WIRELESS_CONFIGURATOR = Theme.themedSlimefunItemStack(
            "NTW_WIRELESS_CONFIGURATOR",
            new ItemStack(Material.BLAZE_ROD),
            Theme.TOOL,
            "網路無線配置器",
            "用於儲存接收器的座標",
            "並套用到傳輸器",
            "",
            MessageFormat.format("{0}右鍵點擊: {1}{2}", Theme.CLICK_INFO, Theme.PASSIVE, "儲存接收器座標"),
            MessageFormat.format("{0}Shift + 右鍵點擊: {1}{2}", Theme.CLICK_INFO, Theme.PASSIVE, "設定傳輸器的座標")
        );

        NETWORK_RAKE_1 = Theme.themedSlimefunItemStack(
            "NTW_RAKE_1",
            new ItemStack(Material.TWISTING_VINES),
            Theme.TOOL,
            "網絡掃射 (1)",
            "右鍵點擊網絡物件",
            "以立即破壞它.",
            "",
            ChatColor.YELLOW + "剩餘次數 " + ChatColor.GRAY + "250次"
        );

        NETWORK_RAKE_2 = Theme.themedSlimefunItemStack(
            "NTW_RAKE_2",
            new ItemStack(Material.WEEPING_VINES),
            Theme.TOOL,
            "網絡掃射 (2)",
            "右鍵點擊網絡物件",
            "以立即破壞它.",
            "",
            ChatColor.YELLOW + "剩餘次數 " + ChatColor.GRAY + "1000次"
        );

        NETWORK_RAKE_3 = Theme.themedSlimefunItemStack(
            "NTW_RAKE_3",
            getPreEnchantedItemStack(Material.WEEPING_VINES, true, new Pair<>(Enchantment.LUCK, 1)),
            Theme.TOOL,
            "網絡掃射 (3)",
            "右鍵點擊網絡物件",
            "以立即破壞它.",
            "",
            ChatColor.YELLOW + "剩餘次數 " + ChatColor.GRAY + "9999次"
        );
    }

    @Nonnull
    @SafeVarargs
    public static ItemStack getPreEnchantedItemStack(Material material, boolean hide, @Nonnull Pair<Enchantment, Integer>... enchantments) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        for (Pair<Enchantment, Integer> pair : enchantments) {
            itemMeta.addEnchant(pair.getFirstValue(), pair.getSecondValue(), true);
        }
        if (hide) {
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
