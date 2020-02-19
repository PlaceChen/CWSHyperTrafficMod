package chtmod.Pole;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
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

public class PoleRotation extends PoleBase {
	public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyInteger PROPERTYSTYLE = PropertyInteger.create("style", 0, 3);
	public int[] width;
	public int[] height;

	public PoleRotation(String arg0, int[] arg1, boolean arg2) {
		super(arg0);
		this.connectWith = arg2;
		width = arg1;
		int h[] = new int[8];
		for (int i = 0; i < 8; i++)
			if (i % 2 == 0)
				h[i] = 0;
			else
				h[i] = 16;
		height = h;
	}

	public PoleRotation(String arg0, int[] arg1, boolean arg2, int[] arg3) {
		this(arg0, arg1, arg2);
		height = arg3;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		int style = state.getValue(PROPERTYSTYLE) * 2;
		EnumFacing f = state.getValue(PROPERTYFACING);
		int x = width[style];
		int z = width[style + 1];
		float x1 = (8 - (x / 2)) / 16F;
		float x2 = (8 + (x / 2)) / 16F;
		float y1 = height[style] / 16F;
		float y2 = (height[style] + height[style + 1]) / 16F;
		switch (f) {
		case EAST:
			return new AxisAlignedBB((16 - z) / 16F, y1, x1, 1, y2, x2);
		case NORTH:
			return new AxisAlignedBB(x1, y1, 0, x2, y2, z / 16F);
		case SOUTH:
			return new AxisAlignedBB(x1, y1, (16 - z) / 16F, x2, y2, 1);
		case WEST:
			return new AxisAlignedBB(0, y1, x1, z / 16F, y2, x2);
		default:
			return FULL_BLOCK_AABB;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
		for (int i = 0; i < 4; i++)
			list.add(new ItemStack(itemIn, 1, i));
	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(PROPERTYSTYLE);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing facing = EnumFacing.getHorizontal(meta & 0x03);
		int style = meta >> 2;
		return this.getDefaultState().withProperty(PROPERTYSTYLE, style).withProperty(PROPERTYFACING, facing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		EnumFacing facing = (EnumFacing) state.getValue(PROPERTYFACING);
		int style = state.getValue(PROPERTYSTYLE) << 2;
		int facingbits = facing.getHorizontalIndex();
		return facingbits | style;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { PROPERTYFACING, PROPERTYSTYLE });
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		EnumFacing enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw);
		return this.getDefaultState().withProperty(PROPERTYFACING, enumfacing).withProperty(PROPERTYSTYLE, meta);
	}
}