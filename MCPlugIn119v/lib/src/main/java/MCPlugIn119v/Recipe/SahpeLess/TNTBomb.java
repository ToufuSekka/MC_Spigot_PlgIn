package MCPlugIn119v.Recipe.SahpeLess;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.plugin.java.*;

import MCPlugIn119v.Items.*;

public class TNTBomb {

	public TNTBomb(JavaPlugin plugIn) {
		int x = 2;
		while (x < 10) {
			Bukkit.addRecipe(Granade(plugIn, x));
			x++;
		}
	}

	private ShapelessRecipe Granade(JavaPlugin plugIn, float FirePower) {
		String[] ForLore = new String[2];
		float PowerCult = ((4 * FirePower) + FirePower) / 2;// ( ( 4 * TNT¼ö) + TNT¼ö) / 2

		ForLore[0] = "Bomb";
		ForLore[1] = Float.toString(PowerCult);
		NamespacedKey Key = new NamespacedKey(plugIn, "fireweapon_type1_" + FirePower);
		ItemStack results = new SpecialItems().LoredItem(Material.SPLASH_POTION, 1, "Granade", ForLore);

		ShapelessRecipe res = new ShapelessRecipe(Key, results);
		for (int y = 0; y < FirePower; y++) {
			res.addIngredient(Material.TNT);
		}
		return res;
	}
}
