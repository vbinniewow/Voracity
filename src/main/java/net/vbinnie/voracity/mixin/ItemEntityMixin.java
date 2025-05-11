package net.vbinnie.voracity.mixin
        ;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;
import net.vbinnie.voracity.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import terrablender.api.Region;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity {

    @Shadow public abstract boolean damage(DamageSource source, float amount);

    @Shadow public abstract void setDespawnImmediately();

    public ItemEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        if (!this.getWorld().isClient) {
            ItemStack stack = ((ItemEntity) (Object) this).getStack();



            if (this.isInLava() && stack.getItem().equals(Items.CHICKEN )) {


                    ItemStack stack2 = new ItemStack(ModItems.LAVA_CHICKEN, stack.getCount());

                    ItemEntity itemEntity = new ItemEntity(
                            this.getWorld(),
                            this.getX(), // Center of the block
                            this.getY(),
                            this.getZ(),
                            stack2

                    );
                    this.kill();


                    System.out.println("Lalalalava chchchchchicken");

                this.getWorld().spawnEntity(itemEntity);
            }

            if (this.isSubmergedInWater()) {

            }
        }
    }


}