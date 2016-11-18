package com.alriac.iam;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import java.util.HashMap;

@Mod(modid = IAm.MODID, version = IAm.VERSION, acceptableRemoteVersions = "*")
public class IAm
{
    public static final String MODID = "iam";
    public static final String VERSION = "1.0";

    static protected HashMap<String, String> playernames;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        playernames = IamLoader.LoadPlayerNames();
        MinecraftForge.EVENT_BUS.register(new com.alriac.iam.EventHandler());
        //System.out.println("IAM Initialized: "+playernames.size()+" entries.");
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
