package com.acrobot.chestshop.towny;

import com.Acrobot.ChestShop.Database.Account;
import com.acrobot.chestshop.towny.properties.Properties;
import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.TownyUniverse;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownBlockOwner;
import com.palmergames.bukkit.towny.object.TownBlockType;
import com.palmergames.bukkit.towny.object.economy.BankAccount;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * @author Acrobot
 */
public class TownyUtils {

    final static String townShopPrefix = Properties.TOWN_SHOP_PREFIX;
    final static String nationShopPrefix = Properties.NATION_SHOP_PREFIX;

    /**
     * Checks if the player is a resident of a given location
     * @param player Player to check
     * @param location Location
     * @return Is the player a resident of this location?
     */
    public static boolean isResident(Player player, Location location) {
        try {
            TownBlock townBlock = TownyAPI.getInstance().getTownBlock(location);
            return townBlock != null && townBlock.getTown().hasResident(player.getName());
        } catch (NotRegisteredException ex) {
            return false;
        }
    }

    /**
     * Checks if the player is a resident of given locations
     * @param player Player to check
     * @param locations Locations
     * @return Is the player a resident of those locations?
     */
    public static boolean isResident(Player player, Location... locations) {
        for (Location location : locations) {
            if (!isResident(player, location)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if the player is the plot owner of the given location
     * @param player Player to check
     * @param location Location
     * @return Is the player the plot owner of this location?
     */
    public static boolean isPlotOwner(Player player, Location location) {
        TownBlockOwner owner = TownyUniverse.getInstance().getResident(player.getName());
        TownBlock townBlock = TownyAPI.getInstance().getTownBlock(location);
        return townBlock != null && owner != null && townBlock.isOwner(owner);
    }

    /**
     * Checks if the player is the plot owner of the given locations
     * @param player Player to check
     * @param locations Locations
     * @return Is the player the plot owner of this locations?
     */
    public static boolean isPlotOwner(Player player, Location... locations) {
        for (Location location : locations) {
            if (isInWilderness(location) || !isPlotOwner(player, location)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if the location is in wilderness
     * @param location Location
     * @return Is the location in wilderness?
     */
    public static boolean isInWilderness(Location location) {
        return TownyAPI.getInstance().isWilderness(location);
    }

    /**
     * Checks if the locations are in wilderness
     * @param locations Locations
     * @return Are the locations in wilderness?
     */
    public static boolean isInWilderness(Location... locations) {
        for (Location location : locations) {
            if (location != null && !isInWilderness(location)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if the location is inside shop plot
     * @param location Location to check
     * @return Is the location inside shop plot?
     */
    public static boolean isInsideShopPlot(Location location) {
        TownBlock townBlock = TownyAPI.getInstance().getTownBlock(location);
        return townBlock != null && townBlock.getType() == TownBlockType.COMMERCIAL;
    }

    /**
     * Checks if the locations are inside shop plots
     * @param locations Locations to check
     * @return Are the location inside shop plots?
     */
    public static boolean isInsideShopPlot(Location... locations) {
        for (Location location : locations) {
            if (location != null && !isInsideShopPlot(location)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isTownShop(String owner) {
        int prefixLength = townShopPrefix.length();
        String strippedOwner = owner.replace(" ", "");
        // Check if sign line is less than the length of the townShopPrefix and that it contains the townShopPrefix
        if (strippedOwner.length() < prefixLength || !strippedOwner.startsWith(townShopPrefix))
            return false;

        return !TownyUtils.getTownNameFromPrefixedName(strippedOwner).isEmpty();
    }

    public static Account getTownAccount(String name) {
        Town town = TownyAPI.getInstance().getTown(TownyUtils.getTownNameFromPrefixedName(name));
        BankAccount townAccount = town.getAccount();
        String accountName = townShopPrefix.concat(town.getName());
        return new Account(accountName, townAccount.getUUID());
    }

    public static String getTownNameFromPrefixedName(String prefixedName) {
        // Remove town shop townShopPrefix
        String strippedName = prefixedName.substring(townShopPrefix.length());
        for (Town town : TownyAPI.getInstance().getTowns()) {
            String townName = town.getName();
            if (townName.equalsIgnoreCase(strippedName)) {
                return townName;
            }
        }
        return "";
    }

    public static boolean isNationShop(String owner) {
        int prefixLength = nationShopPrefix.length();
        String strippedOwner = owner.replace(" ", "");
        // Check if sign line is less than the length of the nation shop prefix and that it contains the nationShopPrefix
        if (strippedOwner.length() < prefixLength || !strippedOwner.startsWith(nationShopPrefix))
            return false;

        return !TownyUtils.getNationNameFromPrefixedName(strippedOwner).isEmpty();
    }

    public static Account getNationAccount(String name) {
        Nation nation = TownyAPI.getInstance().getNation(TownyUtils.getNationNameFromPrefixedName(name));
        BankAccount nationAccount = nation.getAccount();
        String accountName = nationShopPrefix.concat(nation.getName());
        return new Account(accountName, nationAccount.getUUID());
    }

    public static String getNationNameFromPrefixedName(String prefixedName) {
        // Remove nation shop nationShopPrefix
        String strippedName = prefixedName.substring(nationShopPrefix.length());
        for (Nation nation : TownyAPI.getInstance().getNations()) {
            String nationName = nation.getName();
            if (nationName.equalsIgnoreCase(strippedName)) {
                return nationName;
            }
        }
        return "";
    }
}
