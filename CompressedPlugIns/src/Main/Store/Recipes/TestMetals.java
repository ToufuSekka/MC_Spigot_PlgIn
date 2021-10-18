package Main.Store.Recipes;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.plugin.Plugin;

public class TestMetals {
	RecipeChoice RC;
	ItemStack IS;
	ShapedRecipe Sr;
	NamespacedKey NameKey;
	
	public void v() {
		IS =new ItemStack(Material.ACACIA_BOAT);
		RC = new RecipeChoice.ExactChoice(new ItemStack(Material.YELLOW_BED));
		NameKey = new NamespacedKey((Plugin) this, "");
		Sr = new ShapedRecipe(NameKey,RC);
		
		Sr.setIngredient('a', RC);
	}
}
