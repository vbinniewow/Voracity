package net.vbinnie.voracity.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
import net.vbinnie.voracity.block.ModBlocks;
import net.vbinnie.voracity.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AAAAAAAAAAAHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.NETHERGOLD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SIFT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SIFTED_END_MINERAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.FILTHY_PIG_EYE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOGLIN_EYE, Models.GENERATED);
        itemModelGenerator.register(ModItems.END_MINERAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_CARVER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHORUS_NIBBLE, Models.GENERATED);

    }
}
