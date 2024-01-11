package hernandiito.colormancer;

import hernandiito.colormancer.block.ModBlocks;
import hernandiito.colormancer.effect.ModStatusEffects;
import hernandiito.colormancer.item.ModItemGroups;
import hernandiito.colormancer.item.ModItems;
import hernandiito.colormancer.screen.ModScreenHandlerTypes;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Colormancer implements ModInitializer {
	public static final String MOD_ID = "colormancer";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerModItemGroups();
		ModItems.registerModItems();
		ModStatusEffects.registerModStatusEffects();
		ModBlocks.registerModBlocks();
		ModScreenHandlerTypes.registerModScreenHandlerTypes();
	}
}