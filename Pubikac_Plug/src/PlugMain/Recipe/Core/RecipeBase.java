package PlugMain.Recipe.Core;

import java.util.*;

import org.bukkit.*;
import org.bukkit.inventory.*;

public class RecipeBase {
	ShapedRecipe Recp_Shape;
	NamespacedKey NameKey;
	Recipe[] Recp;
	
	Map<Character,Integer> map;// <-고쳐야함. I Ciffal
	
	public ShapedRecipe ShapedAdder(NamespacedKey NameKey, ItemStack Result,String[] Shape, RecipeChoice[] Ingredients) {
		ShapedRecipe SpdRes = new ShapedRecipe(NameKey, Result);
		List<Character> ShapeChar = new ArrayList<Character>();
		
		SpdRes.shape(Shape);
		for(String str:Shape) {
			char[] cArr = str.toCharArray();
			for(char c:cArr){
				if(c != ' ') {
					ShapeChar.add(c);
				}
			}
		}

		for(RecipeChoice igre:Ingredients)
			SpdRes.setIngredient(';', igre);

		return SpdRes;
	}
	
	@Deprecated
	public void o(NamespacedKey Key, ItemStack Result) {
		Recp_Shape = new ShapedRecipe(Key, Result);
		
		Recp = new ShapedRecipe[2];
		
		Recp[0] = Recp_Shape;
		Bukkit.addRecipe(Recp[0]);
	}
}
