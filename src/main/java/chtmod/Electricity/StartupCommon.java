package chtmod.Electricity;

import com.jcraft.jorbis.Block;

import chtmod.Electricity.Sign.ElectricitySign;
import chtmod.Electricity.Sign.TileEntityElectricitySignEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StartupCommon {
	public static TicketChecker tc = new TicketChecker();
	public static ItemBlock itc = (ItemBlock) new ItemBlock(tc).setRegistryName(tc.getRegistryName());
	public static TicketSeller tcs = new TicketSeller();
	public static ItemBlock itcs = (ItemBlock) new ItemBlock(tcs).setRegistryName(tcs.getRegistryName());
	public static ItemTicket ticket = new ItemTicket();
	public static ElectricityPole ep = new ElectricityPole();
	public static ItemBlock iep = (ItemBlock) new ItemBlock(ep).setRegistryName(ep.getRegistryName());
	public static Insulator ib = new Insulator("InsulatorBase");
	public static ItemInsulator iib = new ItemInsulator(ib);
	public static Pole elp = new Pole();
	public static ItemInsulator ielp = new ItemInsulator(elp);
	public static ElectricityPoleHorizontal eph = new ElectricityPoleHorizontal();
	public static ItemBlock ieph = (ItemBlock) new ItemBlock(eph).setRegistryName(eph.getRegistryName());
	public static ElectricitySign es = new ElectricitySign();
	public static Transformer trans = new Transformer();
	public static Switch sw = new Switch();
	public static Switch osw = new Switch("OldSwitch");
	public static Box box = new Box();
	public static ItemBlock ibox = (ItemBlock) new ItemBlock(box).setRegistryName(box.getRegistryName());
	public static ItemBlock itrans = (ItemBlock) new ItemBlock(trans).setRegistryName(trans.getRegistryName());
	public static ItemBlock isw = (ItemBlock) new ItemBlock(sw).setRegistryName(sw.getRegistryName());
	public static ItemBlock iosw = (ItemBlock) new ItemBlock(osw).setRegistryName(osw.getRegistryName());

	public static void preInitCommon() {
		GameRegistry.registerTileEntity(TileEntityElectricitySignEntity.class, "TileEntityElectricitySignEntity");
		GameRegistry.register(es);
		GameRegistry.register(ticket);
		GameRegistry.register(tc);
		GameRegistry.register(itc);
		GameRegistry.register(tcs);
		GameRegistry.register(itcs);
		GameRegistry.register(ep);
		GameRegistry.register(iep);
		GameRegistry.register(ib);
		GameRegistry.register(iib);
		GameRegistry.register(eph);
		GameRegistry.register(ieph);
		GameRegistry.register(elp);
		GameRegistry.register(ielp);
		GameRegistry.register(trans);
		GameRegistry.register(itrans);
		GameRegistry.register(sw);
		GameRegistry.register(isw);
		GameRegistry.register(osw);
		GameRegistry.register(iosw);
		GameRegistry.register(box);
		GameRegistry.register(ibox);
	}
}