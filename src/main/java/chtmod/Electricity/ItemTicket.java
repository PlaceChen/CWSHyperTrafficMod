package chtmod.Electricity;

import net.minecraft.item.Item;

public class ItemTicket extends Item {
	public ItemTicket() {
		this.setMaxStackSize(1);
		this.setCreativeTab(chtmod.CwsCreativeTabs.sbTab);
		this.setRegistryName("Ticket");
		this.setUnlocalizedName("Ticket");
	}

}
