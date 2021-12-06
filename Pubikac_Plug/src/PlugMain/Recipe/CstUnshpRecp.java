package PlugMain.Recipe;

import java.util.*;
import org.bukkit.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.RecipeChoice.ExactChoice;
import PlugMain.Recipe.Core.*;

public class CstUnshpRecp extends RecipeBase {
	
	JavaPlugin JvPlugin;
	
	private RecipeChoice.ExactChoice ReChoEx;
	
	private RecipeBase RecBase;
	private AdvItemBase AdvItmBas;
	
	private NamespacedKey NameKey;
	private ItemStack Result;
	private List<RecipeChoice> ingreds = new ArrayList<RecipeChoice>();
	
	public void Bomb_Level_1() {
		AdvItmBas = new AdvItemBase();
		RecBase = new RecipeBase();
		
		NameKey = new NamespacedKey(JvPlugin, "NeptuneCustom_BombSet");
		Result = AdvItmBas.LoredItem(Material.SPLASH_POTION, "ÆøÅº", new String[] {"Bomb_Power6"});
		ReChoEx = new ExactChoice(new ItemStack(Material.TNT,2));
		ingreds.add(ReChoEx);
		
		Bukkit.addRecipe(RecBase.UnShapeAdder(NameKey, Result, ingreds));
	}
}
