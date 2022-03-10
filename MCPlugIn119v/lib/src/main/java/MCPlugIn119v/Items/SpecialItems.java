package MCPlugIn119v.Items;

import java.util.*;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

/**
 * @serial 0
 * @since 2022-03-03
 * @author ToufuSekka
 */
public class SpecialItems {
	private ItemStack Item;
	private ItemMeta ComMeta;

	/**
	 * 
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
}
