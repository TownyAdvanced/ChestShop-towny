package com.acrobot.chestshop.towny.properties;

import com.Acrobot.Breeze.Configuration.Annotations.ConfigurationComment;

/**
 * @author Acrobot
 */
public class Properties {

    @ConfigurationComment("Should people only be able to build shops inside plots?")
    public static boolean BUILDING_INSIDE_PLOTS = true;

    @ConfigurationComment("Should people only be able to build shops inside commercial plots?")
    public static boolean BUILDING_INSIDE_SHOP_PLOTS = true;

    @ConfigurationComment("If true, only plot owners are able to build inside a shop plot. If false, every town's resident is able to build there.")
    public static boolean SHOPS_FOR_OWNERS_ONLY = true;

    @ConfigurationComment("Should shops that belong to a town be allowed?")
    public static boolean ALLOW_TOWN_SHOPS = true;

    @ConfigurationComment("What should the town name be prefixed with on the first line of the sign?")
    public static String TOWN_SHOP_PREFIX = "t-";

    @ConfigurationComment("Should shops that belong to a nation be allowed?")
    public static boolean ALLOW_NATION_SHOPS = true;

    @ConfigurationComment("What should the nation name be prefixed with on the first line of the sign?")
    public static String NATION_SHOP_PREFIX = "n-";

    @ConfigurationComment("Restrict chest access to players with permission for that specific shop type.")
    public static boolean CHEST_ACCESS_BY_PERMISSION = true;
}
