package MCPlugIn119v.Recipe;

import java.util.*;
import org.bukkit.*;
import org.bukkit.inventory.*;

public class RecipeBase {

	Recipe[] rec;

	public ShapelessRecipe ShaplessAdder(NamespacedKey NameKey, ItemStack Result,
			List<RecipeChoice.ExactChoice> IngreSet) {
		ShapelessRecipe SR = new ShapelessRecipe(NameKey, Result);
		for (RecipeChoice.ExactChoice RecEch : IngreSet) {
			SR.addIngredient(RecEch);
		}

		return SR;
	}

	public ShapedRecipe ShapedAdder(NamespacedKey NameKey, ItemStack Result, String[] Shapes,
			Map<Character, RecipeChoice.ExactChoice> IngreSet) {
		ShapedRecipe SapRec = new ShapedRecipe(NameKey, Result);
		Set<Character> Shaper = IngreSet.keySet();

		SapRec.shape(Shapes);
		for (char c : Shaper) {
			SapRec.setIngredient(c, IngreSet.get(c));
		}
		return SapRec;
	}
}
