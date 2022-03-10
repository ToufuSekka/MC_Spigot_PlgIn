package MCPlugIn119v.Recipe.SahpeLess;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.plugin.java.*;

import MCPlugIn119v.Items.*;
import MCPlugIn119v.Recipe.EnumSet.*;

public class TNTBomb {

	public TNTBomb(BombType type, JavaPlugin plugIn) {
		int x = 0;
		switch (type) {
		case TNTBomb:
			x = 2;
			while (x < 10) {
				Bukkit.addRecipe(Granade(plugIn, x));
				x++;
			}
			System.out.println("TNTBomb Added");
			break;
		case Radioactive:
			x = 1;
			while (x < 8) {
				Bukkit.addRecipe(RadioactiveBomb(plugIn, x));
				x++;
			}
			System.out.println("RadioactiveBomb Added");
			break;
		case Nuclear:
			x = 2;
			while (x < 10) {
				Bukkit.addRecipe(NuclearBomb(plugIn, x));
				x++;
			}
			System.out.println("RadioactiveBomb Added");
			break;
		default:
			break;
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

	private ShapelessRecipe RadioactiveBomb(JavaPlugin plugIn, float FirePower) {
		String[] ForLore = new String[2];
		float PowerCult = (2 * FirePower) * (1 + (FirePower * 0.1f)); // (2*TNT)*(1+(TNT/10))

		ForLore[0] = "Bomb";
		ForLore[1] = Float.toString(PowerCult);

		NamespacedKey Key = new NamespacedKey(plugIn, "fireweapon_type2_" + FirePower);
		ItemStack results = new SpecialItems().LoredItem(Material.SPLASH_POTION, 1, "Radioactive", ForLore);

		ShapelessRecipe res = new ShapelessRecipe(Key, results);

		res.addIngredient(Material.DRAGON_BREATH);
		for (int y = 0; y < FirePower; y++) {
			res.addIngredient(Material.TNT);
		}
		return res;
	}

	private ShapelessRecipe NuclearBomb(JavaPlugin plugIn, float FirePower) {
		String[] ForLore = new String[2];
		float PowerCult = 6 * FirePower;

		ForLore[0] = "Bomb";
		ForLore[1] = Float.toString(PowerCult);
		NamespacedKey Key = new NamespacedKey(plugIn, "fireweapon_type3_" + FirePower);
		ItemStack results = new SpecialItems().LoredItem(Material.SPLASH_POTION, 1, "Nuclear", ForLore);

		ShapelessRecipe res = new ShapelessRecipe(Key, results);
		for (int y = 0; y < FirePower; y++) {
			res.addIngredient(Material.DRAGON_BREATH);
		}
		return res;
	}
}
