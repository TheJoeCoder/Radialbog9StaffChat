package com.radialbog9.bungee.staff.API;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class StaffChat {
	/**
	 * Posts a chat message (Deprecated)
	 * @deprecated
	 * @param username username
	 * @param StaffChatSeePermission StaffChatSeePermission
	 * @param message message
	 */
	@Deprecated
	public static void postChatMessage(String username, String StaffChatSeePermission, String message) {
		for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
			if (p.hasPermission(StaffChatSeePermission)) {
				p.sendMessage(new TextComponent(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "AO" + ChatColor.WHITE + "] " + ChatColor.GREEN + username +  ChatColor.WHITE + ": " + ChatColor.DARK_PURPLE + message));
			}
		}
	}
	
	/**
	 * Posts a chat message (Deprecated)
	 * @deprecated
	 * @param username username
	 * @param StaffChatSeePermission StaffChatSeePermission
	 * @param message message
	 * @param motd motd
	 */
	@Deprecated
	public static void postChatMessageWithMOTD(String username,String motd, String StaffChatSeePermission, String message) {
		for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
			if (p.hasPermission(StaffChatSeePermission)) {
				p.sendMessage(new TextComponent(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "AO " + motd + ChatColor.WHITE + "] " + ChatColor.GREEN + username +  ChatColor.WHITE + ": " + ChatColor.DARK_PURPLE + message));
			}
		}
	}
	
	/**
	 * Posts a chat message (Deprecated)
	 * @deprecated
	 * @param StaffChatSeePermission StaffChatSeePermission
	 * @param rawmessage rawmessage
	 */
	@Deprecated
	public static void postRawChatMessage(String StaffChatSeePermission, String rawmessage) {
		for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
			if (p.hasPermission(StaffChatSeePermission)) {
				p.sendMessage(new TextComponent(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "AO" + ChatColor.WHITE + "] " + rawmessage));
			}
		}
	}
	
	/**
	 * Posts a chat message (Deprecated)
	 * @deprecated
	 * @param StaffChatSeePermission StaffChatSeePermission
	 * @param motd motd
	 * @param rawmessage rawmessage
	 */
	@Deprecated
	public static void postRawChatMessageWithMOTD(String StaffChatSeePermission, String motd, String rawmessage) {
		for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
			if (p.hasPermission(StaffChatSeePermission)) {
				p.sendMessage(new TextComponent(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "AO " + motd + ChatColor.WHITE + "] " + rawmessage));
			}
		}
	}
	
	/**
	 * The new way to post messages in the chat. 
	 * If the permission variable is set to "", the permission will be set to
	 * the default permission in the config.
	 * 
	 * This void will escape the color codes for you.
	 * @param rawMessage The Raw Staff Chat Message (e.g. &quot;&amp;f&amp;4AO&amp;f] &amp;5hi&quot;)
	 * @param staffChatSeePerm The permission to see StaffChat (&quot;staffchat.see&quot; by default)
	 */
	public static void postMessageInAO(TextComponent rawMessage, String staffChatSeePerm) {
		String staffChatPerm = staffChatSeePerm;
		for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
			if (p.hasPermission(staffChatPerm)) {
				p.sendMessage(new TextComponent(escapeStrings(rawMessage.toString(), "", "", "", "", "")));
			}
		}
	}
	
	
	/**
	 * Posts a chat message
	 * 
	 * Translates the color codes and escapes the following char sequences:
	 * {ADMIN_MOTD} {ADMIN_NAME} {ADMIN_MESSAGE} {PLAYER_NAME} {CONSOLE_MESSAGE}
	 * 
	 * Some arguments are not used for some commands, therefore are set to a blank screen.
	 * 
	 * @param realString Unescaped String
	 * @param adminMOTD The MOTD of the server that the admin is on.
	 * @param adminName The name of the Admin.
	 * @param adminMessage The Admin's message.
	 * @param playerName The TARGET's Name (The admin's target for some commands)
	 * @param consoleMessage The console's message.
	 * @return escapedString Escaped String
	 */
	public static String escapeStrings(String realString, String adminMOTD, String adminName, String adminMessage, String playerName, String consoleMessage) {
		String escapedString = ChatColor.translateAlternateColorCodes('&', realString);
		adminMOTD = ChatColor.translateAlternateColorCodes('&', adminMOTD);
		adminName = ChatColor.translateAlternateColorCodes('&', adminName);
		adminMessage = ChatColor.translateAlternateColorCodes('&', adminMessage);
		playerName = ChatColor.translateAlternateColorCodes('&', playerName);
		consoleMessage = ChatColor.translateAlternateColorCodes('&', consoleMessage);
		escapedString = escapedString.replace("{ADMIN_MOTD}", adminMOTD);
		escapedString = escapedString.replace("{ADMIN_NAME}", adminName);
		escapedString = escapedString.replace("{ADMIN_MESSAGE}", adminMessage);
		escapedString = escapedString.replace("{PLAYER_NAME}", playerName);
		escapedString = escapedString.replace("{CONSOLE_MESSAGE}", consoleMessage);
		return escapedString;
	}
}
