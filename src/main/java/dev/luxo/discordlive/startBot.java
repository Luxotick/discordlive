package dev.luxo.discordlive;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class startBot implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender.hasPermission("dl.reload")) {
            try {
                String token = Discordlive.config.getString("bot_token");

                Bot.main(token);
                Bukkit.getLogger().info("Discord bot succesfully started.");
            } catch (LoginException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
