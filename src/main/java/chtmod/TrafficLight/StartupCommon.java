package chtmod.TrafficLight;

import java.util.ArrayList;

import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupCommon {
	public static TrafficLight[] tl = { new TrafficLight("B", 0), new TrafficLight("R", 0), new TrafficLight("T", 0),
			new TrafficLight("Straight", 1), new TrafficLight("Left", 1), new TrafficLight("Right", 1),
			new TrafficLight("Bike", 1), new TrafficLight("Back", 1), new TrafficLight("Circle", 1),
			new TrafficLight("People", 1), new TrafficLight("Straight1", 2), new TrafficLight("Left1", 2),
			new TrafficLight("Straight2", 0), new TrafficLight("Straight3", 0), new TrafficLight("Left2", 0),
			new TrafficLight("Left3", 0), new TrafficLight("Bike2", 1), new TrafficLight("Circle2", 0),
			new TrafficLight("Circle3", 0), new TrafficLight("L", 0) };
	public static ItemBlock[] itl;
	public static BlockSignalProvider sp = new BlockSignalProvider();
	public static ItemConnectTraffic ct = new ItemConnectTraffic();

	public static void preInitCommon() {
		GameRegistry.registerTileEntity(TileEntityTrafficLightEntity.class, "TileEntityTrafficLightEntity");
		GameRegistry.registerTileEntity(TileEntitySignalProviderEntity.class, "TileEntitySignalProviderEntity");
		GameRegistry.register(ct);
		GameRegistry.register(sp);
		ItemBlock[] itb = new ItemBlock[tl.length];
		for (int i = 0; i < tl.length; i++) {
			GameRegistry.register(tl[i]);
			itb[i] = (ItemBlock) new ItemBlock(tl[i]).setRegistryName(tl[i].getRegistryName());
			GameRegistry.register(itb[i]);
		}
		itl = itb;
	}
}