package MCPlugIn119v.Eventer.RecipeSpecial;

import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.*;

public class T implements Listener {
	Player P;
	ShapelessRecipe RecipeView;

	@EventHandler
	public void RecipeMDF(CraftItemEvent Cie) {
		
		if(Cie.getWhoClicked() instanceof Player) {
			P = (Player) Cie.getWhoClicked();
			P.sendMessage("Created");
			RecipeView = (ShapelessRecipe) Cie.getRecipe();
			
			P.sendMessage(Cie.getCurrentItem().getItemMeta().getDisplayName()+" has Created");
			for(ItemStack View : RecipeView.getIngredientList()) {
				P.sendMessage(View.getItemMeta().getAsString());
			}
		}
	}
}