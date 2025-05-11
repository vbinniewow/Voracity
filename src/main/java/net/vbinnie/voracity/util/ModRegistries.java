package net.vbinnie.voracity.util;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.util.Identifier;
import net.vbinnie.idolatry.Idolatry;
import net.vbinnie.idolatry.block.ModBlocks;
import net.vbinnie.idolatry.item.ModItems;

public class ModRegistries {
    public static void registerModStuffs() {

        createPortal();
    }

    private static void createPortal() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.IDOLATRY_BLOCK)
                .lightWithItem(ModItems.IDOL)
                .destDimID(Identifier.of(Idolatry.MOD_ID, "abyss"))
                .tintColor(0xffffff)
                .onlyLightInOverworld()
                .registerPortal();

        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.IDOLATRY_BLOCK)
                .lightWithItem(ModItems.IDOL)
                .destDimID(Identifier.of(Idolatry.MOD_ID, "abyss"))
                .tintColor(0xffffff)
                .onlyLightInOverworld()
                .flatPortal()
                .registerPortal();
    }

}
