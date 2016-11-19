package com.alriac.iam;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
    @SubscribeEvent
    public void ServerChatEvent(ServerChatEvent event){
        if(IAm.playernames.containsKey(event.getUsername().toLowerCase())){
            event.setCanceled(true);
            String newText = "<"+event.getUsername()+"> ";
            if(ConfigHandler.addIamAtTheBeginning){
                if(ConfigHandler.textToAddAtTheBeginning != null && !ConfigHandler.textToAddAtTheBeginning.equals(""))
                newText += ConfigHandler.textToAddAtTheBeginning+' ';
                else newText += "I am ";
            }else{
                newText += "";
            }
            newText+=IAm.playernames.get(event.getUsername().toLowerCase());
            event.getPlayer().mcServer.getPlayerList().sendChatMsg(new TextComponentString(newText));
        }
    }
}
