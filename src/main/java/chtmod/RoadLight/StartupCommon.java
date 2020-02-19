package chtmod.RoadLight;

import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupCommon {
	public static Light rlight = new Light("RoadLight");
	public static ItemBlock irlight = (ItemBlock) new ItemBlock(rlight).setRegistryName(rlight.getRegistryName());
	public static FBLight rlight0 = new FBLight("RoadLight0");
	public static ItemBlock irlight0 = (ItemBlock) new ItemBlock(rlight0).setRegistryName(rlight0.getRegistryName());
	public static NRLight lights[] = new NRLight[] { new NRLight("RoadLight1", 1), new NRLight("RoadLight2", 1),
			new NRLight("RoadLight3", 1), new NRLight("RoadLight4", 2), new NRLight("RoadLight5", 0, false) };
	public static ItemBlock[] inrlights = new ItemBlock[5];

	public static void preInitCommon() {
		GameRegistry.register(rlight);
		GameRegistry.register(irlight);
		GameRegistry.register(rlight0);
		GameRegistry.register(irlight0);
		for (int i = 0; i < 5; i++) {
			ItemBlock light = (ItemBlock) new ItemBlock(lights[i]).setRegistryName(lights[i].getRegistryName());
			GameRegistry.register(lights[i]);
			inrlights[i] = light;
			GameRegistry.register(light);
		}
	}

}
