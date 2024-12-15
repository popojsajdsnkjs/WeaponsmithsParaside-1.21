package net.gaeck.weaponsmithsparaside.enchantment;

import com.mojang.serialization.MapCodec;
import net.gaeck.weaponsmithsparaside.WeaponsmithsParaside;
import net.gaeck.weaponsmithsparaside.enchantment.custom.SmashEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {

    public static final MapCodec<? extends EnchantmentEntityEffect> SMASH =
            registerEntityEffect("smash", SmashEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends  EnchantmentEntityEffect> codec){
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(WeaponsmithsParaside.MOD_ID, name), codec);
    }

    public static void registerModEnchantmentEffects(){
        WeaponsmithsParaside.LOGGER.info("Registering enchantment effects for " + WeaponsmithsParaside.MOD_ID);
    }
}
