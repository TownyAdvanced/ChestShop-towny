package com.acrobot.chestshop.towny.listeners;

import com.Acrobot.ChestShop.Events.PreShopCreationEvent;
import com.Acrobot.ChestShop.Signs.ChestShopSign;
import com.acrobot.chestshop.towny.TownyUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import static com.Acrobot.ChestShop.Events.PreShopCreationEvent.CreationOutcome.NO_PERMISSION;

public class PreShopCreationListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPreShopCreation(PreShopCreationEvent event) {
        Player player = event.getPlayer();
        if (com.Acrobot.ChestShop.Permission.has(player, com.Acrobot.ChestShop.Permission.ADMIN))
            return;

        String[] signLines = event.getSignLines();

        TownyUtils.checkShopPerms(
                player,
                ChestShopSign.getOwner(signLines),
                ChestShopSign.getPrice(signLines),
                () -> event.setOutcome(NO_PERMISSION));
    }
}
