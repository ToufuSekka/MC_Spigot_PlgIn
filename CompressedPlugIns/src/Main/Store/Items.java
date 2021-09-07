package Main.Store;

import java.util.*;

import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

/**
 * 일반말고, 특수한 아이탬을 만들기 위한 클래스다.
 * @author ToufuSekka
 *
 */
public class Items {

	// base
	private ItemStack Item;
	private ItemMeta Meta;
	private List<String> Lore = new ArrayList<String>();

	/**
	 * 특수아이탬을 만들기 위한 기초.
	 * @param ItemType 원본이 될 아이탬의 형태를 기입하는 곳.
	 * @param Stacks 아이탬의 갯수를 기입.
	 * @param ItemName 바꾸고 싶은 원본 아이탬의 이름
	 * @param LoreData 넣고싶은 설명란
	 * @return 당장 눈으로 보이지 않는, 인게임의 아이탬화 되어 표기된다.
	 */
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
	
	/**
	 * 화약추진로켓을 위한 함수.
	 * @param Power 날아갈 힘(시간)을 정한다. 최소 0, 최대 128까지 넣을수 있다.
	 * @param Stacks 아이탬의 갯수
	 * @param Effect 로켓의 폭발 효과를 넣을수 있다.
	 * @param ItemName 원본아이탬의 바꾸고 싶은 
	 * @param LoreData 넣고싶은 특수한 아이탬 설명을 기입한다.
	 * @return 안알려줌.
	 */
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

	/**
	 * 특수한 마법이 부여된 아이탬을 만들기 위함 함수다.
	 * @param ItemType 원본이 되는 아이탬의 종류.
	 * @param Enchan 적용하고 싶은 마법종류. 옆의 Level과 갯수가 맞아야한다.
	 * @param level 적용마법의 래벨. 옆의 마법의 갯수와 맞아야한다.
	 * @return 안알랴줌
	 */
	public ItemStack CustEnchItem(Material ItemType, Enchantment[] Enchan, int[] level) {
		this.Item = new ItemStack(ItemType);
		this.Meta = (ItemMeta) Item.getItemMeta();
		for (int i = 0; i < Enchan.length; i++) {
			this.Meta.addEnchant(Enchan[i], level[i], true);
		}
		this.Item.setItemMeta(this.Meta);
		return this.Item;
	}
	
	protected ItemStack SpecItem(Material ItemType) {
		this.Item = new ItemStack(ItemType);
		this.Meta = (ItemMeta) Item.getItemMeta();
		
		this.Item.setItemMeta(this.Meta);
		return this.Item;
	}
}