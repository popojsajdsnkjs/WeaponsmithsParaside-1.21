package net.gaeck.weaponsmithsparaside.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record SmashEnchantmentEffect() implements EnchantmentEntityEffect {//rightclick the enchantment entity effect than go to enchantmentlocationbasedeffect and right clikck and og to implementations
    public static final MapCodec<SmashEnchantmentEffect> CODEC = MapCodec.unit(SmashEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity target, Vec3d pos) {
        if (target instanceof LivingEntity livingTarget){
            if (level > 0){
                if (level < 3) {
                    livingTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5 + 5 * level, 1));
                } else {
                    livingTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 10 + 5 * level, 2));
                }
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
