package model;

import java.util.List;

public interface IPotion {
	
	void giveHealing (Hero hero, List<IPotion> potions);

}
