package dev.luxo.discordlive;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

public final class Discordlive extends JavaPlugin {
    public static FileConfiguration config;

    public static Discordlive plugin;

    @Override
    public void onEnable() {
        plugin = this;
        config = Discordlive.getPlugin(Discordlive.class).getConfig();
        saveDefaultConfig();
        loadConfig();
        getCommand("dlReload").setExecutor(new dlReload());
        getCommand("startBot").setExecutor(new startBot());
        getCommand("closeBot").setExecutor(new closeBot());
        // Plugin startup logic
        getLogger().info("Discordlive succesfully loaded");
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new listener(), this );
    }

    public static void loadConfig(){
        plugin.reloadConfig();
        plugin.getConfig().options().copyDefaults(true);
        config = plugin.getConfig();
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
