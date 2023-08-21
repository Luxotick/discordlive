package dev.luxo.discordlive;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static dev.luxo.discordlive.Bot.sendMinecraft;
import static dev.luxo.discordlive.Discordlive.config;

public class onMessage extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        String channelId = Discordlive.config.getString("channelId");

        if (event.getAuthor().isBot()) return;
        if(event.getChannel().getId().equals(channelId)){
            String content = event.getMessage().getContentRaw();
            String username = event.getAuthor().getName();
            sendMinecraft(username, content);
        }


    }

}
