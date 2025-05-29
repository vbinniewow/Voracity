package net.vbinnie.voracity.item.custom;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;

import java.util.Collection;

public class Mancatcher extends SwordItem {


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 100));

        for (StatusEffectInstance effect : target.getStatusEffects()) {
            StatusEffect statusEffect = effect.getEffectType();

            if (statusEffect.getCategory() == StatusEffectCategory.BENEFICIAL || statusEffect.getCategory() == StatusEffectCategory.NEUTRAL) {
                target.removeStatusEffect(statusEffect);
                attacker.addStatusEffect(new StatusEffectInstance(statusEffect, effect.getDuration(), effect.getAmplifier())); // Add to self
            }
        }
        if (target.getType() == EntityType.DOLPHIN) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 800));
        }
        if (target.getType() == EntityType.TURTLE   ) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 100));
        }
        if (target.getType() == EntityType.WARDEN) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 800));
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 800));
        }

        if (target.getType() == EntityType.GLOW_SQUID) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 800));
        }



        if (target.getType() == EntityType.DROWNED || target.getType() == EntityType.DOLPHIN || target.getType() == EntityType.PUFFERFISH || target.getType() == EntityType.SALMON || target.getType() == EntityType.COD  || target.getType() == EntityType.TROPICAL_FISH || target.getType() == EntityType.GUARDIAN || target.getType() == EntityType.ELDER_GUARDIAN || target.getType() == EntityType.TURTLE || target.getType() == EntityType.SQUID || target.getType() == EntityType.GLOW_SQUID)  {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 800));
        }

        if (target.getType() == EntityType.PIG || target.getType() == EntityType.PIGLIN || target.getType() == EntityType.PIGLIN_BRUTE || target.getType() == EntityType.ZOMBIFIED_PIGLIN || target.getType() == EntityType.HOGLIN) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 20, 1));
        }

        if (target.getType() == EntityType.IRON_GOLEM || target.getType() == EntityType.HOGLIN ) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 800));
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 800));
        }

        if (target.getType() == EntityType.PILLAGER || target.getType() == EntityType.VINDICATOR  || target.getType() == EntityType.EVOKER ) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 800));
        }


        if (target.getType() == EntityType.STRIDER) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 800));
        }

        if (target.getType() == EntityType.HORSE || target.getType() == EntityType.SKELETON_HORSE || target.getType() == EntityType.ZOMBIE_HORSE) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 800, 2));
        }

        return super.postHit(stack, target, attacker);
    }

    public Mancatcher(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }


}
