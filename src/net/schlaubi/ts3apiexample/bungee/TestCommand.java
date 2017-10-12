package net.schlaubi.ts3apiexample.bungee;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.schlaubi.TeamspeakVerifyerAPI;

public class TestCommand extends Command {
    private String verified;

    public TestCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer){
            if(args.length > 0){
                ProxiedPlayer player = (ProxiedPlayer) sender;
                ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
                if (TeamspeakVerifyerAPI.isVerified(target)) {
                    verified = "true";
                } else {
                    verified = "false";
                }
                if(target != null){
                    player.sendMessage("Verified: " + verified + "\n Databaseid: " + TeamspeakVerifyerAPI.getDatabaseId(target));
                } else {
                    player.sendMessage("Player not found");
                }
            }
        }
    }
}
