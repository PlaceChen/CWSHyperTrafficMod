package chtmod.BlockRoad.Slope;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class StartupClientOnly {
	public static void preInitClientOnly() {
		ModelLoader.setCustomModelResourceLocation(StartupCommon.isb, 0,
				new ModelResourceLocation("chtmod:slopebitumen/normal", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.isb, 1,
				new ModelResourceLocation("chtmod:slopebitumen/white", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.isb, 2,
				new ModelResourceLocation("chtmod:slopebitumen/yellow", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.isb, 3,
				new ModelResourceLocation("chtmod:slopebitumen/yellowdouble", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.isb, 4,
				new ModelResourceLocation("chtmod:slopebitumen/whitedot", "inventory"));
	}
}