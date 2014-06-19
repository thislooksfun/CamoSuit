package com.tlf.camosuit.items;

import com.tlf.camosuit.common.CamoSuitMain;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCamoArmorFixed extends ItemArmor
{
	protected String camoMaterial;
	
	public ItemCamoArmorFixed(ArmorMaterial armorMaterial, int renderIndex, int armorType, String camoMaterial)
	{
		super(armorMaterial, renderIndex, armorType);
		this.camoMaterial = camoMaterial;
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		switch (this.armorType)
		{
		case 0:
		case 1:
		case 3:
			return CamoSuitMain.MODID + ":textures/armor/" + this.camoMaterial + "Camo_1.png";		
		case 2:
			return CamoSuitMain.MODID + ":textures/armor/" + this.camoMaterial + "Camo_2.png";
		}
		
		return null;
	}
	
	private String getArmorType()
	{
		switch (this.armorType)
		{
		case 0: return "Head";
		case 1: return "Chest";
		case 2: return "Pants";
		case 3: return "Boots";
		default: return null;
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(CamoSuitMain.MODID + ":" + this.camoMaterial + "Camo" + this.getArmorType());
	}
}
