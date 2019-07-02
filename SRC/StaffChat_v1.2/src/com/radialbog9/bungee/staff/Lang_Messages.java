package com.radialbog9.bungee.staff;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Lang_Messages {
	public static void sendPermissionMessage(ProxiedPlayer player) {
		player.sendMessage(new TextComponent(ChatColor.DARK_RED + "You don't have permission for that!"));
	}
	public static void sendNoEnoughArgs(ProxiedPlayer player) {
		player.sendMessage(new TextComponent(ChatColor.DARK_RED + "You didn't specify enough arguments."));
	}
}
