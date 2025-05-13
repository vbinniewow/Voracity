package net.vbinnie.voracity.world.biome.surface;

import net.minecraft.block.Block;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.vbinnie.voracity.block.ModBlocks;
import net.vbinnie.voracity.world.biome.ModBiomes;


public class ModMaterialRules {
    private static final MaterialRules.MaterialRule WHITE = makeStateRule(ModBlocks.WHITE);

    public static MaterialRules.MaterialRule makeRules() {


        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.LIBRARY_OF_BABEL),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, WHITE)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, WHITE))

                );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}