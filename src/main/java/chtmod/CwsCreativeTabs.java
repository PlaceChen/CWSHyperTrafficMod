package chtmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CwsCreativeTabs {
	public static CreativeTabs lineTab = new CreativeTabs("cws_ltabv3") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getByNameOrId("chtmod:SignNoenter");
		}
	};
	public static CreativeTabs blockTab = new CreativeTabs("cws_btabv3") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getByNameOrId("chtmod:BlockBitumen");
		}
	};

	public static CreativeTabs tlightTab = new CreativeTabs("cws_tltabv3") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getByNameOrId("chtmod:TrafficLightCircle");
		}
	};

	public static CreativeTabs toolTab = new CreativeTabs("cws_ttabv3") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getByNameOrId("chtmod:WTCur");
		}
	};
	public static CreativeTabs sbTab = new CreativeTabs("cws_sbtabv3") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getByNameOrId("chtmod:SoundBlock");
		}
	};
}
