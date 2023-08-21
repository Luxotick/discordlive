package dev.luxo.discordlive;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class listener implements Listener  {

    public boolean setted;

    String regex = "(http|https)://\\S+|@\\w+";


    @EventHandler(priority = EventPriority.LOWEST)
    public void onChat(AsyncPlayerChatEvent event) {
        try{
            String result = event.getMessage().replaceAll(regex, "");
            if(result.contains("@")){
            }else{
                Bot.sendMessage(event.getPlayer().getName() + " >> " + result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public String Regex(String input) {
        String result = input.replaceAll(regex, "");
        return result;
    }
    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityDeath(PlayerDeathEvent event) {

        String result = event.getDeathMessage().replaceAll(regex, "");

        if (event.getEntityType() == null) return;
        Bot.sendMessage(result);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent event) {

        String result = event.getPlayer().getName().replaceAll(regex, "");

        Bot.sendMessage(result + " joined to server");
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerQuitEvent event) {

        String result = event.getPlayer().getName().replaceAll(regex, "");

        Bot.sendMessage(result + " left the server");
    }

}
