package hernandiito.colormancer;

import hernandiito.colormancer.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ColormancerDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ColormancerAdvancementProvider::new);

		pack.addProvider(ColormancerBlockTagProvider::new);
		pack.addProvider(ColormancerItemTagProvider::new);

		pack.addProvider(ColormancerBlockLootTableProvider::new);

		pack.addProvider(ColormancerModelProvider::new);

		pack.addProvider(ColormancerRecipeProvider::new);
	}
}
