package com.tlf.camosuit.items;

import com.tlf.camosuit.common.CamoSuitMain;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;

public class ItemCamo extends Item
{	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	public static final String[] camoTypes = new String[] {"camo", "Jungle", "Desert", "Oak", "Stone", "Spruce"};
	public static final String[] textures = new String[] {"camo", "camo_jungle", "camo_desert", "camo_oak", "camo_stone", "camo_spruce"};

	public ItemCamo()
	{
		this.setHasSubtypes(true);
	}

	/**
	 * Gets an icon index based on an item's damage value
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIconFromDamage(int par1)
	{
		int j = MathHelper.clamp_int(par1, 0, textures.length);
		return this.icons[j];
	}

	/**
	 * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
	 * different names based on their damage or NBT.
	 */
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
		
		if (i == 0) {
			return super.getUnlocalizedName();
		} else {
			return super.getUnlocalizedName() + camoTypes[i];
		}
	}

	/**
	 * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item par1Item, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int j = 0; j < camoTypes.length; ++j)
		{
			par3List.add(new ItemStack(par1Item, 1, j));
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IIconRegister)
	{
		this.icons = new IIcon[textures.length];

		for (int i = 0; i < textures.length; ++i)
		{
			this.icons[i] = par1IIconRegister.registerIcon(CamoSuitMain.MODID + ":" + textures[i]);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (par1ItemStack.getItemDamage() == 5) {
			par3List.add(""+EnumChatFormatting.DARK_RED+EnumChatFormatting.ITALIC+"Warning: this camo type is");
			par3List.add(""+EnumChatFormatting.DARK_RED+EnumChatFormatting.ITALIC+"still in development, and");
			par3List.add(""+EnumChatFormatting.DARK_RED+EnumChatFormatting.ITALIC+"thus isn't colored properly yet");
		}
	}
}