package com.tlf.camosuit.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.tlf.camosuit.items.Items;
import com.tlf.camosuit.proxy.ServerProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CamoSuitMain.MODID, name = CamoSuitMain.NAME, version = CamoSuitMain.VERSION)
public class CamoSuitMain
{	
	public static final String MODID = "camosuits";
	public static final String NAME = "Camo Suits";
	public static final String VERSION = "1.0.2";
	
	@Instance(CamoSuitMain.MODID)
	public static CamoSuitMain instance;
	
	@SidedProxy(clientSide = "com.tlf.camosuit.proxy.ClientProxy", serverSide = "com.tlf.camosuit.proxy.ServerProxy")
	public static ServerProxy proxy;
	
	public static ArmorMaterial camo;
	
	public static CreativeTabs camoTab = new CamoTab("camoTab");
	
	@EventHandler
	public void onPreInit(FMLPreInitializationEvent event)
	{
		camo = EnumHelper.addArmorMaterial("camo", 5, new int[] {1, 1, 1, 1}, 0);
		
		Items.init();
	}
	
	@EventHandler
	public void onInit(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
	}
	
	@EventHandler
	public void onPostInit(FMLPostInitializationEvent event)
	{
		System.out.println(NAME + " " + VERSION + " loaded!");
	}
}