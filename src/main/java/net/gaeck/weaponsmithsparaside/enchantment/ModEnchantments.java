package net.gaeck.weaponsmithsparaside.enchantment;

import net.gaeck.weaponsmithsparaside.WeaponsmithsParaside;
import net.gaeck.weaponsmithsparaside.enchantment.custom.SmashEnchantmentEffect;
import net.gaeck.weaponsmithsparaside.util.ModTags;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEnchantments {

    public static final RegistryKey<Enchantment> SMASH =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(WeaponsmithsParaside.MOD_ID,"smash"));

    public static void bootstrap(Registerable<Enchantment> registerable){
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, SMASH, Enchantment.builder(Enchantment.definition(
                items.getOrThrow(ModTags.Items.SMASH_ENCHANTABLE),
                2,
                3,
                Enchantment.leveledCost(0,10),
                Enchantment.leveledCost(5,10),
                4,
                AttributeModifierSlot.MAINHAND
        )).addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER,EnchantmentEffectTarget.VICTIM,new SmashEnchantmentEffect()));
    }

    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder){
        registry.register(key, builder.build(key.getValue()));
    }
}
