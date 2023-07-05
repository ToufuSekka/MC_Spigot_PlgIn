package MCPlugIn119v.Recipe.Smith;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

public class Rifle {
	private SmithingRecipe SR;
	private ItemStack Gun;
	private ItemMeta IM;
	
	public void TestRecipe() {
		Gun = new ItemStack(Material.CROSSBOW);
		Gun.addEnchantment(Enchantment.QUICK_CHARGE, 5);
		RecipeChoice.ExactChoice R_E = new RecipeChoice.ExactChoice(Gun);
		
		SR = new SmithingRecipe(null, null, null, R_E);
	}
}
