package net.gaeck.weaponsmithsparaside.item.custom;

import net.gaeck.weaponsmithsparaside.effect.ModEffect;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.math.random.RandomSeed;

import java.util.List;
import java.util.random.RandomGenerator;

public class Frostbite extends SwordItem {
    public Frostbite(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public float getBonusAttackDamage(Entity target, float baseAttackDamage, DamageSource damageSource) {
        if (damageSource.getSource() instanceof LivingEntity livingEntity) {
            int frozenDamage = 0;
            if (target instanceof LivingEntity livingTarget) {
                if (livingTarget.hasStatusEffect(ModEffect.FROZEN)) {
                    frozenDamage = 5;
                }
            }
            return frozenDamage;

        } else {
            return 0.0F;
        }
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target.hasStatusEffect(ModEffect.FROZEN)){
            return super.postHit(stack, target, attacker);
        } else {
            int randomNum = (int)(Math.random() * 6);
            if (randomNum == 0) {
                target.addStatusEffect(new StatusEffectInstance(ModEffect.FROZEN, 200, 1), attacker);
            }
            }
        return super.postHit(stack, target, attacker);
    }



    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.ice_origin"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
