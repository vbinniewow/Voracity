package net.vbinnie.voracity.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.vbinnie.voracity.item.ModItems;

public class ModLootTableModifier {


    public static void register() {
        LootTableEvents.MODIFY.register((idfk, lootManager, id, tableBuilder, source ) -> {


            if(EntityType.HOGLIN.getLootTableId().equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(.25f))
                        .with(ItemEntry.builder(net.vbinnie.voracity.item.ModItems.HOGLIN_EYE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
                    }
        });
            }
        }
