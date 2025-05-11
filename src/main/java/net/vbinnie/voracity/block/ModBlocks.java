package net.vbinnie.voracity.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.vbinnie.voracity.Voracity;

public class ModBlocks {
        public static final Block NETHERGOLD_BLOCK = registerBlock("nethergold_block",
                new PillarBlock(AbstractBlock.Settings.create().strength(4f)
                        .requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block END_MINERAL_BLOCK = registerBlock("end_mineral_block",
            new Block(AbstractBlock.Settings.create().strength(.4f).sounds(BlockSoundGroup.SUSPICIOUS_GRAVEL)));

    public static final Block WET_SIFTED_END_MINERAL_BLOCK = registerBlock("wet_sifted_end_mineral_block",
            new Block(Block.Settings.create().strength(.4f).sounds(BlockSoundGroup.MUD)));

    public static final Block FROZEN_SIFTED_END_MINERAL_BLOCK = registerBlock("frozen_sifted_end_mineral_block",
            new Block(Block.Settings.create().strength(.4f).sounds(BlockSoundGroup.CALCITE)));


    public static final Block END_SALT_CRYSTAL_BLOCK = registerBlock("end_salt_crystal_block",
            new Block(IceBlock.Settings.create().strength(.4f).sounds(BlockSoundGroup.GLASS)));


    public static final Block SIFTED_END_MINERAL_BLOCK = registerBlock("sifted_end_mineral_block",
            new ConcretePowderBlock(Blocks.EMERALD_BLOCK // change this later
                    , AbstractBlock.Settings.create().strength(.4f).sounds(BlockSoundGroup.SAND)));

    public static final Block EDENIC_GRASS = registerBlock("edenic_grass",
            new Block(AbstractBlock.Settings.create().strength(.7f).sounds(BlockSoundGroup.GRASS)));

    public static final Block EDENIC_SOIL = registerBlock("edenic_soil",
            new Block(AbstractBlock.Settings.create().strength(.7f).sounds(BlockSoundGroup.ROOTED_DIRT)));



        private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Voracity.MOD_ID, name), block);
    }

        private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Voracity.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

        public static void registerModBlocks() {
        Voracity.LOGGER.info("Registering Mod Blocks for " + Voracity.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
        });
    }
}
