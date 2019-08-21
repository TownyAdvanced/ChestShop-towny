package com.acrobot.chestshop.towny;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.TownBlockOwner;
import com.palmergames.bukkit.towny.object.TownBlockType;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * @author Acrobot
 */
public class TownyUtils {

    /**
     * Checks if the player is a resident of a given location
     * @param player Player to check
     * @param location Location
     * @return Is the player a resident of this location?
     */
    public static boolean isResident(Player player, Location location) {
        try {
            return TownyAPI.getInstance().getTownBlock(location).getTown().hasResident(player.getName());
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
        try {
            TownBlockOwner owner = TownyAPI.getInstance().getDataSource().getResident(player.getName());
            return TownyAPI.getInstance().getTownBlock(location).isOwner(owner);
        } catch (NotRegisteredException ex) {
            return false;
        }
    }

    /**
     * Checks if the player is the plot owner of the given locations
     * @param player Player to check
     * @param locations Locations
     * @return Is the player the plot owner of this locations?
     */
    public static boolean isPlotOwner(Player player, Location... locations) {
        for (Location location : locations) {
            if (!isPlotOwner(player, location)) {
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
        return TownyAPI.getInstance().getTownBlock(location).getType() == TownBlockType.COMMERCIAL;
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
}
