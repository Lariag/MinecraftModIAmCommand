package com.alriac.iam;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {
    public static Configuration config;
    public static boolean addIamAtTheBeginning = true;
    public static String textToAddAtTheBeginning = "I am";

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
        textToAddAtTheBeginning = config.getString("textToAddAtTheBeginning", "I AM Config","I am", "Change this text to whatever you want and if addIamAtTheBeginning is enabled, it will be used instead of I am");
        config.save();


    }
}
