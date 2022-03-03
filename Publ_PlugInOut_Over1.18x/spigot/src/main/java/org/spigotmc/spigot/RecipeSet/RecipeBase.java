package org.spigotmc.spigot.RecipeSet;

import java.util.*;

import org.bukkit.*;
import org.bukkit.inventory.*;

public class RecipeBase {
	Recipe[] Recp;
	
	@SuppressWarnings("static-method")
	public ShapelessRecipe UnShapeAdder(NamespacedKey NameKey, ItemStack Result, List<RecipeChoice> IngreSets) {
		ShapelessRecipe SplRec = new ShapelessRecipe(NameKey,Result);
		for(RecipeChoice RC:IngreSets) {
			SplRec.addIngredient(RC);
		}
		return SplRec;
	}
	
	@SuppressWarnings("static-method")
	public ShapedRecipe ShapedAdder(NamespacedKey NameKey, ItemStack Result,String[] Shape, Map<Character, RecipeChoice> IngreSets) {
		// ~RecipeChoice RecCho = new RecipeChoice.ExactChoice(new ItemStack(Material.MAGENTA_BANNER));
		Set<Character> ItemSet = IngreSets.keySet();
		
		ShapedRecipe SpdRes = new ShapedRecipe(NameKey, Result);
		SpdRes.shape(Shape);
		for(char c:ItemSet) {
			SpdRes.setIngredient(c, IngreSets.get(c));
		}
		return SpdRes;
	}
}
