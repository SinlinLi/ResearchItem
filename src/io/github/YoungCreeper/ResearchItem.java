package io.github.YoungCreeper;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class ResearchItem extends JavaPlugin {
	@Override
	public void onEnable(){
		Bukkit.getPluginCommand("research").setExecutor(new cExecutor());
		getLogger().info(ChatColor.GREEN+"ResearchItem已经启用！版本v1.1.1");
	}
	@Override
	public void onDisable(){
		getLogger().info(ChatColor.GREEN+"ResearchItem已经停用！");
	}

}
