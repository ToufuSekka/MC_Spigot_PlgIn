package MCPlugIn119v.Recipe.ShapeLess;

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
			break;
		case Radioactive:
			x = 1;
			while (x < 8) {
				Bukkit.addRecipe(RadioactiveBomb(plugIn, x));
				x++;
			}
			break;
		case Nuclear:
			x = 2;
			while (x < 10) {
				Bukkit.addRecipe(NuclearBomb(plugIn, x));
				x++;
			}
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
		NamespacedKey Key = new NamespacedKey(plugIn, "Granade_" + FirePower);
		ItemStack results = new SpecialItems().LoredItem(Material.SPLASH_POTION, 1, "Granade", ForLore);

		ShapelessRecipe res = new ShapelessRecipe(Key, results);
		System.out.println("Granade Adding");
		for (int y = 0; y < FirePower; y++) {
			res.addIngredient(Material.TNT);
			System.out.print(".");
		}
		System.out.println("");
		return res;
	}

	private ShapelessRecipe RadioactiveBomb(JavaPlugin plugIn, float FirePower) {
		String[] ForLore = new String[2];
		float PowerCult = (2 * FirePower) * (1 + (FirePower * 0.1f)); // (2*TNT)*(1+(TNT/10))

		ForLore[0] = "Bomb";
		ForLore[1] = Float.toString(PowerCult);

		NamespacedKey Key = new NamespacedKey(plugIn, "RadioactiveBomb_" + FirePower);
		ItemStack results = new SpecialItems().LoredItem(Material.SPLASH_POTION, 1, "Radioactive", ForLore);

		ShapelessRecipe res = new ShapelessRecipe(Key, results);
		
		System.out.println("Radioactive Adding");
		res.addIngredient(Material.DRAGON_BREATH);
		for (int y = 0; y < FirePower; y++) {
			res.addIngredient(Material.TNT);
			System.out.print(".");
		}
		System.out.println("");
		return res;
	}

	private ShapelessRecipe NuclearBomb(JavaPlugin plugIn, float FirePower) {
		String[] ForLore = new String[2];
		float PowerCult = 6 * FirePower;

		ForLore[0] = "Bomb";
		ForLore[1] = Float.toString(PowerCult);
		NamespacedKey Key = new NamespacedKey(plugIn, "NuclearBomb_" + FirePower);
		ItemStack results = new SpecialItems().LoredItem(Material.SPLASH_POTION, 1, "Nuclear", ForLore);

		ShapelessRecipe res = new ShapelessRecipe(Key, results);
		
		System.out.println("Nuclear Adding");
		for (int y = 0; y < FirePower; y++) {
			res.addIngredient(Material.DRAGON_BREATH);
			System.out.print(".");
		}
		System.out.println("");
		return res;
	}
}
