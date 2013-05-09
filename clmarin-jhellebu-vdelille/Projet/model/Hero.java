package model;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import view.*;

public class Hero implements IHero{
	
	private Image skin = Toolkit.getDefaultToolkit().getImage("hero.png");
	int dx=0;
	int dy=0;
	int exp;
	private int positionX = 150;
	private int positionY= 150;
	private int life = 100;
	private Random random;
	private int weaponExp = 0;
	private String name;
	
	public void hero(){
		if( positionY + dy < 280 && 0 < positionY+ dy &&  positionX + dx < 400 && 0 < positionX+dx ){
			 positionX+=dx*10;
			 positionY+=dy*10;
		}
		else{
			
		}
	}
	
// change les elements
	
	public void varPosXX(int dx) {
			this.dx=dx;
		}
	
	public void varPosY(int dy) {
			this.dy= dy;
	}
	public void setPosXHero(int posX){
		positionX = posX;
	}
	public void setPosYHero(int posY){
		positionY = posY;
	}
	public void setLife(int life){
		this.life=life;
	}
	
// Renvoi des elements
	public int getpositionX() {
		return positionX;
	}
	public int getpositionY() {
		return positionY;
	}
	public int getLife() {
		return life;
	}
	public Image getSkin() {
		return skin;
	}
	public int getExp(){
		return exp;
	}
	public String getName(){
		return name;
	}
	public int getWeaponExp(){
		return weaponExp;
	}
	
	//actions possibles
	@Override
	public void receiveDamage(int damages) {
		this.life -= damages;
	}

	@Override
	public void receiveHealing(int healing) {
		this.life += healing;
        if (this.life > 100) {
            this.life = 100;
        }
	}

    @Override
    public void receiveHealing() {
        this.life = 100;
    }
    
    public void receiveWeaponExp(int weaponExp){
    	this.weaponExp += weaponExp;
    }

	@Override
	public boolean isAlive() {
		return this.life > 0;
	}

	@Override
	public void attack(ICreature opponent) {
		this.random = new Random();
		int rand = this.random.nextInt(10);
		if (rand < 2){
			opponent.receiveDamage(3*(exp + weaponExp));
			// Le joueur a 2 chances sur 10 de faire de gros degats
		}
		if (rand > 1 || rand < 6){
			opponent.receiveDamage(2*(exp + weaponExp));
			// le joueur a 4 chances sur 10 de faire de moyens degats
		}
		if (rand > 5 || rand < 8){
			opponent.receiveDamage(exp + weaponExp);
			// le joueur a 2 chances sur 10 de faire de petits degats
		}
		else{
			opponent.receiveDamage(0);
			// le joueur a 2 chances sur 10 de faire aucun degat
		}           
	}
	
	public void receiveExp (int bonus){
		this.exp += bonus;
		
	}

	@Override
	public void changeName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLevel() {
		// TODO Auto-generated method stub
		return null;
	}

}