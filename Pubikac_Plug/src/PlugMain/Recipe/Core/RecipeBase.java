package PlugMain.Recipe.Core;

import java.util.*;

import org.bukkit.*;
import org.bukkit.inventory.*;

public class RecipeBase {
	Recipe[] Recp;
	
	/**
	 * 
	 * @param NameKey 아이탬의 묶음을 표현하기 위한 것.
	 * @param Result 최종 결과물
	 * @param IngreSets 결과물의 제료들.<br/>키에 대응하는 RecipeChoice.ExactChoice~를 사용할것.<br/>
	 * Ex) RecipeChoice RecCho =<br/> new RecipeChoice.ExactChoice(new ItemStack(Material.MAGENTA_BANNER));
	 * @return 니가 원하던 결과물
	 */
	public ShapelessRecipe UnShapeAdder(NamespacedKey NameKey, ItemStack Result, List<RecipeChoice> IngreSets) {
		ShapelessRecipe SplRec = new ShapelessRecipe(NameKey,Result);
		for(RecipeChoice RC:IngreSets) {
			SplRec.addIngredient(RC);
		}
		return SplRec;
	}
	
	/**
	 * 특수 지징모양 레시피를 만들기 위한 함수.
	 * @param NameKey 아이탬의 묶음을 표현하기 위한 것.
	 * @param Result 최종 결과물
	 * @param Shape 결과물을 만들기 위한 모양세 
	 * @param IngreSets 결과물의 제료들. 키에 대응하는 RecipeChoice.<br/>ExactChoice~를 사용할것.<br/>
	 * Ex) RecipeChoice RecCho =<br/> new RecipeChoice.ExactChoice(new ItemStack(Material.MAGENTA_BANNER));
	 * @return 니가 원하던 결과물
	 */
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