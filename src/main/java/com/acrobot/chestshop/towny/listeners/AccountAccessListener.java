package com.acrobot.chestshop.towny.listeners;

import com.Acrobot.ChestShop.ChestShop;
import com.Acrobot.ChestShop.Events.AccountAccessEvent;
import com.acrobot.chestshop.towny.Permission;
import com.acrobot.chestshop.towny.TownyUtils;
import com.palmergames.bukkit.towny.TownyAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class AccountAccessListener implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void onAccountAccess(AccountAccessEvent event) {
        String name = event.getAccount().getName();
        if (TownyUtils.isTownShop(name)) {
            if (Permission.has(event.getPlayer(), Permission.TOWN_SHOP)) {
                if (TownyAPI.getInstance().getTown(TownyUtils.getTownNameFromPrefixedName(name)) == TownyAPI.getInstance().getTown(event.getPlayer()) || com.Acrobot.ChestShop.Permission.has(event.getPlayer(), com.Acrobot.ChestShop.Permission.ADMIN)) {
                    event.setAccess(true);
                } else {
                    ChestShop.logDebug(event.getPlayer().getName() + " cannot use the name " + name + " as it's a town shop for a town that they do not belong to");
                    event.setAccess(false);
                }
            } else {
                ChestShop.logDebug(event.getPlayer().getName() + " cannot use the name " + name + " as it's a town shop and they don't have the permission " + Permission.TOWN_SHOP);
                event.setAccess(false);
            }
        } else if (TownyUtils.isNationShop(name)) {
            if (Permission.has(event.getPlayer(), Permission.NATION_SHOP)) {
                if (TownyAPI.getInstance().getNation(TownyUtils.getNationNameFromPrefixedName(name)) == TownyAPI.getInstance().getNation(event.getPlayer()) || com.Acrobot.ChestShop.Permission.has(event.getPlayer(), com.Acrobot.ChestShop.Permission.ADMIN)) {
                    event.setAccess(true);
                } else {
                    ChestShop.logDebug(event.getPlayer().getName() + " cannot use the name " + name + " as it's a nation shop for a nation that they do not belong to");
                    event.setAccess(false);
                }
            } else {
                ChestShop.logDebug(event.getPlayer().getName() + " cannot use the name " + name + " as it's a nation shop and they don't have the permission " + Permission.TOWN_SHOP);
                event.setAccess(false);
            }
        }
    }
}
