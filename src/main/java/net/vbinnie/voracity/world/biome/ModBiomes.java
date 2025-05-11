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
import net.vbinnie.idolatry.Idolatry;

public class ModBiomes {
    public static final RegistryKey<Biome> BRIGHT_ABYSS = register("bright_abyss");
    public static final RegistryKey<Biome> BURNING_GARDEN = register("burning_garden");


public static RegistryKey<Biome> register(String name) {
    return RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Idolatry.MOD_ID, name));
    }

    public static void bootstrap(Registerable<Biome> context) {
        context.register(BRIGHT_ABYSS, brightAbyss(context));
        context.register(BURNING_GARDEN, burningGarden(context));
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





    public static Biome brightAbyss(Registerable<Biome> context) {
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
                        .waterColor(0xffffff)
                        .waterFogColor(0xffffff)
                        .skyColor(0xffffff)
                        .grassColor(0xffffff)
                        .foliageColor(0xffffff)
                        .fogColor(0xffffff)
                        .moodSound(BiomeMoodSound.CAVE).build())
                .build();

    }


    public static Biome burningGarden(Registerable<Biome> context) {
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
                        .waterColor(0xffffff)
                        .waterFogColor(0xffffff)
                        .skyColor(0xffffff)
                        .grassColor(0xffffff)
                        .foliageColor(0xffffff)
                        .fogColor(0xffffff)
                        .moodSound(BiomeMoodSound.CAVE).build())
                .build();

    }
}
