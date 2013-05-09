package model;

import java.util.List;

public class SuperPotion implements IPotion{
	
	public void giveHealing (Hero hero, List<IPotion> potions){
		if (!potions.isEmpty()){
			hero.receiveHealing();
			potions.remove(0);
		}
		else{
		}
		
	}

}
