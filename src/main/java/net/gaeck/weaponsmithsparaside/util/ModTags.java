package net.gaeck.weaponsmithsparaside.util;

import net.gaeck.weaponsmithsparaside.WeaponsmithsParaside;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(WeaponsmithsParaside.MOD_ID,name));
        }
    }

    public static class Items{

        public static final TagKey<Item> SMASH_ENCHANTABLE = createTag("smash_enchantable");

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(WeaponsmithsParaside.MOD_ID,name));
        }
    }
}
