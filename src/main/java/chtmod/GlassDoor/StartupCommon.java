package chtmod.GlassDoor;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StartupCommon {
	public static GlassDoor gd0 = new GlassDoor();
	public static ItemGlassDoor igd = new ItemGlassDoor();

	public static void preInitCommon() {
		GameRegistry.register(gd0);
		GameRegistry.register(igd);
	}
}