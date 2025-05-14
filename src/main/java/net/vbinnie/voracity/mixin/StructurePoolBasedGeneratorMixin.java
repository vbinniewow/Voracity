package net.vbinnie.voracity.mixin;

import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;

@Mixin(StructurePoolBasedGenerator.class)
public class StructurePoolBasedGeneratorMixin {

    @Inject(
        method = "generate",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void injectCustomDepthLimit(
        StructureTemplateManager manager,
        ServerWorldAccess world,
        StructurePool pool,
        StructurePoolElement element,
        int depth,
        BlockPos pos,
        boolean rigid,
        BlockRotation rotation,
        BlockBox boundingBox,
        Set<Identifier> placed,
        boolean keepJigsaws,
        CallbackInfoReturnable<Boolean> cir
    ) {
        if (depth > 20) {  // Your custom limit here
            cir.setReturnValue(false); // Prevent further structure generation
        }
    }
}
