package org.spigotmc.spigot.CstItems;

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
}
