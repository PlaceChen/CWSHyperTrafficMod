package chtmod.RoadLines;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupCommon {
	public static String[] blocks = { "White", "WhiteThick", "Yellow", "YellowThick", "YellowDouble",
			"InvaginateYellow", "InvaginateWhite", "InvaginateYellowThick", "InvaginateWhiteThick", "Straight", "Left",
			"Right", "Triangle", "WhiteSlope2", "YellowSlope2" };
	public static IRoadLine[] items = new IRoadLine[blocks.length];
	public static PutDottedLine pdl = new PutDottedLine();

	public static void preInitCommon() {
		GameRegistry.register(pdl);
		for (int i = 0; i < blocks.length; i++) {
			RoadLine rl = new RoadLine(blocks[i]);
			GameRegistry.register(rl);
			IRoadLine irl = new IRoadLine(rl);
			GameRegistry.register(irl);
			items[i] = irl;
		}
	}
}