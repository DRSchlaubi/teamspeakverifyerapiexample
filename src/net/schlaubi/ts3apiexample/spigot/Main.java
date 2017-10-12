package net.schlaubi.ts3apiexample.spigot;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("ts").setExecutor(new TestCommand());
    }
}
