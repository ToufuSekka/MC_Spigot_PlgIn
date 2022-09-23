package MCPlugIn119v.Items;

import java.util.*;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

/**
 * @serial 0
 * @since 2022-03-03 ~ 2022-03-26
 * @author ToufuSekka
 */
public class SpecialItems {
	private ItemStack Item;
	private ItemMeta ComMeta;

	/**
	 * @param material  Item Type
	 * @param Amounts   At least 1, Item Values
	 * @param ItemName  write CustomName, when you need
	 * @param LoreDatas
	 * @return Added Lore Item that you wanted
	 */
	public ItemStack LoredItem(Material material, int Amounts, String ItemName, String[] LoreDatas) {
		List<String> LoreData = new ArrayList<String>();
		Item = new ItemStack(material, Amounts);
		ComMeta = (ItemMeta) Item.getItemMeta();

		// Add CustomName when it exists
		if (!ItemName.isEmpty()) {
			ComMeta.setDisplayName(ItemName);
		}

		// Adding LoreData
		if (LoreDatas.length > 0) {
			for (String str : LoreDatas) {
				LoreData.add(str);
			}
			ComMeta.setLore(LoreData);
		}

		Item.setItemMeta(ComMeta);
		return Item;
	}
	
	/**
	 * @since 2022-03-26
	 * @param Amounts
	 * @param Power
	 * @param FireEffect
	 * @param ItemName
	 * @param LoreDatas
	 * @return
	 */
	public ItemStack Lored_Fire(int Amounts, int Power, FireworkEffect.Builder FireEffect, String ItemName, String[] LoreDatas) {
		List<String> LoreData = new ArrayList<String>();
		Item = new ItemStack(Material.FIREWORK_ROCKET, Amounts);
		FireworkMeta FireMeta = (FireworkMeta) Item.getItemMeta();
		
		FireMeta.setPower(Power);
		
		if(FireEffect != null) {
			FireMeta.addEffect(FireEffect.build());
		}
		
		// Add CustomName when it exists
		if (!ItemName.isEmpty()) {
			FireMeta.setDisplayName(ItemName);
		}

		// Adding LoreData
		if (LoreDatas.length > 0) {
			for (String str : LoreDatas) {
				LoreData.add(str);
			}
			FireMeta.setLore(LoreData);
		}

		Item.setItemMeta(FireMeta);
		return Item;
	}
	
	public ItemStack CustEnchant(Material material, String ItemName, Map<Enchantment,Integer> Encnants) {
		Item = new ItemStack(material);
		Item.addEnchantments(Encnants);
		
		return Item;
	}
}
