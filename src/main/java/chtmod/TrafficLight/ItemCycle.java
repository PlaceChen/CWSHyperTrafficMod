package chtmod.TrafficLight;

import java.util.List;

import chtmod.Sign.GUISetSign;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

public class ItemCycle extends Item {

	public ItemCycle() {
		this.setMaxStackSize(1);
		this.setUnlocalizedName("ItemCycle");
		this.setRegistryName("ItemCycle");
		this.setCreativeTab(chtmod.CwsCreativeTabs.tlightTab);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		if (!worldIn.isRemote)
			Minecraft.getMinecraft().displayGuiScreen(new GUISetCycle(itemStackIn));
		return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
	}

	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (stack.hasTagCompound() && worldIn.getBlockState(pos).getBlock() instanceof TrafficLight) {
			try {
				TileEntityTrafficLightEntity tetle = (TileEntityTrafficLightEntity) worldIn.getTileEntity(pos);
				NBTTagCompound tag = stack.getTagCompound();
				tetle.times = tag.getIntArray("TIME");
				tetle.colors = tag.getIntArray("COLOR");
				tetle.maximumValue = tag.getInteger("MAX");
				tetle.start = true;
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			if (worldIn.isRemote)
				playerIn.addChatComponentMessage(new TextComponentString(I18n.format("gui.setsuccess", new Object[0])));
		}
		return EnumActionResult.SUCCESS;
	}
}