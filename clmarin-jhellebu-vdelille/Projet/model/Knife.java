package model;

public class Knife implements IWeapon{
	
	public void giveWeaponExp (Hero hero){
		hero.receiveWeaponExp(5);
	}

}
