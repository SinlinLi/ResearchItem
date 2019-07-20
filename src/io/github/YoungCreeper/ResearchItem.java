package io.github.YoungCreeper;

import org.bukkit.plugin.java.JavaPlugin;

public final class ResearchItem extends JavaPlugin {
	@Override
	public void onEnable(){
		this.getCommand("research").setExecutor(new cExecutor(this));
		getLogger().info("ResearchItem已经启用！版本v1.0.0");
	}
	@Override
	public void onDisable(){
		getLogger().info("ResearchItem已经停用！");
	}

}