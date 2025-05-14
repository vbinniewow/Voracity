package net.vbinnie.voracity.world.biome;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.vbinnie.voracity.Voracity;

public class ModBiomes {
    public static final RegistryKey<Biome> LIBRARY_OF_BABEL = register("library_of_babel");



public static RegistryKey<Biome> register(String name) {
    return RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Voracity.MOD_ID, name));
    }

    public static void bootstrap(Registerable<Biome> context) {
        context.register(LIBRARY_OF_BABEL, libraryOfBabel(context));
    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    public static void brightAbyssGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
    }





    public static Biome libraryOfBabel(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.ARMOR_STAND, 2, 3, 5));

        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        brightAbyssGeneration(biomeBuilder);

        DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);

        return new Biome.Builder()
                .precipitation(false)
                .downfall(0f)
                .temperature(0f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x000000)
                        .waterFogColor(0x000000)
                        .skyColor(0x000000)
                        .grassColor(0x000000)
                        .foliageColor(0x000000)
                        .fogColor(0x000000)
                        .moodSound(BiomeMoodSound.CAVE).build())
                .build();

    }
}
