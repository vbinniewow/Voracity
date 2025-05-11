package net.vbinnie.voracity.world.dimension;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.vbinnie.idolatry.Idolatry;

import java.util.OptionalLong;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> ABYSS_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            Identifier.of(Idolatry.MOD_ID, "abyss"));
    public static final RegistryKey<World> ABYSS_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            Identifier.of(Idolatry.MOD_ID, "abyss"));
    public static final RegistryKey<DimensionType> ABYSS_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            Identifier.of(Idolatry.MOD_ID, "abyss_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(ABYSS_DIM_TYPE, new DimensionType(
                OptionalLong.of(3000), // fixedTime
                false, // hasSkylight
                true, // hasCeiling
                true, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY
                320, // height
                320, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DimensionTypes.OVERWORLD_ID, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)));
    }
}
