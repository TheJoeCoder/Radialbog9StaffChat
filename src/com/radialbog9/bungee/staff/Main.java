package com.radialbog9.bungee.staff;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.radialbog9.bungee.staff.AOCommand;

public class Main extends Plugin {
	
	private static Main instance;
	public static File configFile;
	public static Configuration config;
	
	/**
	 * Whether the text chat is enabled (controlled in the config)
	 */
	public static boolean textChatEnabled = true;
	
	/**
	 * The character used for "Text Chat"
	 */
	public static String textChar = "#";
	
	/**
	 * The players with TextChat enabled
	 */
	public static List<String> pWithTextChatEnabled = new ArrayList<String>();

	/**
	 * The players with StaffChat enabled.
	 */
	public static List<String> pWithStaffChatEnabled = new ArrayList<String>();
	
	/**
	 * The permission to use StaffChat messages.
	 */
	public String usepermission = "staffchat.use";
	
	/**
	 * The permission to see StaffChat messages.
	 */
	public String seepermission = "staffchat.see";

	/**
	 * Gets the current instance of the Main class
	 * @return instance
	 */
	public static Main getInstance() {
		return instance;
	}
	
	/**
	 * Sets the instance of the plugin.
	 * @param instance Main Instance
	 */
	public static void setInstance(Main instance) {
		Main.instance = instance;
	}
	
	/**
	 * OnEnable loop
	 */
	@Override
	public void onEnable() {
		try {
			if (!getDataFolder().exists()) getDataFolder().mkdir();
			configFile = new File(getDataFolder(), "config.yml");

            if (!configFile.exists()) {
                try (InputStream in = getResourceAsStream("config.yml")) {
                    Files.copy(in, configFile.toPath());
                } catch (IOException e) {
                	getProxy().getLogger().log(Level.SEVERE, "Error while creating config file");
                    e.printStackTrace();
                }
            }
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
		} catch (IOException e) {
			getProxy().getLogger().log(Level.SEVERE, "Error while loading configuration");
			e.printStackTrace();
		}
		
		usepermission = config.getString("permissions.use-sc");
		seepermission = config.getString("permissions.see-sc");

		//getProxy().getPluginManager().registerListener(this, new Events());

		getProxy().getPluginManager().registerCommand(this, new SCInfoCommand());
		getProxy().getPluginManager().registerCommand(this, new AOCommand());
		//getProxy().getPluginManager().registerCommand(this, new SCToggleCommand());
		
		getLogger().info(ChatColor.DARK_RED + "(!) " + ChatColor.GREEN + PluginInfo.pluginName + " version " + PluginInfo.pluginVersion + " has loaded!");
	}
	
	/**
	 * OnDisable loop
	 */
	@Override
	public void onDisable() {
		saveConfig();
		getLogger().info(ChatColor.DARK_RED + "(!) " + ChatColor.GREEN + PluginInfo.pluginName + " version " + PluginInfo.pluginVersion +  " has been Disabled!");
	}
	
	/**
	 * Saves the plugin config,
	 */
	public void saveConfig() {
		try {
			ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, configFile);
		} catch (IOException e) {
			getProxy().getLogger().log(Level.SEVERE, "Error while saving config");
			e.printStackTrace();
		}
	}
	
	
}
