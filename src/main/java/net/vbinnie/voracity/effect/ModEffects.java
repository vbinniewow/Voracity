package net.vbinnie.voracity.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.vbinnie.voracity.Voracity;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> SPAGHETTIFICATION = registerStatusEffect("spaghettification",
            new SpaghettificationEffect(StatusEffectCategory.HARMFUL, 0x00ffcc));



    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Voracity.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        Voracity.LOGGER.info("Registering Mod Effects for " + Voracity.MOD_ID);
    }
}
