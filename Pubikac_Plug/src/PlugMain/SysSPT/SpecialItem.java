package PlugMain.SysSPT;
import java.util.*;

import org.bukkit.Material;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

/**
 * @author ToufuSekka
 * �ϰ� ����� ���� �������� �����ϰ� ���� ¥������ ���� Ŭ����.
 */
public class SpecialItem {
	private ItemStack Origin;
	private ItemMeta Meta;
	
	private List<String> Lore = new ArrayList<String>();
	
	/**
	 * ��� ���� ���� ���� �ֱ� ���� ������ ���� �Լ�.
	 * @param ItemType ������ ����.
	 * @param Stacks �ּ� '1'�̻��� �����Ұ�.
	 * @param ItemName ������ �̸�. ��� ��. �Ⱦ��Ÿ� nulló���Ұ�.
	 * @param TextData ������ ���� �̸�. �̰��� ũ������ �ʴ��̻� �������.
	 * @return �ϰ� ���ߴ� ������.
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
