package PlugMain.Recipe.Core;

import java.util.*;

import org.bukkit.*;
import org.bukkit.inventory.*;

public class RecipeBase {
	Recipe[] Recp;
	
	/**
	 * 
	 * @param NameKey �������� ������ ǥ���ϱ� ���� ��.
	 * @param Result ���� �����
	 * @param IngreSets ������� �����.<br/>Ű�� �����ϴ� RecipeChoice.ExactChoice~�� ����Ұ�.<br/>
	 * Ex) RecipeChoice RecCho =<br/> new RecipeChoice.ExactChoice(new ItemStack(Material.MAGENTA_BANNER));
	 * @return �ϰ� ���ϴ� �����
	 */
	public ShapelessRecipe UnShapeAdder(NamespacedKey NameKey, ItemStack Result, List<RecipeChoice> IngreSets) {
		ShapelessRecipe SplRec = new ShapelessRecipe(NameKey,Result);
		for(RecipeChoice RC:IngreSets) {
			SplRec.addIngredient(RC);
		}
		return SplRec;
	}
	
	/**
	 * Ư�� ��¡��� �����Ǹ� ����� ���� �Լ�.
	 * @param NameKey �������� ������ ǥ���ϱ� ���� ��.
	 * @param Result ���� �����
	 * @param Shape ������� ����� ���� ��缼 
	 * @param IngreSets ������� �����. Ű�� �����ϴ� RecipeChoice.<br/>ExactChoice~�� ����Ұ�.<br/>
	 * Ex) RecipeChoice RecCho =<br/> new RecipeChoice.ExactChoice(new ItemStack(Material.MAGENTA_BANNER));
	 * @return �ϰ� ���ϴ� �����
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