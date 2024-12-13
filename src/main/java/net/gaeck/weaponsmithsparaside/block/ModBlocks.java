package net.gaeck.weaponsmithsparaside.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gaeck.weaponsmithsparaside.WeaponsmithsParaside;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block SMITHING_CRYSTAL_ORE = registerBlock("smithing_crystal_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(0, 1), AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(WeaponsmithsParaside.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(WeaponsmithsParaside.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        WeaponsmithsParaside.LOGGER.info("Registering Mod Blocks for" + WeaponsmithsParaside.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(SMITHING_CRYSTAL_ORE);
        });
    }
}
