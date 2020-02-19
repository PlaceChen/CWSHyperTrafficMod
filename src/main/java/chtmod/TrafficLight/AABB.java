package chtmod.TrafficLight;

import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class AABB {
	public static AxisAlignedBB setBound(IBlockState state, int style) {
		EnumFacing facing = state.getValue(TrafficLight.PROPERTYFACING);
		switch (style) {
		case 1:
			switch (facing) {
			case EAST:
				return new AxisAlignedBB(3 / 16F, 0, 0, 1, 1, 1);
			case WEST:
				return new AxisAlignedBB(0, 0, 0, 13 / 16F, 1, 1);
			case NORTH:
				return new AxisAlignedBB(0, 0, 0, 1, 1, 13 / 16F);
			case SOUTH:
				return new AxisAlignedBB(0, 0, 3 / 16F, 1, 1, 1);
			default:
				break;
			}
		case 2:
			switch (facing) {
			case EAST:
				return new AxisAlignedBB(0, 0, 2 / 16F, 1, 1, 14 / 16F);
			case WEST:
				return new AxisAlignedBB(0, 0, 2 / 16F, 1, 1, 14 / 16F);
			case NORTH:
				return new AxisAlignedBB(2 / 16F, 0, 0, 14 / 16F, 1, 1);
			case SOUTH:
				return new AxisAlignedBB(2 / 16F, 0, 0, 14 / 16F, 1, 1);
			default:
				break;
			}
		default:
			return Block.FULL_BLOCK_AABB;
		}
	}
}
