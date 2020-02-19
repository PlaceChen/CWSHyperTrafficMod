package chtmod.BlockRoad.Slope;

import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupCommon {
	public static ItemSlopeBitumen isb = new ItemSlopeBitumen();
	public static SlopeBitumen[] sbv2 = { new SlopeBitumen(0), new SlopeBitumen(1), new SlopeBitumen(2),
			new SlopeBitumen(3), new SlopeBitumen(4) };

	public static void preInitCommon() {
		GameRegistry.register(isb);
		for (SlopeBitumen s2 : sbv2)
			GameRegistry.register(s2);
	}
}