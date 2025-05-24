package net.vbinnie.voracity.block;

import com.terraformersmc.modmenu.util.mod.Mod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.GameVersion;
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
import net.vbinnie.voracity.block.custom.LavaBlastedBlock;

public class ModBlocks {
        public static final Block NETHERGOLD_BLOCK = registerBlock("nethergold_block",
                new Block(Block.Settings.create().strength(50.0F, 1200.0F)
                        .requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block END_MINERAL_BLOCK = registerBlock("end_mineral_block",
            new Block(AbstractBlock.Settings.create().strength(.4f).sounds(BlockSoundGroup.SUSPICIOUS_SAND)));



    public static final Block WHITE = registerBlock("white",
            new Block(IceBlock.Settings.create().strength(4f).sounds(BlockSoundGroup.BONE)));


    public static final Block EMPTY_SOUL = registerBlock("empty_soul",
            new Block(IceBlock.Settings.create().strength(6f, 999999999).sounds(BlockSoundGroup.GLASS)));


    public static final Block WALL = registerUncommonBlock("wall",
            new Block(IceBlock.Settings.create().strength(999999999, 999999999).sounds(BlockSoundGroup.DEEPSLATE_BRICKS)));


    public static final Block GREED_SOUL = registerBlock("greed_soul",
            new Block(IceBlock.Settings.create().strength(6f, 999999999).sounds(BlockSoundGroup.NETHER_GOLD_ORE)));



    public static final Block END_SUGAR_CRYSTAL = registerBlock("end_sugar_crystal",
            new Block(AbstractBlock.Settings.create().strength(1.5f).sounds(BlockSoundGroup.AMETHYST_BLOCK).nonOpaque()));

    public static final Block SIFTED_END_MINERAL_BLOCK = registerBlock("sifted_end_mineral_block",
            new LavaBlastedBlock(ModBlocks.END_SUGAR_CRYSTAL
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
