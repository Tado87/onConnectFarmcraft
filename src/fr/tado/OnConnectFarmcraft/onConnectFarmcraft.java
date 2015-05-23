package fr.tado.OnConnectFarmcraft;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class onConnectFarmcraft extends JavaPlugin implements Listener {

	public void onEnable() {
		System.out.println("Lancement de onConnectFarmcraft  Version 0.1.2");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
	}
	
	public void onDisable() {
		System.out.println("Le plugin ce coupe");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("play")){
			PlayerUtils.sendTitle(p, ChatColor.GREEN + "Bienvenue sur Farmcraft", "forum.farmcraft.fr");
		}
		
	return true;	
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		PlayerUtils.sendTitle(e.getPlayer(), ChatColor.GREEN  + "Bienvenue sur Farmcraft", "forum.farmcraft.fr");
		e.setJoinMessage(ChatColor.RED+e.getPlayer().getName()+" §3a rejoint le serveur!");
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		e.setQuitMessage(ChatColor.RED+e.getPlayer().getName()+" §3s'est déconnecté du serveur!");
	}
	
}
