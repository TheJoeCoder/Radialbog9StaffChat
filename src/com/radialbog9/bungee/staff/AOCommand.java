package com.radialbog9.bungee.staff;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class AOCommand extends Command {
	/**
	 * The /ao command
	 */
	public AOCommand() {
		super("ao");
	}
	
	/**
	 * Executes the command /ao
	 * @param sender Command Sender
	 * @param args Command Arguments
	 */
	@Override
	public void execute(CommandSender sender, String[] args) {
		// TODO Auto-generated method stub
		ChatHandler.handleChatCommand(sender, args);
	}
}
