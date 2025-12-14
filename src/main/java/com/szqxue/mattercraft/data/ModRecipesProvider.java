package com.szqxue.mattercraft.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author SZQ23
 */
public class ModRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        super.buildRecipes(recipeOutput);

    }
    // 添加同结果的熔炼和熔炼来源
    // public static final List<ItemLike> ORES = List.of(ModItems.EXAMPLE_ITEM);

    protected static void oreSmelting(@NotNull RecipeOutput recipeOutput,
                                      List<ItemLike> ingredients, @NotNull RecipeCategory category,
                                      @NotNull ItemLike result, float experience, int cookingTime, @NotNull String group) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new,
                ingredients, category, result, experience, cookingTime, group, "_from_smelting");
    }

    protected static void oreBlasting(@NotNull RecipeOutput recipeOutput,
                                      List<ItemLike> ingredients, @NotNull RecipeCategory category,
                                      @NotNull ItemLike result, float experience, int cookingTime, @NotNull String group) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new,
                ingredients, category, result, experience, cookingTime, group, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(@NotNull RecipeOutput recipeOutput,
                                                                       RecipeSerializer<T> serializer,
                                                                       AbstractCookingRecipe.@NotNull Factory<T> recipeFactory,
                                                                       List<ItemLike> ingredients,
                                                                       @NotNull RecipeCategory category, @NotNull ItemLike result,
                                                                       float experience, int cookingTime,
                                                                       @NotNull String group, String suffix) {
        for (ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category,
                    result, experience, cookingTime, serializer,
                    recipeFactory).group(group).unlockedBy(getHasName(itemlike),
                    has(itemlike)).save(recipeOutput, getItemName(result) + suffix + "_" + getItemName(itemlike));
        }

    }
}
