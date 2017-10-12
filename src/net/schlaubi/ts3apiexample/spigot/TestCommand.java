package net.schlaubi.ts3apiexample.spigot;

import net.schlaubi.TeamspeakVerifyerAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {

    private String verified;

    @Override
    public boolean onCommand(CommandSender sender, Command name, String lable, String[] args) {
        if(sender instanceof Player){
            if(args.length > 0) {
                Player player = (Player) sender;
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    if (TeamspeakVerifyerAPI.isVerified(target)) {
                        verified = "true";
                    } else {
                        verified = "false";
                    }
                    player.sendMessage("Verified: " + verified + "\n DatabaseID:" + TeamspeakVerifyerAPI.getDatabaseId(target));
                } else {
                    player.sendMessage("Player not found");
                }
            }
        }
        return false;
    }
}
