package com.acrobot.chestshop.towny.listeners;

import com.Acrobot.ChestShop.Events.AccountQueryEvent;
import com.acrobot.chestshop.towny.TownyUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class AccountQueryListener implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void onAccountQuery(AccountQueryEvent event) {
        String name = event.getName();
        if (TownyUtils.isTownShop(name)) {
            event.setAccount(TownyUtils.getTownAccount(name));
        } else if (TownyUtils.isNationShop(name)) {
            event.setAccount(TownyUtils.getNationAccount(name));
        }
    }
}
