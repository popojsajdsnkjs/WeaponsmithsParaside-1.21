package net.gaeck.weaponsmithsparaside.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gaeck.weaponsmithsparaside.WeaponsmithsParaside;
import net.gaeck.weaponsmithsparaside.item.custom.Frostbite;
import net.gaeck.weaponsmithsparaside.item.custom.HammerItem;
import net.gaeck.weaponsmithsparaside.item.custom.HammerMaceLowFallDamageItem;
import net.gaeck.weaponsmithsparaside.item.custom.Icebreaker;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;

public class ModItems {
    public static final Item SMITHING_CRYSTAL_SHARD = registerItem("smithing_crystal_shard", new Item(
        new Item.Settings()
    ));
    public static final Item SMITHING_CRYSTAL = registerItem("smithing_crystal", new Item(
        new Item.Settings()
    ));

    public static final Item STONE_HAMMER = registerItem("stone_hammer",
            new HammerItem(ToolMaterials.STONE,new Item.Settings().attributeModifiers(
                    PickaxeItem.createAttributeModifiers(ToolMaterials.STONE, 10, -3.6f))){
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.hammer_mine_3x3"));
                    if (Screen.hasShiftDown()){
                        tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.mace_hammer_behavior"));
                        tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.low_hammer_mace_stats"));

                    } else {
                        tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.shift_for_more_info"));
                    }
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
    public static final Item IRON_HAMMER = registerItem("iron_hammer",
            new HammerItem(ToolMaterials.IRON,new Item.Settings().attributeModifiers(
                    PickaxeItem.createAttributeModifiers(ToolMaterials.IRON, 10, -3.6f))){
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.hammer_mine_3x3"));
                    if (Screen.hasShiftDown()){
                        tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.mace_hammer_behavior"));
                        tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.low_hammer_mace_stats"));

                    } else {
                        tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.shift_for_more_info"));
                    }
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer",
            new HammerMaceLowFallDamageItem(ToolMaterials.DIAMOND,new Item.Settings().attributeModifiers(
                    PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 9.5f, -3.6f))){
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.hammer_mine_3x3"));
                    if (Screen.hasShiftDown()){
                        tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.mace_hammer_behavior"));
                        tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.low_hammer_mace_stats"));

                    } else {
                        tooltip.add(Text.translatable("tooltip.weaponsmithsparaside.shift_for_more_info"));
                    }
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });

    public static final Item ICEBREAKER = registerItem("icebreaker",
            new Icebreaker(ModToolMaterials.ICE,new Item.Settings().attributeModifiers(
                    PickaxeItem.createAttributeModifiers(ModToolMaterials.ICE, 9.5f, -3.6f)).rarity(Rarity.RARE)));
    public static final Item FROSTBITE = registerItem("frostbite",
            new Frostbite(ModToolMaterials.ICE,new Item.Settings().attributeModifiers(
                    SwordItem.createAttributeModifiers(ModToolMaterials.ICE, 3, -2.4f)).rarity(Rarity.RARE)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(WeaponsmithsParaside.MOD_ID, name), item);
    }

    public static void registerModItems(){
        WeaponsmithsParaside.LOGGER.info("Registering items for " + WeaponsmithsParaside.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->{
            entries.add(SMITHING_CRYSTAL_SHARD);
            entries.add(SMITHING_CRYSTAL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries ->{
            entries.add(STONE_HAMMER);
            entries.add(IRON_HAMMER);
            entries.add(DIAMOND_HAMMER);
            entries.add(ICEBREAKER);
            entries.add(FROSTBITE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries ->{
            entries.add(STONE_HAMMER);
            entries.add(IRON_HAMMER);
            entries.add(DIAMOND_HAMMER);
        });
    }
}
