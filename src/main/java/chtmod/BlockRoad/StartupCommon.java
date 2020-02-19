package chtmod.BlockRoad;

import com.jcraft.jorbis.Block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StartupCommon {
	public static Bitumen[] blocks = { new Bitumen("BlockBitumen", 0), new Bitumen("BlockBitumen1", 1),
			new Bitumen("BlockBitumen2", 2) };

	public static ItemBlock[] items = new ItemBlock[blocks.length];

	public static void preInitCommon() {
		for (int i = 0; i < blocks.length; i++) {
			GameRegistry.register(blocks[i]);
			ItemBlock ib = (ItemBlock) new ItemBlock(blocks[i]).setRegistryName(blocks[i].getRegistryName());
			items[i] = ib;
			GameRegistry.register(ib);
		}
	}
}