package model;

public class Sword implements IWeapon {
	
	public void giveWeaponExp (Hero hero){
		hero.receiveWeaponExp(10);
	}

}
