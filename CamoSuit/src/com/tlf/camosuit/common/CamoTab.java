package com.tlf.camosuit.common;

import com.tlf.camosuit.items.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CamoTab extends CreativeTabs
{
	public CamoTab(String par2Str) {
		super(par2Str);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Items.jungleHead;
	}
}