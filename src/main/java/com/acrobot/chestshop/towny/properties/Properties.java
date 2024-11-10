package com.acrobot.chestshop.towny.properties;

import com.Acrobot.Breeze.Configuration.Annotations.ConfigurationComment;

/**
 * @author Acrobot
 */
public class Properties {

    @ConfigurationComment("Should people only be able to build shops inside plots?")
    public static final boolean BUILDING_INSIDE_PLOTS = true;

    @ConfigurationComment("Should people only be able to build shops inside commercial plots?")
    public static final boolean BUILDING_INSIDE_SHOP_PLOTS = true;

    @ConfigurationComment("If true, only plot owners are able to build inside a shop plot. If false, every town's resident is able to build there.")
    public static final boolean SHOPS_FOR_OWNERS_ONLY = true;
}
