package net.vbinnie.voracity.damage_type;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.vbinnie.voracity.Voracity;


public class ModDamageTypes {

    public static final RegistryKey<DamageType> FOURTHDIMENSION = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(Voracity.MOD_ID, "fourthdimension"));

    public static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}
