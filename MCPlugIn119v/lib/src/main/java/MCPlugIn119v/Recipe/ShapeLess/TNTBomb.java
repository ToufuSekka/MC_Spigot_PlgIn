package MCPlugIn119v.Recipe.ShapeLess;

import java.util.*;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.plugin.java.*;
import org.bukkit.FireworkEffect.*;

import MCPlugIn119v.Items.*;
import MCPlugIn119v.Recipe.EnumSet.*;

public class TNTBomb {

	public TNTBomb(BombType type, JavaPlugin plugIn) {
		int x = 0;
		switch (type) {
		case Bomb:
			x = 2;
			while (x < 10) {
				Bukkit.addRecipe(Granade(plugIn, x));
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
		case Howitzer:
			x = 1;
			while (x < 9) {
				Bukkit.addRecipe(CannonGun(plugIn, x));
				Bukkit.addRecipe(PoweredCannonGun(plugIn, x));
				x++;
			}
			break;
		default:
			break;
		}
	}

	private ShapelessRecipe Granade(JavaPlugin plugIn, float FirePower) {
		String[] ForLore = new String[2];
		float PowerCult = 2.5f * FirePower;

		ForLore[0] = "Bomb";
		ForLore[1] = Float.toString(PowerCult);

		NamespacedKey Key = new NamespacedKey(plugIn, "Granade_" + FirePower);
		ItemStack results = new SpecialItems().LoredItem(Material.SPLASH_POTION, 1, "Granade", ForLore);
		ShapelessRecipe res = new ShapelessRecipe(Key, results);

		for (int y = 0; y < FirePower; y++)
			res.addIngredient(Material.TNT);

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

		for (int y = 0; y < FirePower; y++)
			res.addIngredient(Material.DRAGON_BREATH);

		return res;
	}

	private ShapelessRecipe CannonGun(JavaPlugin plugIn, float FirePower) {
		String[] ForLore = new String[2];
		float PowerCult = FirePower * 1;

		ForLore[0] = "Howitzer";
		ForLore[1] = Float.toString(PowerCult);

		NamespacedKey Key = new NamespacedKey(plugIn, "Howitzer_" + FirePower);
		ItemStack results = new SpecialItems().Lored_Fire(2, 6,
				FireworkEffect.builder().withColor(Color.BLACK).with(Type.BALL), "Howitzer", ForLore);
		ShapelessRecipe res = new ShapelessRecipe(Key, results);

		res.addIngredient(Material.FIREWORK_ROCKET);
		for (int y = 0; y < FirePower; y++)
			res.addIngredient(Material.TNT);

		return res;
	}
	
	private ShapelessRecipe PoweredCannonGun(JavaPlugin plugIn, float FirePower) {
		String[] ForLore = new String[2];
		float PowerCult = FirePower * 4;

		ForLore[0] = "Howitzer";
		ForLore[1] = Float.toString(PowerCult);

		NamespacedKey Key = new NamespacedKey(plugIn, "Howitzer_" + (FirePower+8));
		ItemStack results = new SpecialItems().Lored_Fire(2, 6,
				FireworkEffect.builder().withColor(Color.BLACK).with(Type.BALL), "Howitzer", ForLore);
		ShapelessRecipe res = new ShapelessRecipe(Key, results);

		res.addIngredient(Material.FIREWORK_ROCKET);
		for (int y = 0; y < FirePower; y++)
			res.addIngredient(Material.DRAGON_BREATH);

		return res;
	}
}
