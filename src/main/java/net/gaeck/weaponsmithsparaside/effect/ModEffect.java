package net.gaeck.weaponsmithsparaside.effect;

import net.gaeck.weaponsmithsparaside.WeaponsmithsParaside;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffect {

    public static final RegistryEntry<StatusEffect> FROZEN = registerStatusEffect("frozen", new FrozenEffect(StatusEffectCategory.HARMFUL, 0x00aaaa)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, Identifier.of(WeaponsmithsParaside.MOD_ID, "frozen"), -0.1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect){
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(WeaponsmithsParaside.MOD_ID, name), statusEffect);
    }

    public static void registerEffects(){
        WeaponsmithsParaside.LOGGER.info("Registering mob effects for " + WeaponsmithsParaside.MOD_ID);
    }
}
