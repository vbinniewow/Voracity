package net.vbinnie.voracity.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BrushableBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.vbinnie.voracity.Voracity;

public class ModBlocks {
        public static final Block NETHERGOLD_BLOCK = registerBlock("nethergold_block",
                new PillarBlock(AbstractBlock.Settings.create().strength(4f)
                        .requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block END_MINERAL_BLOCK = registerBlock("end_mineral_block",
            new Block(AbstractBlock.Settings.create().strength(.4f).sounds(BlockSoundGroup.SUSPICIOUS_GRAVEL)));


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
