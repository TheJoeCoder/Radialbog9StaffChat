package com.radialbog9.bungee.staff;

import com.radialbog9.bungee.staff.API.StaffChat;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class ChatHandler {
	/**
	 * Handles the chat command
	 * @param sender Command Sender
	 * @param args Command Arguments
	 */
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
							p.sendMessage(new TextComponent(
									StaffChat.escapeStrings(
											Main.config.getString("messages.adminchat-message"), 
											player.getServer().getInfo().getMotd(), 
											player.getDisplayName(), 
											broadcastMsg, 
											"", ""
									)
							));
							
						}
					  }
					/*System.out.println(ChatColor.translateAlternateColorCodes('&', Main.config.getString("messages.adminchat-message").replace("{ADMIN_MOTD}", player.getServer().getInfo().getMotd()).replace("{ADMIN_NAME}", player.getDisplayName()).replace("{ADMIN_MESSAGE}", broadcastMsg)));*/
					System.out.println(
							StaffChat.escapeStrings(
									Main.config.getString("messages.adminchat-message"), 
									player.getServer().getInfo().getMotd(), 
									player.getDisplayName(), 
									broadcastMsg, 
									"", ""
							)
					);
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
					if (p.hasPermission(Main.config.getString("permissions.see-sc"))) {
						/*p.sendMessage(new TextComponent(
						 * ChatColor.translateAlternateColorCodes('&', 
						 * Main.config.getString("messages.console-message"))
						 * .replace("{CONSOLE_MESSAGE}", broadcastMsg)));*/
						p.sendMessage(new TextComponent(
								StaffChat.escapeStrings(
										Main.config.getString("messages.console-message"), 
										"", "", "", "", 
										broadcastMsg
								)
						));
					}
				  }
				sender.sendMessage(new TextComponent(
						StaffChat.escapeStrings(
								Main.config.getString("messages.console-message"), 
								"", "", "", "", 
								broadcastMsg
						)
				));
			} else {
				sender.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', Main.config.getString("messages.not-enough-args"))));
			}
		}
	}

}
