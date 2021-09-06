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
		ItemStack CheckPaper = LoredItem(Material.PAPER, 1, "수표 (64블럭)",
				new String[] { "64블럭", "아래의 국제은행에서 보증합니다.", "-눈사람 은행-" });
		ItemStack CheckPaper64 = LoredItem(Material.PAPER, 64, "수표 (64블럭)",
				new String[] { "64블럭", "아래의 국제은행에서 보증합니다.", "-눈사람 은행-"});
		ItemStack CheckBook = LoredItem(Material.BOOK, 1, "수표뭉치(64 수표)",
				new String[] { "64수표", "아래의 국제은행에서 보증합니다.", "-눈사람 은행-"});

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
}
