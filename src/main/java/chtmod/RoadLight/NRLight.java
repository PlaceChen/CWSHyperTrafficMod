package chtmod.RoadLight;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NRLight extends Light {
	public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing",
			EnumFacing.Plane.HORIZONTAL);
	private int style;

	public NRLight(String arg0, int arg1) {
		super(arg0);
		style = arg1;
	}

	public NRLight(String arg0, int arg1, boolean arg2) {
		this(arg0, arg1);
		this.connectedPole = arg2;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
		return EnumBlockRenderType.MODEL;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing facing = state.getValue(PROPERTYFACING);
		AxisAlignedBB ns = new AxisAlignedBB(3 / 16F, 5 / 16F, 0, 13 / 16F, 11 / 16F, 1);
		AxisAlignedBB we = new AxisAlignedBB(0, 5 / 16F, 3 / 16F, 1, 11 / 16F, 13 / 16F);
		switch (style) {
		case 1:
			switch (facing) {
			case EAST:
				return we;
			case NORTH:
				return ns;
			case SOUTH:
				return ns;
			case WEST:
				return we;
			default:
				break;
			}
		case 2:
			float y1 = 4 / 16F;
			float y2 = 12 / 16F;
			AxisAlignedBB normal = new AxisAlignedBB(0, y1, 0, 1, y2, 1);
			AxisAlignedBB n = new AxisAlignedBB(0, y1, -7 / 16F, 1, y2, 0);
			AxisAlignedBB s = new AxisAlignedBB(0, y1, 1, 1, y2, 23 / 16F);
			AxisAlignedBB w = new AxisAlignedBB(-7 / 16F, y1, 0, 0, y2, 1);
			AxisAlignedBB e = new AxisAlignedBB(1, y1, 0, 23 / 16F, y2, 1);
			switch (state.getValue(PROPERTYFACING)) {
			case EAST:
				return normal.union(w);
			case NORTH:
				return normal.union(s);
			case SOUTH:
				return normal.union(n);
			case WEST:
				return normal.union(e);
			default:
				break;
			}
		default:
			return FULL_BLOCK_AABB;
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing facing = EnumFacing.getHorizontal(meta);
		int colourbits = (meta & 0x0c) >> 2;
		return this.getDefaultState().withProperty(PROPERTYFACING, facing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		EnumFacing facing = (EnumFacing) state.getValue(PROPERTYFACING);
		int facingbits = facing.getHorizontalIndex();
		return facingbits;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { PROPERTYFACING });
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		EnumFacing enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw);
		return this.getDefaultState().withProperty(PROPERTYFACING, enumfacing);
	}
}