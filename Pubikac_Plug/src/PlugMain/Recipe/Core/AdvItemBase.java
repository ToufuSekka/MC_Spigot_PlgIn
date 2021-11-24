package PlugMain.Recipe.Core;

import java.util.*;

import org.bukkit.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class AdvItemBase {
	ItemStack Item;
	ItemMeta ComMeta;
	List<String> LoreData = new ArrayList<String>();
	
	public ItemStack LoredItem(Material material,String ItemName, String[] LoreDatas) {
		LoreData.clear();
		Item = new ItemStack(material);
		
		ComMeta = (ItemMeta) Item.getItemMeta();
		
		if(ItemName.length() > 1) {
			ComMeta.setDisplayName(ItemName);
		}
		
		if(LoreDatas.length > 1) {
			for(String str : LoreDatas) {
				LoreData.add(str);
			}
			ComMeta.setLore(LoreData);
		}
		
		Item.setItemMeta(ComMeta);
		return Item;
	}
	
	public ItemStack CustEnchItem(Material ItemType, Enchantment[] Enchan, int[] level) {
		this.Item = new ItemStack(ItemType);
		this.ComMeta = (ItemMeta) Item.getItemMeta();
		for (int i = 0; i < Enchan.length; i++) {
			this.ComMeta.addEnchant(Enchan[i], level[i], true);
		}
		this.Item.setItemMeta(this.ComMeta);
		return this.Item;
	}
}
