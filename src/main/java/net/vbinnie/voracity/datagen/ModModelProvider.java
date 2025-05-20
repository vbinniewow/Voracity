package net.vbinnie.voracity.datagen;

import com.terraformersmc.modmenu.util.mod.Mod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.vbinnie.voracity.block.ModBlocks;
import net.vbinnie.voracity.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SIFTED_END_MINERAL_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WHITE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_SUGAR_CRYSTAL  );


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.NETHERGOLD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SIFT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SIFTED_END_MINERAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.FILTHY_PIG_EYE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOGLIN_EYE, Models.GENERATED);
        itemModelGenerator.register(ModItems.END_MINERAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.END_SUGAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_CARVER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHORUS_NIBBLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAVA_CHICKEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHICKEN_HOGLIN_EYE_SOUP, Models.GENERATED);

    }
}
