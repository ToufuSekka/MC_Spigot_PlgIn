package PlugMain.Recipe;

import java.util.*;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.plugin.java.*;

import PlugMain.Recipe.Core.*;

public class ShapedRecp {
	
	private NamespacedKey NameKey;
	private ItemStack Result;
	
	private RecipeBase RecBase;
	private AdvItemBase AdvItBass;
	
	private RecipeChoice.ExactChoice ReChoEx;
	private Map<Character, RecipeChoice> ChoisList;
	private JavaPlugin JvPlugin;
	
	private String[] Shapes;
	
	public void Rec1() {
		RecBase = new RecipeBase();
		NameKey = new NamespacedKey(JvPlugin, "NeptuneCustom");
		Result = new ItemStack(Material.SPLASH_POTION);
		ChoisList = new HashMap<Character, RecipeChoice>();
		
		
		
		Bukkit.addRecipe(RecBase.ShapedAdder(NameKey, Result, Shapes, ChoisList));
	}
}
