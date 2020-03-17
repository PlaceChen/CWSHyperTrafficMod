package chtmod.Pole;

import chtmod.RoadLight.Light;
import chtmod.Sign.Sign;
import chtmod.TrafficLight.TrafficLight;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PoleBase extends Block {
	protected boolean connectWith;

	public PoleBase(String arg0) {
		super(Material.ROCK, MapColor.IRON);
		this.setCreativeTab(chtmod.CwsCreativeTabs.blockTab);
		this.setRegistryName("Pole" + arg0);
		this.setUnlocalizedName("Pole" + arg0);
		this.setHardness(2);
		this.connectWith = true;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean isOpaqueCube(IBlockState iBlockState) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState iBlockState) {
		return false;
	}

	@Override
	public boolean isFullBlock(IBlockState iBlockState) {
		return false;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
		return EnumBlockRenderType.MODEL;
	}

	protected boolean isValidBlock(IBlockAccess access, BlockPos pos) {
		Block b = access.getBlockState(pos).getBlock();
		if (b instanceof PoleBase) {
			if (b instanceof PoleRotation && b.getUnlocalizedName().endsWith("Light")) {
				int s = access.getBlockState(pos).getValue(PoleRotation.PROPERTYSTYLE);
				return s == 1 || s == 2;
			} else {
				return ((PoleBase) b).connectWith;
			}
		} else if (b instanceof BlockFence || b instanceof Sign)
			return true;
		else if (b instanceof Light) {
			Light l = (Light) b;
			return l.connectedPole;
		} else
			return false;
	}
}
