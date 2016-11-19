# IAm Command
This mod adds one simple command to Minecraft: iam

Using this command against a player will replace whatever they say on the chat with "I am" followed with whatever you want (you need to be an OP to use it)

The usage is: iam <targetPlayerName> [customName]
Where "targetPlayerName" is the player who will suffer the effects of the command and the "customName" is what they will say after "I am".
If you don't write any custom name parameter, the player name will be used as customName parameter.

To remove the command effects from a player, just write the command "iam" followed with the player name without a customName: iam <targetPlayerName>
To remove the command effects from all the players yo ever added, use the command "iam clear all".

Examples:
    Command: iam Player1
        Chat output: <Player1> I am Player1
    Command: iam Player1 Groot
        Chat output: <Player1> I am Groot
    Command: iam Player1 BATMAN
        Chat output: <Player1> I am BATMAN

Since version 1.1, there is a config option to enable or diasble the addition of the "I am" text at the beginning of the replaced chat text. If disabled, you can always write it manually like "iam Player1 I am ME".

I have tested this mod on my private server along with other 50 mods and was working fine. Please let me know if you find any incompatibility or bug!
