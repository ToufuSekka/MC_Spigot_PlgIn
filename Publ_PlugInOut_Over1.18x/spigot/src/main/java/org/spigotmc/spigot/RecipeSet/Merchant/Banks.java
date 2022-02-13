package org.spigotmc.spigot.RecipeSet.Merchant;

import java.util.*;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.spigotmc.spigot.CstItems.*;

public class Banks extends CustItem {
	private MerchantRecipe[] Mer_Rec;
	private Merchant Bank;
	private List<MerchantRecipe> MerRec_List;
		
	public Merchant ExchangerBank() {
		Bank = Bukkit.createMerchant("국제 눈사람 은행");
		Mer_Rec = new MerchantRecipe[3];
		
		ItemStack CheckPaper = LoredItem(Material.PAPER, 1,"수표(64블럭)",
				new String[]{"64블럭", "아래의 국제은행에서 보증합니다.", "-눈사람 은행-"});
		/*
		ItemStack CheckPapers64 = LoredItem(Material.PAPER, 64,"ISB Paper(For 64 Blocks)",
				new String[]{"64 Blocks", "This guarantees in the Bank", "-International SnowmanBank-"});
		
		ItemStack CheckBook = LoredItem(Material.PAPER,1, "ISB PaperSet(For 64 ISB Paper)",
				new String[]{"64 ISB Papers", "This guarantees in the Bank", "-International SnowmanBank-"});
		*/
		
		ItemStack NewCheckPaper = LoredItem(Material.PAPER, 1,"ISB Paper(For 64 Blocks)",
				new String[]{"64 Blocks", "This guarantees in the Bank", "-International SnowmanBank-"});
		
		this.Mer_Rec[0] = new MerchantRecipe(NewCheckPaper, 1024);
		this.Mer_Rec[0].addIngredient(new ItemStack(Material.EMERALD_BLOCK, 64));
		this.Mer_Rec[0].setUses(0);
		
		//언젠간 삭제할것임.
		this.Mer_Rec[1] = new MerchantRecipe(NewCheckPaper, 1024);
		this.Mer_Rec[1].addIngredient(CheckPaper);
		this.Mer_Rec[1].setUses(0);
		
		this.Mer_Rec[2] = new MerchantRecipe(new ItemStack(Material.EMERALD_BLOCK, 64), 1024);
		this.Mer_Rec[2].addIngredient(NewCheckPaper);
		this.Mer_Rec[2].setUses(0);
		
		MerRec_List =new ArrayList<MerchantRecipe>(Arrays.asList(Mer_Rec));
		Bank.setRecipes(MerRec_List);
		return Bank;
	}
}
