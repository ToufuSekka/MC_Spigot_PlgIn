package PlugMain.SysSPT;
import java.util.*;

import org.bukkit.Material;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

/**
 * @author ToufuSekka
 * 니가 만들고 싶은 아이탬을 적절하게 편히 짜기위해 만든 클레스.
 */
public class SpecialItem {
	private ItemStack Origin;
	private ItemMeta Meta;
	
	private List<String> Lore = new ArrayList<String>();
	
	/**
	 * 어떠한 것을 위한 것을 넣기 위한 아이탬 기입 함수.
	 * @param ItemType 아이탬 형식.
	 * @param Stacks 최소 '1'이상은 기입할것.
	 * @param ItemName 아이탬 이름. 없어도 됨. 안쓸거면 null처리할것.
	 * @param TextData 아이탬 내부 이름. 이것은 크랙하지 않는이상 못만든다.
	 * @return 니가 원했던 아이탬.
	 */
	public ItemStack LoredItem(Material ItemType, int Stacks, String ItemName, String[] TextData) {
		this.Lore.clear();
		
		for(String str:TextData)
			this.Lore.add(str);
		//Setting
		this.Origin = new ItemStack(ItemType, Stacks);
		this.Meta = (ItemMeta) Origin.getItemMeta(); 
		
		if(ItemName.isBlank())
			this.Meta.setDisplayName(ItemName);
		this.Meta.setLore(Lore);
		this.Origin.setItemMeta(Meta);
		
		return Origin;
	}
	
	protected void Rock() {
		//
	}
}
