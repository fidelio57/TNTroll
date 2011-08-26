package com.stefenatefun.tntroll;

import net.minecraft.server.EntityTNTPrimed;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.inventory.ItemStack;

public class TNTrollBlockListener extends BlockListener {
	public TNTroll plugin;

	public TNTrollBlockListener(TNTroll instance) {
		plugin = instance;
	}

	public void onBlockDamage(BlockDamageEvent event) {
		Block block = event.getBlock();
		Player player = event.getPlayer();
		ItemStack itemInHand = player.getItemInHand();

		if (block.getType() == Material.TNT && !event.isCancelled() && itemInHand.getType() != Material.SHEARS && !plugin.ignoredWorldsList.contains(player.getWorld().getName())) {
			CraftWorld cWorld = (CraftWorld) block.getWorld();
			EntityTNTPrimed tnt = new EntityTNTPrimed(cWorld.getHandle(), block.getX() + 0.5D, block.getY() + 0.0D, block.getZ() + 0.5D);
			cWorld.getHandle().addEntity(tnt);
			block.setType(Material.RED_ROSE);
			event.setCancelled(true);
		}
	}
}

