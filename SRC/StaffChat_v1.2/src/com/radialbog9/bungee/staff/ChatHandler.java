package com.radialbog9.bungee.staff;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class ChatHandler {
	public static void handleChatCommand(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer player = (ProxiedPlayer) sender;
			if(player.hasPermission("staffchat.use")) {
				if(!(args.length == 0)) {
					String broadcastMsg = "";
					for (String a : args){
			    	     broadcastMsg += a+" ";
			    	}
					for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers())
					  {
						if (p.hasPermission("staffchat.see")) {
							p.sendMessage(new TextComponent(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "AO " + player.getServer().getInfo().getMotd() + ChatColor.WHITE + "] " + ChatColor.GREEN + player.getDisplayName() +  ChatColor.WHITE + ": " + ChatColor.DARK_PURPLE + broadcastMsg));
					    }
					  }
					System.out.println(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "AO " + player.getServer().getInfo().getMotd() + ChatColor.WHITE + "] " + ChatColor.GREEN + player.getDisplayName() +  ChatColor.WHITE + ": " + ChatColor.DARK_PURPLE + broadcastMsg);
				} else {
					Lang_Messages.sendNoEnoughArgs(player);
				}
			} else {
				Lang_Messages.sendPermissionMessage(player);
			}
		} else {
			if(!(args.length == 0)) {
				String broadcastMsg = "";
				for (String a : args){
		    	     broadcastMsg += a+" ";
		    	}
				for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers())
				  {
					if (p.hasPermission("staffchat.see")) {
						p.sendMessage(new TextComponent(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "AO" + ChatColor.WHITE + "] " + ChatColor.GREEN + "CONSOLE" +ChatColor.WHITE + ": " + ChatColor.DARK_PURPLE + broadcastMsg));
				    }
				  }
				sender.sendMessage(new TextComponent(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "AO" + ChatColor.WHITE + "] " + ChatColor.GREEN + "CONSOLE" +ChatColor.WHITE + ": " + ChatColor.DARK_PURPLE + broadcastMsg));
			} else {
				sender.sendMessage(new TextComponent(ChatColor.DARK_RED + "You didn't specify enough arguments."));
			}
		}
	}

}
