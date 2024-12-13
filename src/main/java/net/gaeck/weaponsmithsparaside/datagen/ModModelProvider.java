package net.gaeck.weaponsmithsparaside.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // to create normal block use blockStateModelGenerator.registerSimpleCubeAll(block);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // to create model use itemModelGenerator.register(item, model.(kind of model));
        // use generated as kind of model to make usual minecraft item

    }
}
