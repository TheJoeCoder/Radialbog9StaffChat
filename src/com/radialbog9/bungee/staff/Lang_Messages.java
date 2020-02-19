package com.radialbog9.bungee.staff;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Lang_Messages {
	public static void sendPermissionMessage(ProxiedPlayer player) {
		player.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', Main.config.getString("messages.no-perm"))));
	}
	public static void sendNoEnoughArgs(ProxiedPlayer player) {
		player.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', Main.config.getString("messages.not-enough-args"))));
	}
}
