package dev.luxo.discordlive;

import java.io.File;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import  org.bukkit.command.CommandSender.*;


import javax.security.auth.login.LoginException;


public class Bot extends ListenerAdapter {
    private static JDA jda;

    public static void main(String args) throws LoginException {

        jda = JDABuilder.createDefault(args)
                .addEventListeners(new Bot())
                .addEventListeners(new onMessage())
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();
    }

    public static void close(){
        jda.shutdown();
    }


    public static void sendMessage(String message) {
        String channelId = Discordlive.config.getString("channelId");

        TextChannel channel = jda.getTextChannelById(channelId);
        if (channel != null) {
            channel.sendMessage(message).queue();
        }
    }

    public static void sendMinecraft(String username, String message){
        Bukkit.broadcastMessage(ChatColor.BLUE + "[Discord] " + ChatColor.BLUE +username+ChatColor.WHITE+ ": " +message);

    }
}
