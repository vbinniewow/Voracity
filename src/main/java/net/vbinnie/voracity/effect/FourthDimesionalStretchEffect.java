package net.vbinnie.voracity.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.world.World;
import net.vbinnie.voracity.damage_type.ModDamageTypes;


public class FourthDimesionalStretchEffect extends StatusEffect {
    public FourthDimesionalStretchEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

        @Override
        public void applyUpdateEffect(LivingEntity entity, int amplifier) {
            World world = entity.getWorld();


            if (!world.isClient() && entity.age % 100 - amplifier <= 0) {
                entity.damage(ModDamageTypes.of(world, ModDamageTypes.FOURTHDIMENSION), 2f * amplifier);
            }
        }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {

        return true;
    }
}
