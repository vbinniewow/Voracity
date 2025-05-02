package net.vbinnie.voracity.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.vbinnie.voracity.block.ModBlocks;
import net.vbinnie.voracity.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {



    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> recipeExporter) {

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.NETHERGOLD_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.NETHERGOLD_INGOT)
                .criterion(hasItem(ModItems.NETHERGOLD_INGOT), conditionsFromItem(ModItems.NETHERGOLD_INGOT))
                .offerTo(recipeExporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.END_MINERAL_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.END_MINERAL)
                .criterion(hasItem(ModItems.END_MINERAL), conditionsFromItem(ModItems.END_MINERAL))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FILTHY_PIG_EYE)
                .pattern(" G ")
                .pattern("GHG")
                .pattern(" G ")
                .input('G', Items.GOLD_INGOT)
                .input('H', ModItems.HOGLIN_EYE)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NETHERGOLD_INGOT, 2)
                .pattern("NFG")
                .input('G', Items.GOLD_INGOT)
                .input('F', ModItems.FILTHY_PIG_EYE)
                .input('N', Items.NETHERITE_SCRAP)
                .criterion(hasItem(ModItems.NETHERGOLD_INGOT), conditionsFromItem(ModItems.NETHERGOLD_INGOT))
                .offerTo(recipeExporter, new Identifier(getRecipeName(ModItems.NETHERGOLD_INGOT) + "_recipe_1"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NETHERGOLD_INGOT, 2)
                .pattern("GFN")
                .input('G', Items.GOLD_INGOT)
                .input('F', ModItems.FILTHY_PIG_EYE)
                .input('N', Items.NETHERITE_SCRAP)
                .criterion(hasItem(ModItems.NETHERGOLD_INGOT), conditionsFromItem(ModItems.NETHERGOLD_INGOT))
                .offerTo(recipeExporter, new Identifier(getRecipeName(ModItems.NETHERGOLD_INGOT) + "_recipe_1_alt"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NETHERGOLD_INGOT, 9)
                .input(ModBlocks.NETHERGOLD_BLOCK)
                .criterion(hasItem(ModBlocks.NETHERGOLD_BLOCK), conditionsFromItem(ModBlocks.NETHERGOLD_BLOCK))
                .offerTo(recipeExporter, new Identifier(getRecipeName(ModItems.NETHERGOLD_INGOT) + "_recipe2"));


    }
}
