package com.radialbog9.bungee.staff.API;

import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {
	@Override
	public void onEnable() {
		getLogger().info("StaffChatAPI has been Enabled!");
	}
	@Override
	public void onDisable() {
		getLogger().info("StaffChatAPI has been Disabled!");
	}
}
