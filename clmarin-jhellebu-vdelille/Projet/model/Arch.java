package model;

public class Arch implements IWeapon {
	
	public void giveWeaponExp (Hero hero){
		hero.receiveWeaponExp(20);
	}

}
