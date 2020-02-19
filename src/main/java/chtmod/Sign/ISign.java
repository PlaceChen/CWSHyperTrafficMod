package chtmod.Sign;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ISign extends ItemBlock {
	public ISign(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setRegistryName(block.getRegistryName());
	}

	@Override
	public int getMetadata(int metadata) {
		return metadata;
	}
}
