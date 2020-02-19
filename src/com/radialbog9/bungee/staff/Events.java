package com.radialbog9.bungee.staff;

import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Events implements Listener {
	
	
	/**
	 * Chat Event for TextChat
	 * @param e ChatEvent
	 */
	@EventHandler
	public void chatEvent(ChatEvent e) {
		/*
		Main.getInstance();
		if(Main.textChatEnabled) {
			if(e.getMessage().startsWith(Main.textChar + " ")) {
				if(e.getSender() instanceof ProxiedPlayer) {
					ProxiedPlayer p = (ProxiedPlayer) e.getSender();
					Main.getInstance();
					if(p.hasPermission(Main.getInstance().usepermission) && Main.pWithTextChatEnabled.contains(p.getName())) {
						StaffChat.postChatMessageWithMOTD(
								p.getDisplayName(), 
								p.getServer().getInfo().getMotd(), 
								Main.getInstance().seepermission,
								e.getMessage()
						);
						e.setCancelled(true);
					}
				}
			}
		}
		*/
	}
	
	/**
	 * Login Event to add player names to list
	 * @param e Post Login Event
	 */
	@EventHandler
	public void postLoginEvent(PostLoginEvent e) {
		/*
		if(e.getPlayer().hasPermission(Main.config.getString("permissions.text-sc"))) {
			if(Main.pWithTextChatEnabled.contains(e.getPlayer().getName())) {
				e.getPlayer().sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', Main.config.getString("messages.textchat-still-enabled"))));
			} else if (!Main.pWithTextChatEnabled.contains(e.getPlayer().getName())) {
				Main.pWithTextChatEnabled.add(e.getPlayer().getName());
			}
		}
		*/
	}

	@EventHandler
	public void postLoginEvent2(PostLoginEvent e) {
		/*
		if (e.getPlayer().hasPermission(Main.config.getString("permissions.use-sc"))) {
			if (Main.pWithStaffChatEnabled.contains(e.getPlayer().getName())) {
				e.getPlayer().sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', Main.config.getString("messages.staffchat-still-enabled"))));
			} else {
				Main.pWithStaffChatEnabled.add(e.getPlayer().getName());
				e.getPlayer().sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', Main.config.getString("messages.staffchat-enabled"))));
			}
		}
		*/
	}
}
