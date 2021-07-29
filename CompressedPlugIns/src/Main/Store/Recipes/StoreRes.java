package Main.Store.Recipes;

import java.util.*;
import org.bukkit.*;
import org.bukkit.inventory.*;

import Main.Store.Items;

public class StoreRes extends Items {

	private MerchantRecipe[] mr; // putting in Each other recipe for Wanting Item
	private Merchant Mc; // Creating InventorySystem
	private List<MerchantRecipe> ResList; // recipe holder
	ItemStack Item;

	public Merchant Bank() {
		this.Mc = Bukkit.createMerchant("은행");
		this.mr = new MerchantRecipe[4];
		this.ResList = new ArrayList<MerchantRecipe>();
		ItemStack CheckPaper = LoredItem(Material.PAPER, 1, "수표(보증 64블)",
				new String[] { "64블럭", "해당아이탬은 위의 금액을 보증합니다.", "눈사람은행" });
		ItemStack CheckPaper64 = LoredItem(Material.PAPER, 64, "수표(보증 64블)",
				new String[] { "64블럭", "해당아이탬은 위의 금액을 보증합니다.", "눈사람은행" });
		ItemStack CheckBook = LoredItem(Material.BOOK, 1, "수표(보증 64수표)",
				new String[] { "64수표", "해당아이탬은 위의 금액을 보증합니다.", "눈사람은행" });

		// recipe_1
		this.mr[0] = new MerchantRecipe(CheckPaper, 1024);
		this.mr[0].addIngredient(new ItemStack(Material.EMERALD_BLOCK, 64));
		this.mr[0].setUses(0);

		// recipe_2
		this.mr[1] = new MerchantRecipe(new ItemStack(Material.EMERALD_BLOCK, 64), 1024);
		this.mr[1].addIngredient(CheckPaper);
		this.mr[1].setUses(0);

		// recipe_3
		this.mr[2] = new MerchantRecipe(CheckBook, 1024);
		this.mr[2].addIngredient(CheckPaper64);
		this.mr[2].setUses(0);

		// recipe_4
		this.mr[3] = new MerchantRecipe(CheckPaper64, 1024);
		this.mr[3].addIngredient(CheckBook);
		this.mr[3].setUses(0);
		// adder
		for (int i = 0; i < this.mr.length; i++)
			this.ResList.add(this.mr[i]);

		this.Mc.setRecipes(this.ResList);
		return this.Mc;
	}

	// 화약상
	public Merchant Deal() {
		this.Mc = Bukkit.createMerchant("화공장인");
		this.mr = new MerchantRecipe[5];
		this.ResList = new ArrayList<MerchantRecipe>();

		ItemStack[] Bomb = { LoredItem(Material.SPLASH_POTION, 1, "멸망탄", new String[] { "멸망 1 단계" }),
				LoredItem(Material.SPLASH_POTION, 1, "멸망탄", new String[] { "멸망 2 단계" }),
				LoredItem(Material.SPLASH_POTION, 1, "멸망탄", new String[] { "멸망 3 단계" }),
				LoredItem(Material.SPLASH_POTION, 1, "멸망탄", new String[] { "멸망 4 단계" }) };

		// recipe1
		this.mr[0] = new MerchantRecipe(PowerROCKET(18, 2, null, "방사능 화학탄", null), 1024);
		this.mr[0].addIngredient(PowerROCKET(3, 1, null, null, null));
		this.mr[0].addIngredient(new ItemStack(Material.DRAGON_BREATH, 1));
		this.mr[0].setUses(0);

		// recipe2
		this.mr[1] = new MerchantRecipe(Bomb[0], 1024);
		this.mr[1].addIngredient(new ItemStack(Material.TNT, 2));
		this.mr[1].setUses(0);

		// recipe3~5
		for (int j = 2; j < this.mr.length; j++) {
			this.mr[j] = new MerchantRecipe(Bomb[j-1], 1024);
			this.mr[j].addIngredient(Bomb[j - 2]);
			this.mr[j].addIngredient(new ItemStack(Material.DRAGON_BREATH, j-1));
			this.mr[j].setUses(0);
		}

		// adder
		for (int i = 0; i < this.mr.length; i++)
			this.ResList.add(this.mr[i]);

		this.Mc.setRecipes(this.ResList);
		return this.Mc;
	}

	// 이벤트 전용1
	public Merchant Event() {
		this.Mc = Bukkit.createMerchant("고대유적 수집상");
		this.mr = new MerchantRecipe[5];
		this.ResList = new ArrayList<MerchantRecipe>();

		String[] Lore = { "멸망했던 제국의 건물 잔해이다.", "쓸모 없어 보이는 이것을", "부덴아우스 유적제단에서", "모조리 회수 한다고 한다.",
				"명령어의 [/store evt]로 그 목록을 확인해 보자." };

		ItemStack[] Stack = { LoredItem(Material.COBBLESTONE_WALL, 1, "고대 시대의 잔해", Lore),
				LoredItem(Material.COBBLESTONE_WALL, 4, "고대 시대의 잔해", Lore),
				LoredItem(Material.COBBLESTONE_WALL, 8, "고대 시대의 잔해", Lore),
				LoredItem(Material.COBBLESTONE_WALL, 16, "고대 시대의 잔해", Lore),
				LoredItem(Material.COBBLESTONE_WALL, 32, "고대 시대의 잔해", Lore)};

		this.mr[0] = new MerchantRecipe(new ItemStack(Material.GUNPOWDER, 9), 1024);
		this.mr[1] = new MerchantRecipe(new ItemStack(Material.IRON_BLOCK, 4), 1024);
		this.mr[2] = new MerchantRecipe(new ItemStack(Material.GOLD_BLOCK, 6), 1024);
		this.mr[3] = new MerchantRecipe(new ItemStack(Material.ANCIENT_DEBRIS, 1), 1024);
		this.mr[4] = new MerchantRecipe(new ItemStack(Material.DRAGON_EGG, 1), 1024);

		// Ingred Auto
		for (int i = 0; i < mr.length; i++) {
			this.mr[i].addIngredient(Stack[i]);
			this.mr[i].setUses(0);
		}

		// adder
		for (int i = 0; i < this.mr.length; i++)
			this.ResList.add(this.mr[i]);

		this.Mc.setRecipes(this.ResList);
		return this.Mc;
	}
}
