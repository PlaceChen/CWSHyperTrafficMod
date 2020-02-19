package chtmod.Pole;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StartupCommon {
	public static PoleRotation[] prt = { new PoleRotation("Fence", new int[] { 16, 2, 16, 2, 16, 2, 16, 5 }, true),
			new PoleRotation("Slope", new int[] { 4, 16, 4, 16, 4, 16, 4, 16 }, false),
			new PoleRotation("SlopeThin", new int[] { 2, 16, 2, 16, 16, 16, 16, 16 }, false),
			new PoleRotation("SlopeThinUpper", new int[] { 2, 16, 2, 16, 16, 16, 16, 16 }, false),
			new PoleRotation("Connector", new int[] { 4, 10, 4, 10, 16, 2, 16, 2 }, false,
					new int[] { 0, 16, 0, 16, 7, 2, 7, 2 }),
			new PoleRotation("Light", new int[] { 16, 16, 4, 10, 4, 10, 16, 16 }, true,
					new int[] { 7, 2, 0, 10, 6, 10, 7, 2 }) };
	public static IPole[] iprt = new IPole[prt.length];
	public static PoleCentre pc = new PoleCentre("Centre", new int[] { 16, 4, 16, 16, 16, 16, 4, 16, 4, 16 });
	public static IPole ipc = new IPole(pc);
	public static PoleBase[] blocks = { new PoleVertical("VerticalThick", 6, 16, 0),
			new PoleVertical("RoadFence1", 4, 16, 0), new PoleVertical("RoadFence2", 4, 16, 0),
			new PoleVertical("RoadFence3", 4, 16, 0), new PoleVertical("RoadFence4", 4, 16, 0),
			new PoleVertical("VerticalThin", 4, 16, 0), new PoleVertical("VerticalSlope", 6, 10, 0),
			new PoleVertical("VerticalCentre", 4, 4, 6), new PoleVertical("VerticalUpper", 4, 10, 6),
			new PoleVertical("VerticalLower", 4, 10, 0), new PoleHorizontal("HorizontalThin", 4, 4, 6),
			new PoleHorizontal("HorizontalDouble", 4, 16, 0), new PoleSide("SideThin", 4) };

	public static ItemBlock[] items = new ItemBlock[blocks.length];

	public static void preInitCommon() {
		for (int i = 0; i < blocks.length; i++) {
			GameRegistry.register(blocks[i]);
			ItemBlock ib = (ItemBlock) new ItemBlock(blocks[i]).setRegistryName(blocks[i].getRegistryName());
			GameRegistry.register(ib);
			items[i] = ib;
		}
		GameRegistry.register(pc);
		GameRegistry.register(ipc);
		for (int j = 0; j < prt.length; j++) {
			GameRegistry.register(prt[j]);
			IPole ip = new IPole(prt[j]);
			GameRegistry.register(ip);
			iprt[j] = ip;
		}
	}
}