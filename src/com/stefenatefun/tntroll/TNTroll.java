package com.stefenatefun.tntroll;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.logging.Logger;

public class TNTroll extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	TNTrollBlockListener blockListener = new TNTrollBlockListener(this);
	TNTrollConfig config = new TNTrollConfig(this);
	List<String> ignoredWorldsList = config.getIgnoredWorlds();

	@Override
	public void onDisable() {

	}

	@Override
	public void onEnable() {
		PluginDescriptionFile pdFile = this.getDescription();
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_DAMAGE, blockListener, Event.Priority.Normal, this);
		log.info(pdFile.getName() + " version " + pdFile.getVersion() + " loaded!");
	}
}
