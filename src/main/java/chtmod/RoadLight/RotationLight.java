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

public class RotationLight extends Light {
	public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing",
			EnumFacing.Plane.HORIZONTAL);

	public RotationLight(String arg0, int arg1) {
		super(arg0, arg1);
	}

	public RotationLight(String arg0, int arg1, boolean arg2) {
		super(arg0, arg1, arg2);
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
		return EnumBlockRenderType.MODEL;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.SOLID;
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
			return chtmod.AABB.RotationBox(facing, 16, 28, 6, 7);
		case 3:
			return chtmod.AABB.RotationBox(facing, 12, 32, 5, 5);
		case 4:
			return chtmod.AABB.RotationBox(facing, 16, 48, -7, 71);
		case 5:
			return new AxisAlignedBB(0, 4 / 16f, 0, 1, 11 / 16f, 1);
		}
		return FULL_BLOCK_AABB;
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