package Main.Store.Recipes;

import java.util.*;
import org.bukkit.*;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;

import Main.Store.Items;

public class EVT_StoreRes extends Items {

	private MerchantRecipe[] mr; // putting in Each other recipe for Wanting Item
	private Merchant Mc; // Creating InventorySystem
	private List<MerchantRecipe> ResList; // recipe holder
	ItemStack Item;

	// 오브 이벤트
	public Merchant OrbEvent() {
		this.Mc = Bukkit.createMerchant("정수 연금술사");
		this.mr = new MerchantRecipe[4];
		this.ResList = new ArrayList<MerchantRecipe>();

		String Lore_Nether[] = { "지옥의 아귀에서 태어난 더러운 정수이다.", "이것을 가져가 정수 연금수사에게 보여주면", "쓸만한 것으로 바꿔준다 한다.",
				"명령어[/evt orb]로 확인해 보자." };
		
		String Lore_Over[] = { "이 세계에 흝뿌려진 순수한 영혼이 담긴 정수이다.", "이것을 가져가 정수 연금수사에게 보여주면", "쓸만한 것으로 바꿔준다 한다.",
				"명령어[/evt orb]로 확인해 보자." };
		/*
		String Lore_Ender[] = { "이 세계에서 절대 존재 해선 안되는 정수이다.", "이것을 가져가 정수 연금수사에게 보여주면", "쓸만한 것으로 바꿔준다 한다.",
				"명령어[/evt orb]로 확인해 보자." };
				*/
		
		// recipe1
		this.mr[0] = new MerchantRecipe(
				PowerROCKET(3, 1, FireworkEffect.builder().with(Type.BALL).withColor(Color.BLACK), "3.5in 박격포탄",
						new String[] { "박격 1 단계" }),
				1024);
		this.mr[0].addIngredient(LoredItem(Material.MAGMA_CREAM, 1, "선혈의 정수", Lore_Nether));
		this.mr[0].setUses(0);

		// recipe2
		this.mr[1] = new MerchantRecipe(new ItemStack(Material.DIAMOND_BLOCK, 1), 1024);
		this.mr[1].addIngredient(LoredItem(Material.MAGMA_CREAM, 36, "선혈의 정수", Lore_Nether));
		this.mr[1].setUses(0);

		// recipe3
		this.mr[2] = new MerchantRecipe(new ItemStack(Material.COAL_BLOCK, 4), 1024);
		this.mr[2].addIngredient(LoredItem(Material.SLIME_BALL, 1, "자연의 정수", Lore_Over));
		this.mr[2].setUses(0);

		// recipe4
		this.mr[3] = new MerchantRecipe(
				CustEnchItem(Material.CROSSBOW, new Enchantment[] { Enchantment.QUICK_CHARGE }, new int[] { 5 }), 1024);
		this.mr[3].addIngredient(LoredItem(Material.SLIME_BALL, 16, "자연의 정수", Lore_Over));
		this.mr[3].addIngredient(new ItemStack(Material.CROSSBOW));
		this.mr[3].setUses(0);

		// recipe5*
		//this.mr[1] = new MerchantRecipe(new ItemStack(Material.DIAMOND_BLOCK, 1), 1024);
		//this.mr[1].addIngredient(LoredItem(Material.MAGMA_CREAM, 36, "선혈의 정수", Lore_Nether));
		//this.mr[1].setUses(0);

		// adder
		for (int i = 0; i < this.mr.length; i++)
			this.ResList.add(this.mr[i]);

		this.Mc.setRecipes(this.ResList);
		return this.Mc;
	}
}
