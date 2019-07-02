package com.radialbog9.bungee.staff;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class SCInfoCommand extends Command {

	public SCInfoCommand() {
		super("scinfo");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer) sender;
			if(p.hasPermission("staffchat.info")) {
				p.sendMessage(new TextComponent(ChatColor.BLUE + PluginInfo.pluginName + ChatColor.WHITE + "v" +  PluginInfo.pluginVersion +" by " + ChatColor.GOLD + PluginInfo.pluginAuthor ));
				p.sendMessage(new TextComponent(ChatColor.YELLOW + "Commands:"));
				p.sendMessage(new TextComponent(ChatColor.RED + "/ao <message>" + ChatColor.WHITE + " - " + ChatColor.AQUA + "Allows you to talk in admin chat."));
				
			} else {
				Lang_Messages.sendPermissionMessage(p);
			}
		}
		
	}

}
