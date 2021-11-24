package PlugMain.Recipe;

import java.util.*;
import org.bukkit.*;
import org.bukkit.plugin.java.*;
import org.bukkit.inventory.*;

import PlugMain.Recipe.Core.*;

public class CstUnshpRecp extends RecipeBase {
	NamespacedKey NameKey;
	
	ShapelessRecipe UnShaped;
	ItemStack Result;
	ItemStack[] IngrePiece = new ItemStack[9];
	
	RecipeChoice.ExactChoice ReChoEx;
	JavaPlugin JvPlugin;
	
	public List<RecipeChoice> ingreds = new ArrayList<RecipeChoice>();
	
	public void UnShapedRec() {
		NameKey = new NamespacedKey(JvPlugin, "NeptuneCutm");
		
		//ReChoEx = new ExactChoice(null);
		
		ingreds.add(null);
		
		UnShaped = UnShapeAdder(NameKey, Result, ingreds);
	}
}
