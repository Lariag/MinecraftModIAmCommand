package com.alriac.iam;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
    @SubscribeEvent
    public void ServerChatEvent(ServerChatEvent event){
        if(IAm.playernames.containsKey(event.getUsername().toLowerCase())){
            event.setCanceled(true);
            event.getPlayer().mcServer.getPlayerList().sendChatMsg(new TextComponentString("<"+event.getUsername()+"> I am "+IAm.playernames.get(event.getUsername().toLowerCase())));
        }
    }
}
