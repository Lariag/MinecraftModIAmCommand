package com.alriac.iam;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

public class ConfigHandler {
    public static Configuration config;
    public static boolean addIamAtTheBeginning = true;

    public static void init(File file) {
        config = new Configuration(file);
        loadConfig();
    }

    public static void loadConfig() {
        config.addCustomCategoryComment("I AM Config", "Use this config file to enable or disable the addition " +
                "of \"I am\" at the beginning of what the affected players say.\nIf set to false, you can always" +
                " write it manually.\n" +
                "Also, the command \"iam ?\" will tell you if this option is active or not.");
        addIamAtTheBeginning = config.getBoolean("addIamAtTheBeginning", "I AM Config", true, "Enable or disable the text \"I am\" at the begginig of what the players say.");
        config.save();


    }
}
