package com.acrobot.chestshop.towny;

import org.bukkit.entity.Player;

/**
 * @author Acrobot
 */
public enum Permission {
    PROTECTION_BYPASS("ChestShop.towny.bypass"),
    TOWN_SHOP("ChestShop.towny.townshop"),
    NATION_SHOP("ChestShop.towny.nationshop");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public static boolean has(Player player, Permission permission) {
        return has(player, permission.permission);
    }

    public static boolean has(Player player, String node) {
        return player.hasPermission(node) || player.hasPermission(node.toLowerCase());
    }

    public String toString() {
        return permission;
    }
}
