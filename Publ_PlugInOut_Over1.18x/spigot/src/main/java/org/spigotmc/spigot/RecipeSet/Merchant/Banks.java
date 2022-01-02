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
		Mer_Rec = new MerchantRecipe[2];
		
		ItemStack CheckPaper = LoredItem(Material.PAPER, 1,"수표(64블럭)",
				new String[]{"64블럭", "아래의 국제은행에서 보증합니다.", "-눈사람 은행-"});
		/*
		ItemStack CheckPapers64 = LoredItem(Material.PAPER, 64,"수표(64블럭)",
				new String[]{"64블럭", "아래의 국제은행에서 보증합니다.", "-눈사람 은행-"});
		
		ItemStack CheckBook = LoredItem(Material.PAPER,1, "수표뭉치(64 수표)",
				new String[]{"64수표", "아래의 국제은행에서 보증합니다.", "-눈사람 은행-"});
		*/
		this.Mer_Rec[0] = new MerchantRecipe(CheckPaper, 1024);
		this.Mer_Rec[0].addIngredient(new ItemStack(Material.EMERALD_BLOCK, 64));
		this.Mer_Rec[0].setUses(0);
		
		this.Mer_Rec[1] = new MerchantRecipe(new ItemStack(Material.EMERALD_BLOCK, 64), 1024);
		this.Mer_Rec[1].addIngredient(CheckPaper);
		this.Mer_Rec[1].setUses(0);
		/*
		this.Mer_Rec[0] = new MerchantRecipe(CheckPaper, 1024);
		this.Mer_Rec[0].addIngredient(new ItemStack(Material.EMERALD_BLOCK, 64));
		this.Mer_Rec[0].setUses(0);
		
		this.Mer_Rec[0] = new MerchantRecipe(CheckPaper, 1024);
		this.Mer_Rec[0].addIngredient(new ItemStack(Material.EMERALD_BLOCK, 64));
		this.Mer_Rec[0].setUses(0);
		*/
		
		MerRec_List =new ArrayList<MerchantRecipe>(Arrays.asList(Mer_Rec));
		Bank.setRecipes(MerRec_List);
		return Bank;
	}
}
