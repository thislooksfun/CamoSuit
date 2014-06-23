package com.tlf.camosuit.items;

import com.tlf.camosuit.common.CamoSuitMain;
import com.tlf.camosuit.proxy.ServerProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

import cpw.mods.fml.common.registry.GameRegistry;

public class Items
{
	private static ServerProxy proxy;
	private static ArmorMaterial camo;
	private static CreativeTabs camoTab;
	
	public static Item camoItem;
	
	/*
	public static Item dynamicHead;
	public static Item dynamicChest;
	public static Item dynamicLegs;
	public static Item dynamicBoots;
	*/
	
	public static Item jungleHead;
	public static Item jungleChest;
	public static Item jungleLegs;
	public static Item jungleBoots;
	
	public static Item desertHead;
	public static Item desertChest;
	public static Item desertLegs;
	public static Item desertBoots;
	
	public static Item oakHead;
	public static Item oakChest;
	public static Item oakLegs;
	public static Item oakBoots;
	
	public static Item stoneHead;
	public static Item stoneChest;
	public static Item stoneLegs;
	public static Item stoneBoots;
	
	public static Item spruceHead;
	public static Item spruceChest;
	public static Item spruceLegs;
	public static Item spruceBoots;
	
	public static void init()
	{
		proxy = CamoSuitMain.proxy;
		camo = CamoSuitMain.camo;
		camoTab = CamoSuitMain.camoTab;
		
		initArmor();
		initItems();
		initRecipies();
		registerItems();
	}
	
	private static void initArmor()
	{
		/*
		dynamicHead = new ItemCamoArmorDynamic(camo, proxy.addArmor("dynamicCamo"), 0).setUnlocalizedName("dynamicHead").setCreativeTab(camoTab);
		dynamicChest = new ItemCamoArmorDynamic(camo, proxy.addArmor("dynamicCamo"), 1).setUnlocalizedName("dynamicChest").setCreativeTab(camoTab);
		dynamicLegs = new ItemCamoArmorDynamic(camo, proxy.addArmor("dynamicCamo"), 2).setUnlocalizedName("dynamicLegs").setCreativeTab(camoTab);
		dynamicBoots = new ItemCamoArmorDynamic(camo, proxy.addArmor("dynamicCamo"), 3).setUnlocalizedName("dynamicBoots").setCreativeTab(camoTab);
		*/
		
		jungleHead = new ItemCamoArmorFixed(camo, proxy.addArmor("jungleCamo"), 0, "Jungle").setUnlocalizedName("jungleHead").setCreativeTab(camoTab);
		jungleChest = new ItemCamoArmorFixed(camo, proxy.addArmor("jungleCamo"), 1, "Jungle").setUnlocalizedName("jungleChest").setCreativeTab(camoTab);
		jungleLegs = new ItemCamoArmorFixed(camo, proxy.addArmor("jungleCamo"), 2, "Jungle").setUnlocalizedName("jungleLegs").setCreativeTab(camoTab);
		jungleBoots = new ItemCamoArmorFixed(camo, proxy.addArmor("jungleCamo"), 3, "Jungle").setUnlocalizedName("jungleBoots").setCreativeTab(camoTab);
		
		desertHead = new ItemCamoArmorFixed(camo, proxy.addArmor("desertCamo"), 0, "Desert").setUnlocalizedName("desertHead").setCreativeTab(camoTab);
		desertChest = new ItemCamoArmorFixed(camo, proxy.addArmor("desertCamo"), 1, "Desert").setUnlocalizedName("desertChest").setCreativeTab(camoTab);
		desertLegs = new ItemCamoArmorFixed(camo, proxy.addArmor("desertCamo"), 2, "Desert").setUnlocalizedName("desertLegs").setCreativeTab(camoTab);
		desertBoots = new ItemCamoArmorFixed(camo, proxy.addArmor("desertCamo"), 3, "Desert").setUnlocalizedName("desertBoots").setCreativeTab(camoTab);
		
		oakHead = new ItemCamoArmorFixed(camo, proxy.addArmor("oakCamo"), 0, "Oak").setUnlocalizedName("oakHead").setCreativeTab(camoTab);
		oakChest = new ItemCamoArmorFixed(camo, proxy.addArmor("oakCamo"), 1, "Oak").setUnlocalizedName("oakChest").setCreativeTab(camoTab);
		oakLegs = new ItemCamoArmorFixed(camo, proxy.addArmor("oakCamo"), 2, "Oak").setUnlocalizedName("oakLegs").setCreativeTab(camoTab);
		oakBoots = new ItemCamoArmorFixed(camo, proxy.addArmor("oakCamo"), 3, "Oak").setUnlocalizedName("oakBoots").setCreativeTab(camoTab);
		
		stoneHead = new ItemCamoArmorFixed(camo, proxy.addArmor("stoneCamo"), 0, "Stone").setUnlocalizedName("stoneHead").setCreativeTab(camoTab);
		stoneChest = new ItemCamoArmorFixed(camo, proxy.addArmor("stoneCamo"), 1, "Stone").setUnlocalizedName("stoneChest").setCreativeTab(camoTab);
		stoneLegs = new ItemCamoArmorFixed(camo, proxy.addArmor("stoneCamo"), 2, "Stone").setUnlocalizedName("stoneLegs").setCreativeTab(camoTab);
		stoneBoots = new ItemCamoArmorFixed(camo, proxy.addArmor("stoneCamo"), 3, "Stone").setUnlocalizedName("stoneBoots").setCreativeTab(camoTab);
		
		spruceHead = new ItemCamoArmorFixed(camo, proxy.addArmor("spruceCamo"), 0, "Spruce").setUnlocalizedName("spruceHead").setCreativeTab(camoTab);
		spruceChest = new ItemCamoArmorFixed(camo, proxy.addArmor("spruceCamo"), 1, "Spruce").setUnlocalizedName("spruceChest").setCreativeTab(camoTab);
		spruceLegs = new ItemCamoArmorFixed(camo, proxy.addArmor("spruceCamo"), 2, "Spruce").setUnlocalizedName("spruceLegs").setCreativeTab(camoTab);
		spruceBoots = new ItemCamoArmorFixed(camo, proxy.addArmor("spruceCamo"), 3, "Spruce").setUnlocalizedName("spruceBoots").setCreativeTab(camoTab);
	}
	
