package Main.Store;

import java.util.*;

import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class Items {

	// base
	private ItemStack Item;
	private ItemMeta Meta;
	private List<String> Lore = new ArrayList<String>();

	// base Func
	public ItemStack LoredItem(Material ItemType, int Stacks, String ItemName, String[] LoreData) {
		this.Lore.clear();
		for (String str : LoreData)
			this.Lore.add(str);

		this.Item = new ItemStack(ItemType, Stacks);
		this.Meta = (ItemMeta) Item.getItemMeta();
		this.Meta.setDisplayName(ItemName);
		this.Meta.setLore(this.Lore);

		this.Item.setItemMeta(this.Meta);
		return this.Item;
	}

	public ItemStack PowerROCKET(int Power, int Stacks, FireworkEffect.Builder Effect, String ItemName,
			String[] LoreData) {
		this.Lore.clear();

		this.Item = new ItemStack(Material.FIREWORK_ROCKET, Stacks);
		FireworkMeta FWmeta = (FireworkMeta) Item.getItemMeta();
		FWmeta.setPower(Power);

		if (Effect != null)
			FWmeta.addEffect(Effect.build());

		if (ItemName != null)
			FWmeta.setDisplayName(ItemName);

		if (LoreData != null) {
			for (String str : LoreData)
				this.Lore.add(str);
			FWmeta.setLore(this.Lore);
		}

		this.Item.setItemMeta(FWmeta);
		return this.Item;
	}

	public ItemStack CustEnchItem(Material ItemType, Enchantment[] Enchan, int[] level) {
		this.Item = new ItemStack(ItemType);
		this.Meta = (ItemMeta) Item.getItemMeta();
		for (int i = 0; i < Enchan.length; i++) {
			this.Meta.addEnchant(Enchan[i], level[i], true);
		}
		this.Item.setItemMeta(this.Meta);
		return this.Item;
	}
	
	public ItemStack SpecItem(Material ItemType) {
		this.Item = new ItemStack(ItemType);
		this.Meta = (ItemMeta) Item.getItemMeta();
		
		this.Item.setItemMeta(this.Meta);
		return this.Item;
	}
}