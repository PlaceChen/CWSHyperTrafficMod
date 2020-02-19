package chtmod.Tools;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class StartupClientOnly {
	public static void preInitClientOnly() {
		ModelLoader.setCustomModelResourceLocation(StartupCommon.ir, 0,
				new ModelResourceLocation("chtmod:tools/BlockRuler", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.is, 0,
				new ModelResourceLocation("chtmod:tools/BlockRuler", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.is2, 0,
				new ModelResourceLocation("chtmod:tools/BlockRuler", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.ppolek5, 0,
				new ModelResourceLocation("chtmod:tools/PoleThick5", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.ppolek10, 0,
				new ModelResourceLocation("chtmod:tools/PoleThick10", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.ppolen5, 0,
				new ModelResourceLocation("chtmod:tools/PoleThin5", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.rpb, 0,
				new ModelResourceLocation("chtmod:tools/RepeatBlock", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.bs, 0,
				new ModelResourceLocation("chtmod:tools/BStation0", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.bs, 1,
				new ModelResourceLocation("chtmod:tools/BStation1", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.bs, 2,
				new ModelResourceLocation("chtmod:tools/BStation2", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.br, 0,
				new ModelResourceLocation("chtmod:tools/BuildRoad3", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.br, 1,
				new ModelResourceLocation("chtmod:tools/BuildRoad5", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.br, 2,
				new ModelResourceLocation("chtmod:tools/BuildRoad7", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.psl1, 0,
				new ModelResourceLocation("chtmod:tools/PutStone10", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.st, 0,
				new ModelResourceLocation("chtmod:tools/SubwayTurn", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.st, 1,
				new ModelResourceLocation("chtmod:tools/SubwayTurn", "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.ss, 0,
				new ModelResourceLocation("chtmod:tools/StairSpace", "inventory"));
		for (int i = 0; i < 12; i++)
			ModelLoader.setCustomModelResourceLocation(StartupCommon.pl, i,
					new ModelResourceLocation("chtmod:tools/PutLight" + i, "inventory"));
		ModelLoader.setCustomModelResourceLocation(StartupCommon.pc, 0,
				new ModelResourceLocation("chtmod:tools/PutCurved", "inventory"));
	}
}
