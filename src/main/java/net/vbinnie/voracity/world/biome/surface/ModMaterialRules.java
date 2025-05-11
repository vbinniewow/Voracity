package net.vbinnie.voracity.world.biome.surface;

import net.minecraft.block.Block;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.vbinnie.idolatry.block.ModBlocks;
import net.vbinnie.idolatry.world.biome.ModBiomes;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule WHITE = makeStateRule(ModBlocks.WHITE);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, WHITE), WHITE);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.BRIGHT_ABYSS),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, WHITE)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, WHITE)),


                        // Default to a grass and dirt surface
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
                );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}