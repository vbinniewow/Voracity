package net.vbinnie.voracity;

import net.acoyt.pinecone.api.PineLib;
import net.fabricmc.api.ModInitializer;

import net.vbinnie.voracity.block.ModBlocks;
import net.vbinnie.voracity.item.ModItemGroups;
import net.vbinnie.voracity.item.ModItems;
import net.vbinnie.voracity.util.ModLootTableModifier;
import net.vbinnie.voracity.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Voracity implements ModInitializer {
	public static final String MOD_ID = "voracity";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		PineLib.init(MOD_ID);
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModLootTableModifier.register();
		ModRegistries.registerModStuffs();
		LOGGER.info("Hello Fabric world!");



	}




}