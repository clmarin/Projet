package model;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import model.*;
import view.*;

public class Vermine implements ICreature {
	
	//la plus nul de toutes les creatures
	
	private int life = 10;
	private Image skin = Toolkit.getDefaultToolkit().getImage("vermine.gif");
	private int positionX;
	private int positionY;
	private Random random;
	private Knife knife;
	
	public Vermine(int positionX, int positionY){
		this.positionX = positionX;
		this.positionY = positionY;		
	}

	
	//renvoie des donnees
	
	public Image getSkin() {
		return skin;
	}

	public int getLife(){
		return life;
	}
	
	public int getPositionX(){
		return positionX;
	}
	
	public int getPositionY(){
		return positionY;
	}


	
	//actions possibles
	
	@Override
	public void receiveDamage(int damages) {
		this.life -= 2*damages;
	}

	@Override
	public void receiveHealing(int healing) {
		this.life += healing;
        if (this.life > 10) {
            this.life = 10;
        }
	}
	
	
    @Override
    public void receiveHealing() {
        this.life = 10;
    }

	@Override
	public boolean isAlive() {
		return this.life > 0;
	}
	
	public String giveWeapon (Hero opponent, List weapons){
		this.random = new Random();
		int rand2 = this.random.nextInt(5);
		String weapon = null;
		if (rand2 < 1){
			weapons.add("Couteau");
			weapon = "Couteau";
			knife.giveWeaponExp(opponent);
		}
		return weapon;
	}
	
	public void givePotion (Hero opponent, List<IPotion> potions){
		this.random = new Random();
		int rand3 = this.random.nextInt(5);
		if (rand3 <2){
			potions.add(new Potion());
		}
	}
	

	@Override
	public void attack(IHero opponent) {
		opponent.receiveExp(1);
		this.random = new Random();
		int rand = this.random.nextInt(5);
		opponent.receiveDamage(rand);          //peut etre modifi� pour rendre le jeu plus dur/facile
	}

}

