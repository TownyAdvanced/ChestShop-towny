package com.acrobot.chestshop.towny.listeners;

import com.Acrobot.ChestShop.Events.TransactionEvent;
import com.acrobot.chestshop.towny.TownyUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class TransactionListener implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void onTransaction(TransactionEvent event) {
        String name = event.getOwnerAccount().getName();
        if (TownyUtils.isTownShop(name)) {
            event.getOwnerAccount().setName(TownyUtils.getTownNameFromPrefixedName(name));
        } else if (TownyUtils.isNationShop(name)) {
            event.getOwnerAccount().setName(TownyUtils.getNationNameFromPrefixedName(name));
        }
    }
}
