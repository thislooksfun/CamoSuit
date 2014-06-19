package com.tlf.camosuit.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.tlf.camosuit.common.CamoSuitMain;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCamoArmorDynamic extends ItemArmor
{
	public ItemCamoArmorDynamic(ArmorMaterial armorMaterial, int renderIndex, int armorType)
	{
		super(armorMaterial, renderIndex, armorType);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		switch (this.armorType)
		{
		case 0:
		case 1:
		case 3:
			//return CamoSuitMain.MODID + ":textures/armor/" + this.camoMaterial + "Camo_1.png";		
		case 2:
			//return CamoSuitMain.MODID + ":textures/armor/" + this.camoMaterial + "Camo_2.png";
		}
		
		int x = (int)(entity.posX < 0 ? (Math.ceil(entity.posX)) : (Math.floor(entity.posX)));
		int y = (int)(entity.posY < 0 ? (Math.ceil(entity.posY)) : (Math.floor(entity.posY)));
		int z = (int)(entity.posZ < 0 ? (Math.ceil(entity.posZ)) : (Math.floor(entity.posZ)));
		y -= 2;
		
		Block block = entity.worldObj.getBlock(x, y, z);
		IIcon texture = block.getIcon(0, entity.worldObj.getBlockMetadata(x, y, z));
		if (block.isNormalCube() && !block.getUnlocalizedName().equalsIgnoreCase("tile.air")) {
			
			String textureName = texture.getIconName();
			
			int colonIndex = textureName.indexOf(":");
			String modID = colonIndex > -1 ? textureName.substring(0, colonIndex+1) : "";
			String texurePath = colonIndex > -1 ? textureName.substring(colonIndex+1) : textureName;
			System.out.println(modID + "textures/items/block/" + texurePath + ".png");
			return modID + "textures/items/block/" + texurePath + ".png";
		}
		
		return "textures/models/armor/gold_layer_1.png";
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
		this.itemIcon = iconRegister.registerIcon(CamoSuitMain.MODID + ":dynamicCamo" + this.getArmorType());
	}
}
