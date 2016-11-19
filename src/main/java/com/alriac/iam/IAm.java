package com.alriac.iam;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

import java.io.File;
import java.util.HashMap;

@Mod(modid = IAm.MODID, version = IAm.VERSION, acceptableRemoteVersions = "*")
public class IAm
{
    public static final String MODID = "iam";
    public static final String VERSION = "1.1";

    static protected HashMap<String, String> playernames;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        playernames = IamLoader.LoadPlayerNames();
        MinecraftForge.EVENT_BUS.register(new com.alriac.iam.EventHandler());
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        try {
            File f = new File(event.getModConfigurationDirectory() + "/" + IAm.MODID);
            f.mkdirs();
            ConfigHandler.init(new File(f.getPath(), IAm.MODID + ".cfg"));
        }catch(Exception e){

        }
    }



    // Return true if name added, false if removed.
    protected static boolean addName(String player, String name){
        if(!playernames.containsKey(player)){
            playernames.put(player, name==null || name.length()==0 ? player:name);
            IamLoader.SavePlayerNames(playernames);
            return true;
        }else if(name!=null && name.length() > 0){
            playernames.replace(player, name);
            IamLoader.SavePlayerNames(playernames);
            return true;
        }else{
            playernames.remove(player);
            IamLoader.SavePlayerNames(playernames);
            return false;
        }
    }
    protected static int clearNames(){
        int amount = playernames.size();
        playernames.clear();
        IamLoader.SavePlayerNames(playernames);
        return amount;
    }


    @EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new IamCommand());
    }

}
