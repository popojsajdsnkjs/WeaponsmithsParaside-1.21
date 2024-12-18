package net.gaeck.weaponsmithsparaside.item.custom;

import net.gaeck.weaponsmithsparaside.effect.ModEffect;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class Icebreaker extends HammerMaceLowFallDamageItem{
    public Icebreaker(ToolMaterial material, Settings settings) {
        super(material, settings);
    }
    @Override
    public float getBonusAttackDamage(Entity target, float baseAttackDamage, DamageSource damageSource) {
        if (damageSource.getSource() instanceof LivingEntity livingEntity) {
            int height = Math.round(livingEntity.fallDistance);
            float maceDamage = 0;
            if (!shouldDealAdditionalDamage(livingEntity)) {
                maceDamage = 0;
            } else if (height < 50) {
                maceDamage = 0.25f * height;
            } else {
                maceDamage = 15;
            }

            int frozenDamage = 0;
            if (target instanceof LivingEntity livingTarget) {
                if (livingTarget.hasStatusEffect(ModEffect.FROZEN)) {
                    frozenDamage = 5;
                }
            }
            return livingEntity.getWorld() instanceof ServerWorld serverWorld
                    ? frozenDamage + maceDamage + EnchantmentHelper.getSmashDamagePerFallenBlock(serverWorld, livingEntity.getWeaponStack(), target, damageSource, 0.0F) : maceDamage + frozenDamage;

        } else {
            return 0.0F;
        }
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target.hasStatusEffect(ModEffect.FROZEN)){
            return super.postHit(stack, target, attacker);
        } else {
            target.addStatusEffect(new StatusEffectInstance(ModEffect.FROZEN, 200, 1), attacker);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.hammer_mine_3x3"));
        if (Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.mace_hammer_behavior"));
            tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.low_hammer_mace_stats"));
            tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.white_space_line"));
            tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.frozen_inflicting"));
            tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.frozen_damage_boost"));

        } else {
            tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.shift_for_more_info"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
