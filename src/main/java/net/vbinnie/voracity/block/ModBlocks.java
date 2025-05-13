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
import net.minecraft.util.Rarity;
import net.vbinnie.voracity.Voracity;
import net.vbinnie.voracity.block.custom.BookBoxBlock;

public class ModBlocks {
        public static final Block NETHERGOLD_BLOCK = registerBlock("nethergold_block",
                new Block(Block.Settings.create().strength(4f)
                        .requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block END_MINERAL_BLOCK = registerBlock("end_mineral_block",
            new Block(AbstractBlock.Settings.create().strength(.4f).sounds(BlockSoundGroup.SUSPICIOUS_GRAVEL)));



    public static final Block WHITE = registerBlock("white",
            new Block(IceBlock.Settings.create().strength(4f).sounds(BlockSoundGroup.BONE)));


    public static final Block SIFTED_END_MINERAL_BLOCK = registerBlock("sifted_end_mineral_block",
            new ConcretePowderBlock(Blocks.EMERALD_BLOCK // change this later
                    , AbstractBlock.Settings.create().strength(.4f).sounds(BlockSoundGroup.SAND)));

    public static final Block BOOK_BOX = registerUncommonBlock("book_box",
            new BookBoxBlock(AbstractBlock.Settings.create().strength(1.5f).sounds(BlockSoundGroup.WOOD)));


    private static Block registerUncommonBlock(String name, Block block) {
        registerUncommonBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Voracity.MOD_ID, name), block);
    }

    private static void registerUncommonBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Voracity.MOD_ID, name),
                new BlockItem(block, new Item.Settings().rarity(Rarity.UNCOMMON)));
    }

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
