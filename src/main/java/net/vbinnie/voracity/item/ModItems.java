package net.vbinnie.voracity.item;

import jdk.jshell.Snippet;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import net.vbinnie.voracity.Voracity;
import net.vbinnie.voracity.effect.ModEffects;
import net.vbinnie.voracity.item.custom.AmethystCarver;
import net.vbinnie.voracity.item.custom.Mancatcher;
import net.vbinnie.voracity.item.custom.Sifter;

public class ModItems {

    public static final Item NETHERGOLD_INGOT = registerItem("nethergold_ingot", new Item(new Item.Settings()));

    public static final Item HOGLIN_EYE = registerItem("hoglin_eye", new Item(new Item.Settings()));


    public static final Item CHICKEN_HOGLIN_EYE_SOUP = registerItem("chicken_hoglin_eye_soup", new Item(new Item.Settings()
            .food(
            new FoodComponent.Builder()
                    .meat()
                    .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 600, 1, true, true), 75)
                    .saturationModifier(3)
                    .build())
    ));

    public static final Item LAVA_CHICKEN = registerItem("lava_chicken", new Item(new Item.Settings()
            .food(
                    new FoodComponent.Builder()
                            .meat()
                            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 0, true, true), 100)
                            .saturationModifier(3)
                            .build())
            .rarity(Rarity.EPIC)
            .fireproof()));


    public static final Item AMETHYST_CARVER = registerItem("amethyst_carver", new AmethystCarver(new Item.Settings().maxCount(1).maxDamage(250)));

    public static final Item FILTHY_PIG_EYE = registerItem("filthy_pig_eye", new Item(new Item.Settings()));

    public static final Item SIFT = registerItem("sift", new Sifter(new Item.Settings().maxCount(1)));

    public static final Item END_MINERAL = registerItem("end_mineral", new Item(new Item.Settings()));

    public static final Item CHORUS_NIBBLE = registerItem("chorus_nibble", new Item(new Item.Settings()));

    public static final Item SIFTED_END_MINERAL = registerItem("sifted_end_mineral", new Item(new Item.Settings()));


   public static final Item END_SUGAR = registerItem("end_sugar", new Item(new Item.Settings().food(new FoodComponent.Builder().alwaysEdible().statusEffect(new StatusEffectInstance(ModEffects.FOURTHDIMENSIONALSTRETCHING, StatusEffectInstance.INFINITE), 100).build())));



    public static final Item MANCATCHER = registerItem("mancatcher",
            new Mancatcher(ToolMaterials.NETHERITE, 4, -2.8f,
              new Item.Settings().fireproof()));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Voracity.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Voracity.LOGGER.info("Registering Mod Items for " + Voracity.MOD_ID);
    }
}

