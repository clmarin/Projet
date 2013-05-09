package model;

import java.awt.Image;

import view.InterfaceObserver;



public interface IHero {
	
	//pour les changements
	void changePositionX(int x);
	void changePositionY(int y);
	void changeName(String name);
	//public void addInterfaceObserver(InterfaceObserver obs); //pff
	void hero();
	
	//revoie les elements
	public int getpositionX();
	public int getpositionY();
	public Image getSkin();
	public int getExp();
	public String getName();
	public String getLevel();
	public int getLife();
	public int getWeaponExp();
	
	//actions possibles
	void receiveDamage(int damages);
	void receiveHealing(int healing);
	void receiveExp(int bonus);
	void receiveHealing();
	boolean isAlive();
	void attack(ICreature opponent);
	void receiveWeaponExp(int weaponExp);	
	
	
}
