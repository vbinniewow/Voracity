package net.vbinnie.voracity;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerChunkEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.networking.v1.EntityTrackingEvents;
import net.minecraft.block.Blocks;
import net.minecraft.datafixer.fix.StructureSettingsFlattenFix;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.structure.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.chunk.placement.StructurePlacement;
import net.vbinnie.voracity.block.ModBlocks;
import net.vbinnie.voracity.effect.ModEffects;
import net.vbinnie.voracity.item.ModItemGroups;
import net.vbinnie.voracity.item.ModItems;
import net.vbinnie.voracity.util.ModLootTableModifier;
import net.vbinnie.voracity.util.ModRegistries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.desktop.UserSessionEvent;
import java.util.Objects;
import java.util.Optional;

public class Voracity implements ModInitializer {
	public static final String MOD_ID = "voracity";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);




	@Override
	public void onInitialize() {


		ModEffects.registerEffects();
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModLootTableModifier.register();
		ModRegistries.registerModStuffs();
		LOGGER.info("im feeling voracious");



	}

}