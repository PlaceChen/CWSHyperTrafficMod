package chtmod.RoadBlock;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;

public class StartupClientOnly {
	public static void preinitClientOnly() {
		for (ItemBlock i : StartupCommon.items)
			ModelLoader.setCustomModelResourceLocation(i, 0,
					new ModelResourceLocation(i.getRegistryName(), "inventory"));
	}

}