	private static void registerItems()
	{
		System.out.println("registering items");
		
		/*
		GameRegistry.registerItem(dynamicHead, "dynamicHead");
		GameRegistry.registerItem(dynamicChest, "dynamicChest");
		GameRegistry.registerItem(dynamicLegs, "dynamicLegs");
		GameRegistry.registerItem(dynamicBoots, "dynamicBoots");
		*/
		
		GameRegistry.registerItem(jungleHead, "jungleHead");
		GameRegistry.registerItem(jungleChest, "jungleChest");
		GameRegistry.registerItem(jungleLegs, "jungleLegs");
		GameRegistry.registerItem(jungleBoots, "jungleBoots");
		
		GameRegistry.registerItem(desertHead, "desertHead");
		GameRegistry.registerItem(desertChest, "desertChest");
		GameRegistry.registerItem(desertLegs, "desertLegs");
		GameRegistry.registerItem(desertBoots, "desertBoots");
		
		GameRegistry.registerItem(oakHead, "oakHead");
		GameRegistry.registerItem(oakChest, "oakChest");
		GameRegistry.registerItem(oakLegs, "oakLegs");
		GameRegistry.registerItem(oakBoots, "oakBoots");
		
		GameRegistry.registerItem(stoneHead, "stoneHead");
		GameRegistry.registerItem(stoneChest, "stoneChest");
		GameRegistry.registerItem(stoneLegs, "stoneLegs");
		GameRegistry.registerItem(stoneBoots, "stoneBoots");
		
		GameRegistry.registerItem(spruceHead, "spruceHead");
		GameRegistry.registerItem(spruceChest, "spruceChest");
		GameRegistry.registerItem(spruceLegs, "spruceLegs");
		GameRegistry.registerItem(spruceBoots, "spruceBoots");
		
		GameRegistry.registerItem(camoItem, "camoItem");
	}
	
	private static void initItems()
	{
		camoItem = new ItemCamo().setUnlocalizedName("camo").setCreativeTab(camoTab);
	}
	
