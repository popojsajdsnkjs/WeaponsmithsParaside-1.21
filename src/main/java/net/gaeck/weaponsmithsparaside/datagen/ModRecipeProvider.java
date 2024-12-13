package net.gaeck.weaponsmithsparaside.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.gaeck.weaponsmithsparaside.block.ModBlocks;
import net.gaeck.weaponsmithsparaside.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        //List<ItemConvertible> NAME_OF_LIST = List.of(you add here your items or block);
        // the upper line creates list of elements where their result (of smelting under) will be the same
        //offerSmelting(recipeExporter, THE_LIST, recipe category, result, experience it gives, time it smelts, group(idk either));
        //offerBlasting(recipeExporter, THE_LIST, recipe category, result, experience it gives, time it smelts (should be lower than smelting), group(idk either));

        //for making block like iron block or emerald block: offerReversibleCompactingRecipes(recipeExporter,recipe category for item, item to craft block, recipe category for block, that is crafted block);
        // the upper line creates recipe that allows you to craft  block and uncraft it (9 items to block, block to 9 items) <- from tutorial mod

        /*
                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.UNCHISEL)
                .pattern("II")
                .pattern("IS")
                .input('I', ModItems.GREENIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.GREENIUM_INGOT),conditionsFromItem(ModItems.GREENIUM_INGOT))// unlocks recipe
                .offerTo(recipeExporter);

                thats how you do shaped recipes
                the grid can be any size as long as it is 3x3 or lower
         */

        /*
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.GREENIUM_COAL)
                .input(ModItems.RAW_GREENIUM)
                .input(ModItems.RAW_GREENIUM)
                .input(ModItems.RAW_GREENIUM)
                .input(ModItems.RAW_GREENIUM)
                .input(Items.COAL)
                .criterion(hasItem(ModItems.RAW_GREENIUM),conditionsFromItem(ModItems.RAW_GREENIUM))
                .offerTo(recipeExporter);

                thats how you make shapeless recipes
                the min amount of input is 1
                the max amount of input is 9 cause thats how many things you can put in crafting table
         */

        // if you want methods to create pickaxe,axe,hoe,shovel,sword go to tutorial mod

        //recipes are named after what the result is so if you want to make more than one you need to add IdentifierOf(modname.MOD_ID, "name_of_recipe") i offer to after the exporter

        List<ItemConvertible> SMITHING_CRYSTAL_SHARD_SMELTABLES = List.of(ModBlocks.SMITHING_CRYSTAL_ORE);
        offerSmelting(recipeExporter, SMITHING_CRYSTAL_SHARD_SMELTABLES, RecipeCategory.MISC, ModItems.SMITHING_CRYSTAL_SHARD,0.1f,200,"smithing_crystal_shard");
        offerBlasting(recipeExporter, SMITHING_CRYSTAL_SHARD_SMELTABLES, RecipeCategory.MISC, ModItems.SMITHING_CRYSTAL_SHARD,0.1f,100,"smithing_crystal_shard");

        offerCompactingRecipe(recipeExporter, RecipeCategory.MISC, ModItems.SMITHING_CRYSTAL, ModItems.SMITHING_CRYSTAL_SHARD);
    }
}
