package com.acrobot.chestshop.towny;

import org.bukkit.entity.Player;

/**
 * @author Acrobot
 */
public enum Permission {
    PROTECTION_BYPASS("ChestShop.towny.bypass"),
    TOWN_SHOP("ChestShop.towny.create.townshop"),
    TOWN_SHOP_BUY("ChestShop.towny.create.townshop.buy"),
    TOWN_SHOP_SELL("ChestShop.towny.create.townshop.sell"),
    NATION_SHOP("ChestShop.towny.create.nationshop"),
    NATION_SHOP_BUY("ChestShop.towny.create.nationshop.buy"),
    NATION_SHOP_SELL("ChestShop.towny.create.nationshop.sell");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public static boolean has(Player player, Permission... permissions) {
        for (Permission permission : permissions) {
            if (has(player, permission.permission))
                return true;
        }
        return false;
    }

    public static boolean has(Player player, String node) {
        return player.hasPermission(node) || player.hasPermission(node.toLowerCase());
    }

    public String toString() {
        return permission;
    }
}
