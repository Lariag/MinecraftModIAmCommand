package com.alriac.iam;


import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class IamCommand implements ICommand {

    private final List aliases;

    protected String fullEntityName;

    public IamCommand()
    {
        aliases = new ArrayList();
        aliases.add("iam");
    }

    @Override
    public String getCommandName()
    {
        return "iam";

    }

    @Override
    public String getCommandUsage(ICommandSender var1)
    {
        return "iam <targetPlayerName> [customName]";
    }

    @Override
    public List getCommandAliases()
    {
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if(!sender.canCommandSenderUseCommand(3, getCommandName())){
            sender.addChatMessage(new ChatComponentText("Error: you are not worthy"));
            return;
        }

        if(args.length == 0)
        {
            sender.addChatMessage(new ChatComponentText("Usage: iam <targetPlayerName> [customName]"));
            return;
        }else if(args.length == 1){
            if(args[0].toLowerCase().equals("?")){
                sender.addChatMessage(new ChatComponentText("\"I am\" will "+(ConfigHandler.addIamAtTheBeginning?"":"not")+" be added."));
            }else if(IAm.addName(args[0].toLowerCase().toLowerCase(), "")){
                sender.addChatMessage(new ChatComponentText("Adding I am mode to " + args[0]));
            }else{
                sender.addChatMessage(new ChatComponentText("Removing I am mode from " + args[0]));
            }
        }else {
            if(args[0].toLowerCase().equals("clear") && args[1].toLowerCase().equals("all")){
                int deletedNames = IAm.clearNames();
                sender.addChatMessage(new ChatComponentText("Deleted "+deletedNames+" I am entries"));
            }else {
                String completeName = "";
                for (int i = 1; i < args.length; i++) completeName += args[i] + ' ';
                if (IAm.addName(args[0].toLowerCase(), completeName)) {
                    sender.addChatMessage(new ChatComponentText("Adding I am mode to " + args[0] + " as " + completeName));
                }
            }
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {
        return null;
    }


    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
