package com.acrobot.chestshop.towny.listeners;

import com.Acrobot.ChestShop.Events.Protection.BuildPermissionEvent;
import com.acrobot.chestshop.towny.Permission;
import com.acrobot.chestshop.towny.properties.Properties;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static com.acrobot.chestshop.towny.TownyUtils.*;

/**
 * @author Acrobot
 */
public class PlotListener implements Listener {

    @EventHandler
    public static void canBuild(BuildPermissionEvent event) {
        Location chest = event.getChest();
        Location sign = event.getSign();

        if (Permission.has(event.getPlayer(), Permission.PROTECTION_BYPASS)) {
            event.allow();
            return;
        }

        if (isInWilderness(chest, sign) || (Properties.BUILDING_INSIDE_SHOP_PLOTS && !isInsideShopPlot(chest, sign))) {
            event.disallow();
            return;
        }

        boolean allow;

        if (Properties.SHOPS_FOR_OWNERS_ONLY) {
            allow = isPlotOwner(event.getPlayer(), chest, sign);
        } else {
            allow = isPlotOwner(event.getPlayer(), chest, sign) || isResident(event.getPlayer(), chest, sign);
        }

        event.allow(allow);
    }
}
