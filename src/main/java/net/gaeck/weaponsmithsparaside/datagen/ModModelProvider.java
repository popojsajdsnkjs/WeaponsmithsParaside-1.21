package net.gaeck.weaponsmithsparaside.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.gaeck.weaponsmithsparaside.block.ModBlocks;
import net.gaeck.weaponsmithsparaside.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // to create normal block use blockStateModelGenerator.registerSimpleCubeAll(block);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SMITHING_CRYSTAL_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // to create model use itemModelGenerator.register(item, Models.(kind of model));
        // use generated as kind of model to make usual minecraft item

        itemModelGenerator.register(ModItems.SMITHING_CRYSTAL_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SMITHING_CRYSTAL, Models.GENERATED);

    }
}
