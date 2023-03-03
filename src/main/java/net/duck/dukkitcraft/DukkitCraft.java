package net.duck.dukkitcraft;

import net.duck.dukkitcraft.block.ModBlocks;
import net.duck.dukkitcraft.item.ModItemGroup;
import net.duck.dukkitcraft.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.duck.dukkitcraft.item.ModItems.registerModItems;

public class DukkitCraft implements ModInitializer {
	public static final String MOD_ID = "dukkitcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
