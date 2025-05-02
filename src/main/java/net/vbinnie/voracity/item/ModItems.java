package net.vbinnie.voracity.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.util.PlacedFeatureIndexer;
import net.vbinnie.voracity.Voracity;
import net.vbinnie.voracity.item.custom.AmethystCarver;
import net.vbinnie.voracity.item.custom.Sifter;

public class ModItems {

    public static final Item NETHERGOLD_INGOT = registerItem("nethergold_ingot", new Item(new Item.Settings()));

    public static final Item HOGLIN_EYE = registerItem("hoglin_eye", new Item(new Item.Settings()));

    public static final Item AMETHYST_CARVER = registerItem("amethyst_carver", new AmethystCarver(new Item.Settings().maxCount(1)));

    public static final Item FILTHY_PIG_EYE = registerItem("filthy_pig_eye", new Item(new Item.Settings()));

    public static final Item SIFT = registerItem("sift", new Sifter(new Item.Settings().maxCount(1)));

    public static final Item END_MINERAL = registerItem("end_mineral", new Item(new Item.Settings()));

    public static final Item CHORUS_NIBBLE = registerItem("chorus_nibble", new Item(new Item.Settings()));

    public static final Item SIFTED_END_MINERAL = registerItem("sifted_end_mineral", new Item(new Item.Settings()));

    public static final Item MANCATCHER = registerItem("mancatcher",
            new SwordItem(ToolMaterials.NETHERITE, 4, -2.8f,
              new Item.Settings().fireproof()));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Voracity.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Voracity.LOGGER.info("Registering Mod Items for " + Voracity.MOD_ID);
    }
}

