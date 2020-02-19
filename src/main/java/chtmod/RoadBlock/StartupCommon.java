package chtmod.RoadBlock;

import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupCommon {
	public static RoadBlock[] blocks = new RoadBlock[] {
			new RoadBlock("RoadBlock", new AxisAlignedBB(6 / 16f, 0, 6 / 16f, 10 / 16f, 1, 10 / 16f)),
			new RoadBlock("RoadBlock2", new AxisAlignedBB(4 / 16f, 0, 4 / 16f, 12 / 16f, 1, 12 / 16f)),
			new RoadBlock("RoadBlock3", new AxisAlignedBB(2 / 16f, 0, 2 / 16f, 14 / 16f, 1, 14 / 16f)),
			new RoadBlock("RoadBlockYellow", new AxisAlignedBB(0, 0, 0, 1, 1 / 16f, 1)),
			new RoadBlock("RoadBlockWhite", new AxisAlignedBB(0, 0, 0, 1, 1 / 16f, 1)),
			new RoadBlock("LightBottom", new AxisAlignedBB(0, 0, 0, 1, 1, 1)),
			new RoadBlock("BlockNotice", new AxisAlignedBB(0.125f, 0, 0.125f, 0.875f, 1, 0.875f)) };
	public static ItemBlock[] items = new ItemBlock[7];

	public static void preInitCommon() {
		for (int i = 0; i < blocks.length; i++) {
			GameRegistry.register(blocks[i]);
			ItemBlock ib = (ItemBlock) new ItemBlock(blocks[i]).setRegistryName(blocks[i].getRegistryName());
			items[i] = ib;
			GameRegistry.register(ib);
		}
	}

}
