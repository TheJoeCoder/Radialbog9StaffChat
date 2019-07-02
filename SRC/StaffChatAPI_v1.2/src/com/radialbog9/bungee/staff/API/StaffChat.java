package com.radialbog9.bungee.staff.API;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class StaffChat {
	public static void postChatMessage(String username, String StaffChatSeePermission, String message) {
		for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
			if (p.hasPermission(StaffChatSeePermission)) {
				p.sendMessage(new TextComponent(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "AO" + ChatColor.WHITE + "] " + ChatColor.GREEN + username +  ChatColor.WHITE + ": " + ChatColor.DARK_PURPLE + message));
			}
		}
	}
	public static void postChatMessageWithMOTD(String username,String motd, String StaffChatSeePermission, String message) {
		for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
			if (p.hasPermission(StaffChatSeePermission)) {
				p.sendMessage(new TextComponent(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "AO " + motd + ChatColor.WHITE + "] " + ChatColor.GREEN + username +  ChatColor.WHITE + ": " + ChatColor.DARK_PURPLE + message));
			}
		}
	}
	public static void postRawChatMessage(String StaffChatSeePermission, String rawmessage) {
		for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
			if (p.hasPermission(StaffChatSeePermission)) {
				p.sendMessage(new TextComponent(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "AO" + ChatColor.WHITE + "] " + rawmessage));
			}
		}
	}
	public static void postRawChatMessageWithMOTD(String StaffChatSeePermission, String motd, String rawmessage) {
		for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
			if (p.hasPermission(StaffChatSeePermission)) {
				p.sendMessage(new TextComponent(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "AO " + motd + ChatColor.WHITE + "] " + rawmessage));
			}
		}
	}
}
