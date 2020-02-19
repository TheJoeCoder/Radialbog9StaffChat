package com.radialbog9.bungee.staff;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class SCToggleCommand extends Command {
    ChatColor cc;
    public SCToggleCommand() {
        super("SCToggle");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            //Player executed command
            ProxiedPlayer p = (ProxiedPlayer) sender;
            if(args.length == 0) {
                //no args
                if(p.hasPermission(Main.config.getString("permissions.toggle-sc.self"))) {
                    if (Main.pWithStaffChatEnabled.contains(p.getName())) {
                        Main.pWithStaffChatEnabled.remove(p.getName());
                        p.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', Main.config.getString("messages.staffchat-disabled"))));
                    } else {
                        Main.pWithStaffChatEnabled.add(p.getName());
                        p.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', Main.config.getString("messages.staffchat-enabled"))));
                    }
                } else {
                    p.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', Main.config.getString("messages.no-perm"))));
                }
            } else if(args.length == 1) {
                //1 arg
                if (p.hasPermission(Main.config.getString("permissions.toggle-sc.others")))  {
                    String pName = args[0];
                    ProxiedPlayer result = BungeeCord.getInstance().getPlayer(pName);
                    if (result != null) {
                        if (result.hasPermission(Main.config.getString("permissions.toggle-sc.exempt"))) {
                            p.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', Main.config.getString("messages.player-exempt"))));
                        } else {
                            //the target not have perm to be exempt
                            if (Main.pWithStaffChatEnabled.contains(result.getName())) {
                                Main.pWithStaffChatEnabled.remove(result.getName());
                                result.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', Main.config.getString("messages.staffchat-disabled"))));
                            } else {
                                Main.pWithStaffChatEnabled.add(result.getName());
                                result.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', Main.config.getString("messages.staffchat-enabled"))));
                            }
                            p.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', Main.config.getString("messages.staffchat-toggled-p").replace("{PLAYER_NAME}", result.getName()))));
                        }
                    }
                } else {
                    p.sendMessage(new TextComponent(ChatColor.DARK_RED + ChatColor.translateAlternateColorCodes('&', Main.config.getString("messages.no-perm"))));
                }
            } else {
                //more than 1 args
                p.sendMessage(new TextComponent(ChatColor.DARK_RED + ChatColor.translateAlternateColorCodes('&', Main.config.getString("messages.toomanyargs"))));
            }
        } else {
            //console Executed Command
            sender.sendMessage(new TextComponent(ChatColor.RED + ChatColor.translateAlternateColorCodes('&', Main.config.getString("messages.exec-console"))));
        }
    }
}
