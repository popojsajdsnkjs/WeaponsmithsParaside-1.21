package net.gaeck.weaponsmithsparaside.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gaeck.weaponsmithsparaside.WeaponsmithsParaside;
import net.gaeck.weaponsmithsparaside.item.custom.HammerItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SMITHING_CRYSTAL_SHARD = registerItem("smithing_crystal_shard", new Item(
        new Item.Settings()
    ));
    public static final Item SMITHING_CRYSTAL = registerItem("smithing_crystal", new Item(
        new Item.Settings()
    ));

    public static final Item STONE_HAMMER = registerItem("stone_hammer",
            new HammerItem(ToolMaterials.STONE,new Item.Settings().attributeModifiers(
                    PickaxeItem.createAttributeModifiers(ToolMaterials.STONE, 10, -3.6f))));

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
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries ->{
            entries.add(STONE_HAMMER);
        });
    }
}
