package net.vbinnie.voracity.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.vbinnie.voracity.Voracity;
import net.vbinnie.voracity.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup GREED_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Voracity.MOD_ID, "greed_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.NETHERGOLD_INGOT))
                    .displayName(Text.translatable("itemgroup.voracity.greed_item_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.NETHERGOLD_INGOT);
                        entries.add(ModItems.MANCATCHER);
                        entries.add(ModItems.FILTHY_PIG_EYE);
                        entries.add(ModItems.HOGLIN_EYE);



                        entries.add(ModBlocks.NETHERGOLD_BLOCK);

                    }).build());

    public static final ItemGroup GLUTTONY_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Voracity.MOD_ID, "gluttony_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.END_MINERAL))
                    .displayName(Text.translatable("itemgroup.voracity.gluttony_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.AMETHYST_CARVER);
                        entries.add(ModItems.END_MINERAL);
                        entries.add(ModBlocks.END_MINERAL_BLOCK);
                        entries.add(ModItems.SIFT);
                        entries.add(ModItems.CHORUS_NIBBLE);
                        entries.add(ModItems.CHICKEN_HOGLIN_EYE_SOUP);
                        entries.add(ModItems.LAVA_CHICKEN);
                        entries.add(ModItems.SIFTED_END_MINERAL);
                        entries.add(ModBlocks.SIFTED_END_MINERAL_BLOCK);
                        entries.add(ModBlocks.WET_SIFTED_END_MINERAL_BLOCK);
                        entries.add(ModBlocks.FROZEN_SIFTED_END_MINERAL_BLOCK);
                        entries.add(ModBlocks.END_SALT_CRYSTAL_BLOCK);

                    }).build());

    public static final ItemGroup KNOWLEDGE_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Voracity.MOD_ID, "knowledge_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CHORUS_NIBBLE))
                    .displayName(Text.translatable("itemgroup.voracity.knowledge_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CHORUS_NIBBLE);
                        entries.add(ModBlocks.EDENIC_SOIL);
                        entries.add(ModBlocks.EDENIC_GRASS);
                    }).build());



    public static void registerItemGroups() {
        Voracity.LOGGER.info("Registering Item Groups for " + Voracity.MOD_ID);
    }
}