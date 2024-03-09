package hernandiito.colormancer;

import hernandiito.colormancer.block.ColormancerBlocks;
import hernandiito.colormancer.block.entity.ColormancerBlockEntities;
import hernandiito.colormancer.effect.ColormancerEffects;
import hernandiito.colormancer.item.ColormancerItemGroups;
import hernandiito.colormancer.item.ColormancerItems;
import hernandiito.colormancer.potion.ModPotions;
import hernandiito.colormancer.screen.ColormancerScreenHandlers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Colormancer implements ModInitializer {
	public static final String MOD_ID = "colormancer";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ColormancerItemGroups.registerItemGroups();
		ColormancerItems.registerModItems();
		ColormancerEffects.registerEffects();
		ColormancerBlocks.registerModBlocks();
		ColormancerScreenHandlers.registerScreenHandlers();
		ColormancerBlockEntities.registerBlockEntities();
		ModPotions.registerPotions();
	}
}