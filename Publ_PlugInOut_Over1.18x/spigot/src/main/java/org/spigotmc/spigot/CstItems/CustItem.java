package org.spigotmc.spigot.CstItems;

import java.util.*;

import org.bukkit.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

/**
 * @author ToufuSekka
 * @since 2021.12.21
 */
public class CustItem {
	private ItemStack Item;
	private ItemMeta ComMeta;
	
	private List<String> LoreData = new ArrayList<String>();
	
	public ItemStack LoredItem(Material material, String ItemName, String[] LoreDatas) {
		this.LoreData.clear();
		this.Item = new ItemStack(material);
		this.ComMeta = (ItemMeta) Item.getItemMeta();
		
		if(ItemName.length() > 1) {
			this.ComMeta.setDisplayName(ItemName);
		}
		
		if(LoreDatas.length > 1) {
			for(String str : LoreDatas) {
				this.LoreData.add(str);
			}
			this.ComMeta.setLore(this.LoreData);
		}
		
		this.Item.setItemMeta(this.ComMeta);
		return this.Item;
	}
	
	public ItemStack CustEnchanted(Material ItemType, Enchantment[] Enchan, int[] level) {
		if(Enchan.length != level.length)
			throw new IllegalArgumentException("인첸수와 레벨의 수가 일치하지 않음");
		
		this.Item = new ItemStack(ItemType);
		this.ComMeta = (ItemMeta) this.Item.getItemMeta();
		
		for (int i = 0; i < Enchan.length; i++) {
			this.ComMeta.addEnchant(Enchan[i], level[i], true);
		}
		
		this.Item.setItemMeta(this.ComMeta);
		
		return this.Item;
	}
	
	public ItemStack PoweredRocket(int Power, int Stacks, FireworkEffect.Builder Effect, String ItemName,
			String[] LoreData) {
		this.LoreData.clear();

		this.Item = new ItemStack(Material.FIREWORK_ROCKET, Stacks);
		FireworkMeta FWmeta = (FireworkMeta) this.Item.getItemMeta();
		
		if (Effect != null)
			FWmeta.addEffect(Effect.build());

		if (ItemName != null)
			FWmeta.setDisplayName(ItemName);

		if (LoreData != null) {
			for (String str : LoreData)
				this.LoreData.add(str);
			FWmeta.setLore(this.LoreData);
		}
		
		return this.Item;
	}
}
