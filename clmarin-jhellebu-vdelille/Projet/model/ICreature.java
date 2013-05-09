package model;

import java.awt.Image;

public interface ICreature {
	
	//renvoie les donnees
	public Image getSkin();
	public int getLife();
	public int getPositionX();
	public int getPositionY();
	
	//actions possibles
	void receiveDamage(int damages);
	void receiveHealing(int healing);
	void receiveHealing();
	boolean isAlive();
	void attack(IHero opponent);

}
