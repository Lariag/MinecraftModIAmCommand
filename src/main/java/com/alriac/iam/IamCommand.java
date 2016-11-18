package com.alriac.iam;


import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.EntityList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

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
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
            {
                if(!sender.canCommandSenderUseCommand(3, getCommandName())){
                    sender.addChatMessage(new TextComponentString("Error: you are not worthy"));
                    return;
                }

                if(args.length == 0)
                {
                    sender.addChatMessage(new TextComponentString("Usage: iam <targetPlayerName> [customName]"));
                    return;
                }else if(args.length == 1){
                    if(IAm.addName(args[0].toLowerCase().toLowerCase(), "")){
                        sender.addChatMessage(new TextComponentString("Adding I am mode to " + args[0]));
                    }else{
                        sender.addChatMessage(new TextComponentString("Removing I am mode from " + args[0]));
                    }
                }else {
                    if(args[0].toLowerCase().equals("clear") && args[1].toLowerCase().equals("all")){
                        int deletedNames = IAm.clearNames();
                        sender.addChatMessage(new TextComponentString("Deleted "+deletedNames+" I am entries"));
                    }else {
                        String completeName = "";
                        for (int i = 1; i < args.length; i++) completeName += args[i] + ' ';
                        if (IAm.addName(args[0].toLowerCase(), completeName)) {
                            sender.addChatMessage(new TextComponentString("Adding I am mode to " + args[0] + " as " + completeName));
                        }
                    }
                }
            }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }


    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
