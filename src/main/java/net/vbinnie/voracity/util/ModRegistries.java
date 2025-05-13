package net.vbinnie.voracity.util;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.world.BlockCollisionSpliterator;
import net.vbinnie.voracity.Voracity;
import net.vbinnie.voracity.block.ModBlocks;
import net.vbinnie.voracity.item.ModItems;


public class ModRegistries {
    public static void registerModStuffs() {

        createPortal();
    }

    private static void createPortal() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.PURPUR_BLOCK)
                .lightWithItem(Items.CHORUS_FRUIT)
                .destDimID(Identifier.of(Voracity.MOD_ID, "abyss"))
                .tintColor(0xbe9fcd)
                .onlyLightInOverworld()
                .registerPortal();

        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.PURPUR_BLOCK)
                .lightWithItem(Items.CHORUS_FRUIT)
                .destDimID(Identifier.of(Voracity.MOD_ID, "abyss"))
                .tintColor(0xbe9fcd)
                .onlyLightInOverworld()
                .flatPortal()
                .registerPortal();
    }

}
