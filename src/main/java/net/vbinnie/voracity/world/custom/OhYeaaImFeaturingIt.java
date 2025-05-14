package net.vbinnie.voracity.world.custom;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.vbinnie.voracity.Voracity;

import java.util.Optional;

public class OhYeaaImFeaturingIt extends Feature<DefaultFeatureConfig> {
    public OhYeaaImFeaturingIt() {
        super(DefaultFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        BlockPos chunkPos = context.getOrigin();
        ServerWorld world = ((ServerWorld) context.getWorld());

        // Adjust Y to a suitable height (e.g., surface or fixed)
        int y = world.getTopY(Heightmap.Type.WORLD_SURFACE, chunkPos.getX(), chunkPos.getZ());
        BlockPos structurePos = new BlockPos(chunkPos.getX(), y, chunkPos.getZ());

        StructureTemplateManager manager = world.getStructureTemplateManager();
        Optional<StructureTemplate> templateOptional = manager.getTemplate(new Identifier(Voracity.MOD_ID, "book_chunk"));

        if (templateOptional.isPresent()) {
            StructureTemplate template = templateOptional.get();

            template.place(world, structurePos,
                    structurePos,
                    new StructurePlacementData()
                            .setIgnoreEntities(false)
                            .setMirror(BlockMirror.NONE)
                            .setRotation(BlockRotation.NONE)
                            .setRandom(context.getRandom()),
                    context.getRandom(),
                    3);


            return true;
        }

        return false;
    }
}