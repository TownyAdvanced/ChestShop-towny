package com.acrobot.chestshop.towny.listeners;

import com.Acrobot.ChestShop.Events.Protection.ProtectionCheckEvent;
import com.Acrobot.ChestShop.Signs.ChestShopSign;
import com.Acrobot.ChestShop.Utils.uBlock;
import com.acrobot.chestshop.towny.TownyUtils;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ProtectionCheckListener implements Listener {

    @EventHandler
    public void onProtectionCheck(ProtectionCheckEvent event) {
        if (event.getResult() == Event.Result.DENY || event.isBuiltInProtectionIgnored()) {
            return;
        }

        Player player = event.getPlayer();
        if (com.Acrobot.ChestShop.Permission.has(player, com.Acrobot.ChestShop.Permission.ADMIN))
            return;

        Block block = event.getBlock();

        if (uBlock.couldBeShopContainer(block)) {
            Sign sign = uBlock.getConnectedSign(block);

            if (sign == null)
                return;

            TownyUtils.checkShopPerms(
                    player,
                    ChestShopSign.getOwner(sign),
                    ChestShopSign.getPrice(sign),
                    () -> event.setResult(Event.Result.DENY));
        }
    }
}
