package chtmod.Sign;

import chtmod.RoadLines.Curved.TileEntityLineEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupCommon {
	public static String[] signs = { "Block", "Noenter", "Speed40", "Speed60", "Speed70", "Back", "Bike", "Bus",
			"Canteen", "Car", "Hotel", "Left", "Noback", "Nobike", "Nocar", "Noleft", "Nomoto", "Nopass", "Nopeople",
			"Noright", "Nostop", "Notice", "Notruk", "Npeople", "Nrail", "Nrough", "Oil", "Phone", "Rang", "Repair",
			"Right", "Stop", "Toleft", "Toright", "Wind", "Working", "Gostraight", "High4", "High8", "Nlcar",
			"Noovertacking", "Nosleft", "Nosright", "Nostraight", "Nrcar", "Overtacking", "Parking", "Sstraight",
			"Working2", "Working3", "Carl", "Carr", "Peoplel", "People", "Peopler", "Bikel", "Biker", "Goleft",
			"Goright", "Godouble", "Slrtl", "Slrtr", "Sbrtl", "Sbrtr", "Sisland" };

	public static ISign[] isign = new ISign[signs.length];
	public static Sign sp = new SignPlus("Plus");

	public static void preInitCommon() {
		GameRegistry.registerTileEntity(TileEntitySignEntity.class, "TileEntitySignEntity");
		for (int i = 0; i < signs.length; i++) {
			Sign s = new Sign(signs[i]);
			GameRegistry.register(s);
			isign[i] = new ISign(s);
			GameRegistry.register(isign[i]);
		}
		GameRegistry.register(sp);
	}
}