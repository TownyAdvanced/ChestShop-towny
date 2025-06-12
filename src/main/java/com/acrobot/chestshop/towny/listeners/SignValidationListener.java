package com.acrobot.chestshop.towny.listeners;

import com.Acrobot.ChestShop.Events.SignValidationEvent;
import com.acrobot.chestshop.towny.TownyUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class SignValidationListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onSignValidation(SignValidationEvent event) {
        String owner = event.getOwner();
        if (TownyUtils.isTownShop(owner) || TownyUtils.isNationShop(owner)) {
            event.setValid(true);
        }
    }
}
