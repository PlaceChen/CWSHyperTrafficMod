package chtmod.RoadBlock;

import net.minecraft.block.Block;
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
			new RoadBlock("BlockNotice", Block.FULL_BLOCK_AABB), new RoadBlock("Block45Pole", Block.FULL_BLOCK_AABB) };
	public static ItemBlock[] items = new ItemBlock[blocks.length];
	public static BlockNotice2 bn2 = new BlockNotice2();
	public static ItemBlock ibn2 = (ItemBlock) new ItemBlock(bn2).setRegistryName(bn2.getRegistryName());

	public static void preInitCommon() {
		for (int i = 0; i < blocks.length; i++) {
			GameRegistry.register(blocks[i]);
			ItemBlock ib = (ItemBlock) new ItemBlock(blocks[i]).setRegistryName(blocks[i].getRegistryName());
			items[i] = ib;
			GameRegistry.register(ib);
		}
		GameRegistry.register(bn2);
		GameRegistry.register(ibn2);
	}

}
