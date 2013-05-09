package model;

import java.util.List;

public class Potion implements IPotion {
	
	public void giveHealing (Hero hero, List<IPotion> potions){
		if (!potions.isEmpty()){
			hero.receiveHealing(30);
			potions.remove(0);
		}
		else{
		}	
	}

	
	

}
