package chtmod.RoadLight;

import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupCommon {
	public static Light lights[] = new Light[] { new Light("RoadLight", 1), new Light("RoadLight0", 0, false),
			new RotationLight("RoadLight1", 1), new RotationLight("RoadLight2", 1), new RotationLight("RoadLight3", 1),
			new RotationLight("RoadLight4", 2), new RotationLight("RoadLight5", 0, false),
			new RotationLight("RoadLight6", 0, false), new RotationLight("RoadLight7", 3),
			new RotationLight("RoadLight8", 4, false), new Light("RoadLight9", 2, false),
			new Light("RoadLight10", 3, false), new Light("RoadLight11", 0, false), new RotationLight("RoadLight12", 5),
			new RotationLight("RoadLight13", 3) };
	public static ItemBlock[] inrlights = new ItemBlock[lights.length];

	public static void preInitCommon() {
		for (int i = 0; i < lights.length; i++) {
			ItemBlock light = (ItemBlock) new ItemBlock(lights[i]).setRegistryName(lights[i].getRegistryName());
			GameRegistry.register(lights[i]);
			inrlights[i] = light;
			GameRegistry.register(light);
		}
	}
}