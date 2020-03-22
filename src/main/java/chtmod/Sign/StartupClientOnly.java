package chtmod.Sign;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupClientOnly {
	public static ItemSignPlus isp = new ItemSignPlus();
	public static ItemMetroSign ims = new ItemMetroSign();

	public static void preInitClientOnly() {
		GameRegistry.register(isp);
		GameRegistry.register(ims);
		ModelLoader.setCustomModelResourceLocation(ims, 0,
				new ModelResourceLocation("chtmod:sign/ItemMetroSign", "inventory"));
		for (int i = 0; i < 7; i++)
			ModelLoader.setCustomModelResourceLocation(isp, i,
					new ModelResourceLocation("chtmod:sign/ItemPlus", "inventory"));
		for (ISign is : StartupCommon.isign) {
			String iname = is.getRegistryName().getResourcePath();
			String in = iname.toLowerCase().replace("sign", "");
			ModelLoader.setCustomModelResourceLocation(is, 0,
					new ModelResourceLocation("chtmod:sign/" + in, "inventory"));
		}
	}

	public static void initClientOnly() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySignEntity.class, new TileEntitySignRenderer());
	}
}