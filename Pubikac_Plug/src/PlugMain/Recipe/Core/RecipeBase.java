package PlugMain.Recipe.Core;

import org.bukkit.*;
import org.bukkit.inventory.*;

public class RecipeBase {
	ShapedRecipe Recp_Shape;
	NamespacedKey NameKey;
	Recipe[] Recp;
	
	
	
	public RecipeBase(NamespacedKey Key, ItemStack Result, ItemStack[] Ingredients) {
		//
	}
	
	public void o(NamespacedKey Key, ItemStack Result) {
		Recp_Shape = new ShapedRecipe(Key, Result);
		
		Recp = new ShapedRecipe[2];
		
		Recp[0] = Recp_Shape;
		Bukkit.addRecipe(Recp[0]);
	}
}