	private static void initRecipies()
	{
		/* Main camo item */
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(camoItem, 4, 0), new Object[] {
			"ll", "ll", 'l', "treeLeaves",
		}));
		
		
		
		
		/* Specific camo items */
		GameRegistry.addRecipe(new ItemStack(camoItem, 4, 1), new Object[] {
			" c ", "cjc", " c ", 'c', new ItemStack(camoItem, 1, 0), 'j', new ItemStack(Blocks.leaves, 1, 3)
		});
		GameRegistry.addRecipe(new ItemStack(camoItem, 4, 2), new Object[] {
			" c ", "csc", " c ", 'c', new ItemStack(camoItem, 1, 0), 's', Blocks.sand
		});
		GameRegistry.addRecipe(new ItemStack(camoItem, 4, 3), new Object[] {
			" c ", "coc", " c ", 'c', new ItemStack(camoItem, 1, 0), 'o', new ItemStack(Blocks.leaves, 1, 0)
		});
		GameRegistry.addRecipe(new ItemStack(camoItem, 4, 4), new Object[] {
			" c ", "csc", " c ", 'c', new ItemStack(camoItem, 1, 0), 's', Blocks.stone
		});
		GameRegistry.addRecipe(new ItemStack(camoItem, 4, 5), new Object[] {
			" c ", "csc", " c ", 'c', new ItemStack(camoItem, 1, 0), 's', new ItemStack(Blocks.leaves, 1, 1)
		});
		
		
		
		
		/* Camo suits */
		//Jungle set
		GameRegistry.addRecipe(new ItemStack(jungleHead, 1), new Object[] {
			"jjj", "j j", 'j', new ItemStack(camoItem, 1, 1)
		});
		GameRegistry.addRecipe(new ItemStack(jungleChest, 1), new Object[] {
			"j j", "jjj", "jjj", 'j', new ItemStack(camoItem, 1, 1)
		});
		GameRegistry.addRecipe(new ItemStack(jungleLegs, 1), new Object[] {
			"jjj", "j j", "j j", 'j', new ItemStack(camoItem, 1, 1)
		});
		GameRegistry.addRecipe(new ItemStack(jungleBoots, 1), new Object[] {
			"j j", "j j", 'j', new ItemStack(camoItem, 1, 1)
		});
		
		
		//Desert set
		GameRegistry.addRecipe(new ItemStack(desertHead, 1), new Object[] {
			"ddd", "d d", 'd', new ItemStack(camoItem, 1, 2)
		});
		GameRegistry.addRecipe(new ItemStack(desertChest, 1), new Object[] {
			"d d", "ddd", "ddd", 'd', new ItemStack(camoItem, 1, 2)
		});
		GameRegistry.addRecipe(new ItemStack(desertLegs, 1), new Object[] {
			"ddd", "d d", "d d", 'd', new ItemStack(camoItem, 1, 2)
		});
		GameRegistry.addRecipe(new ItemStack(desertBoots, 1), new Object[] {
			"d d", "d d", 'd', new ItemStack(camoItem, 1, 2)
		});
		
		
		//Oak set
		GameRegistry.addRecipe(new ItemStack(oakHead, 1), new Object[] {
			"ooo", "o o", 'o', new ItemStack(camoItem, 1, 3)
		});
		GameRegistry.addRecipe(new ItemStack(oakChest, 1), new Object[] {
			"o o", "ooo", "ooo", 'o', new ItemStack(camoItem, 1, 3)
		});
		GameRegistry.addRecipe(new ItemStack(oakLegs, 1), new Object[] {
			"ooo", "o o", "o o", 'o', new ItemStack(camoItem, 1, 3)
		});
		GameRegistry.addRecipe(new ItemStack(oakBoots, 1), new Object[] {
			"o o", "o o", 'o', new ItemStack(camoItem, 1, 3)
		});
		
		
		//Stone set
		GameRegistry.addRecipe(new ItemStack(stoneHead, 1), new Object[] {
			"sss", "s s", 's', new ItemStack(camoItem, 1, 4)
		});
		GameRegistry.addRecipe(new ItemStack(stoneChest, 1), new Object[] {
			"s s", "sss", "sss", 's', new ItemStack(camoItem, 1, 4)
		});
		GameRegistry.addRecipe(new ItemStack(stoneLegs, 1), new Object[] {
			"sss", "s s", "s s", 's', new ItemStack(camoItem, 1, 4)
		});
		GameRegistry.addRecipe(new ItemStack(stoneBoots, 1), new Object[] {
			"s s", "s s", 's', new ItemStack(camoItem, 1, 4)
		});
		
		
		//Spruce set
		GameRegistry.addRecipe(new ItemStack(spruceHead, 1), new Object[] {
			"sss", "s s", 's', new ItemStack(camoItem, 1, 5)
		});
		GameRegistry.addRecipe(new ItemStack(spruceChest, 1), new Object[] {
			"s s", "sss", "sss", 's', new ItemStack(camoItem, 1, 5)
		});
		GameRegistry.addRecipe(new ItemStack(spruceLegs, 1), new Object[] {
			"sss", "s s", "s s", 's', new ItemStack(camoItem, 1, 5)
		});
		GameRegistry.addRecipe(new ItemStack(spruceBoots, 1), new Object[] {
			"s s", "s s", 's', new ItemStack(camoItem, 1, 5)
		});
	}
}