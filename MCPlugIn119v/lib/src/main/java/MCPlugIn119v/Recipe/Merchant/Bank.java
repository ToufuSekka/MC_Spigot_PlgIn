package MCPlugIn119v.Recipe.Merchant;

import java.util.*;

import org.bukkit.*;
import org.bukkit.inventory.*;

import MCPlugIn119v.Items.*;

public class Bank extends SpecialItems {
	private Merchant BankSet;
	private MerchantRecipe[] Lists;
	private List<MerchantRecipe> ListPack;
	
	public Merchant ExchangerBanks() {
		BankSet = Bukkit.createMerchant("International SnowBank of Exchanging");
		Lists = new MerchantRecipe[3];
		
		// Rigist Items
		ItemStack KrCheckPaper = LoredItem(Material.PAPER, 1, "수표(64블럭)",
				new String[] { "64블럭", "아래의 국제은행에서 보증합니다.", "-눈사람 은행-" });

		ItemStack CheckPaper = LoredItem(Material.PAPER, 1, "ISBE Paper(For 64 Blocks)",
				new String[] { "64 Blocks", "This guarantees in the Bank", "-International SnowmanBank-" });

		// Paper
		/*
		 * ItemStack CheckPapers64 = LoredItem(Material.PAPER,
		 * 64,"ISB Paper(For 64 Blocks)", new String[]{"64 Blocks",
		 * "This guarantees in the Bank", "-International SnowmanBank-"});
		 * 
		 * ItemStack CheckBook = LoredItem(Material.PAPER,1,
		 * "ISB PaperSet(For 64 ISB Paper)", new String[]{"64 ISB Papers",
		 * "This guarantees in the Bank", "-International SnowmanBank-"});
		 */

		this.Lists[0] = new MerchantRecipe(CheckPaper, 1024);
		this.Lists[0].addIngredient(new ItemStack(Material.EMERALD_BLOCK, 64));
		this.Lists[0].setUses(0);

		// 언젠간 삭제할것임.
		this.Lists[1] = new MerchantRecipe(CheckPaper, 1024);
		this.Lists[1].addIngredient(KrCheckPaper);
		this.Lists[1].setUses(0);

		this.Lists[2] = new MerchantRecipe(new ItemStack(Material.EMERALD_BLOCK, 64), 1024);
		this.Lists[2].addIngredient(CheckPaper);
		this.Lists[2].setUses(0);

		ListPack = new ArrayList<MerchantRecipe>(Arrays.asList(Lists));
		BankSet.setRecipes(ListPack);
		return BankSet;
	}
}