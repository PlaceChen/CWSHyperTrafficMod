package chtmod.RoadLight;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;

public class StartupClientOnly {
	public static void preinitClientOnly() {
		ModelLoader.setCustomModelResourceLocation(StartupCommon.irlight, 0,
				new ModelResourceLocation("chtmod:RoadLight", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.irlight0, 0,
				new ModelResourceLocation("chtmod:RoadLight0", "inventory"));
		for (ItemBlock ib : StartupCommon.inrlights)
			ModelLoader.setCustomModelResourceLocation(ib, 0,
					new ModelResourceLocation(ib.getRegistryName(), "inventory"));
	}

}
