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
                    }).build());

    public static final ItemGroup LUST_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Voracity.MOD_ID, "lust_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CHORUS_NIBBLE))
                    .displayName(Text.translatable("itemgroup.voracity.lust_group"))
                    .entries((displayContext, entries) -> {

                    }).build());



    public static void registerItemGroups() {
        Voracity.LOGGER.info("Registering Item Groups for " + Voracity.MOD_ID);
    }
}