package net.vbinnie.voracity.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.vbinnie.voracity.block.ModBlocks;
import net.vbinnie.voracity.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.NETHERGOLD_BLOCK);
        addDrop(ModBlocks.EMPTY_SOUL);
        addDrop(ModBlocks.GREED_SOUL);
        addDrop(ModBlocks.END_MINERAL_BLOCK);
        addDrop(ModBlocks.END_SUGAR_CRYSTAL, ModItems.END_SUGAR);
        addDropWithSilkTouch(ModBlocks.END_SUGAR_CRYSTAL);
    }
}
