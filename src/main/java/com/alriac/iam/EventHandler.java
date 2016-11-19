package com.alriac.iam;


import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.ServerChatEvent;

import java.util.Random;

public class EventHandler {
    @SubscribeEvent
    public void ServerChatEvent(ServerChatEvent event){
        if(IAm.playernames.containsKey(event.username.toLowerCase())){
            event.setCanceled(true);
            MinecraftServer.getServer().getConfigurationManager().sendChatMsg(new ChatComponentText("<"+event.username+"> "+(ConfigHandler.addIamAtTheBeginning? "I am ":"")+IAm.playernames.get(event.username.toLowerCase())));
        }
    }
}
