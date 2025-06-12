package com.acrobot.chestshop.towny.listeners;

import com.Acrobot.ChestShop.Events.Economy.CurrencyAddEvent;
import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Town;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class CurrencyAddListener implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public static void onCurrencyAdd(CurrencyAddEvent event) {
        if (event.wasHandled()) {
            return;
        }

        Town town = TownyAPI.getInstance().getTown(event.getTarget());

        if (town != null) {
            town.getAccount().deposit(event.getAmount().doubleValue(), "Purchase from town shop.");
            event.setHandled(true);
            return;
        }

        Nation nation = TownyAPI.getInstance().getNation(event.getTarget());

        if (nation != null) {
            nation.getAccount().deposit(event.getAmount().doubleValue(), "Purchase from nation shop.");
            event.setHandled(true);
        }
    }
}
