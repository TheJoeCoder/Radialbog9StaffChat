package com.radialbog9.bungee.staff;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;
import com.radialbog9.bungee.staff.AOCommand;

public class Main extends Plugin {
	
	
	@Override
	public void onEnable() {
		getProxy().getPluginManager().registerCommand(this, new SCInfoCommand());
		getProxy().getPluginManager().registerCommand(this, new AOCommand());
		getLogger().info(ChatColor.DARK_RED + "(!) " + ChatColor.GREEN + PluginInfo.pluginName + " version " + PluginInfo.pluginVersion + " has loaded!");
	}
	
	@Override
	public void onDisable() {
		getLogger().info(ChatColor.DARK_RED + "(!) " + ChatColor.GREEN + PluginInfo.pluginName + " version " + PluginInfo.pluginVersion +  " has been Disabled!");
	}
}
