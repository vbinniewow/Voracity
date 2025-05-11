package net.vbinnie.voracity.mixin;

import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ChickenMixin {


        @Inject(method = "isFireproof", at = @At("HEAD"), cancellable = true)
        private void makeChickenFireproof (CallbackInfoReturnable < Boolean > cir) {
        if ((Object) this == Items.CHICKEN) {
            cir.setReturnValue(true);
        }
    }
}