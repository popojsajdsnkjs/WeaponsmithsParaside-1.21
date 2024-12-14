package net.gaeck.weaponsmithsparaside;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.gaeck.weaponsmithsparaside.block.ModBlocks;
import net.gaeck.weaponsmithsparaside.item.ModItems;
import net.gaeck.weaponsmithsparaside.util.HammerUsageEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeaponsmithsParaside implements ModInitializer {
	public static final String MOD_ID = "weaponsmithsparaside";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}