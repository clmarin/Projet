package model;

import java.util.List;
import java.util.Random;

public class Tournament {
	
	private boolean esc;
	private boolean finish;
	private Random random;
	private List<IPotion> potions;
	private GamePlay gamePlay;
	private Rencontre rencontre;
	
	
		
	public void fight (Hero hero, ICreature creature){
		hero.attack(creature);
		creature.attack(hero);
	}
	
	public boolean escape(Hero hero){
		esc = false;
		this.random = new Random();
		int rand = this.random.nextInt(10);
		if (rand < 6){                            //il a 1 chance sur 2 de pouvoir s'enfuir
			esc = true;
			hero.setPosXHero(150);
			hero.setPosYHero(150);
		}
		return esc;
	}
	
	
	public List<IPotion> useItem(){
		potions = gamePlay.getPotion();
		return potions;
	}
	// ajouter les indexHero et indexCreature qqpart dans une autre classe
	public boolean finish (List<IHero> challengers, Hero challenger, List<ICreature> opponents, ICreature opponent, boolean escape){
		int indexHero = rencontre.indexHero(challengers,  opponents);
		int indexCreature = rencontre.indexCreature(challengers, opponents);
		this.esc = escape;
		finish = false;
		if (!challenger.isAlive() || esc || !opponent.isAlive()){
			if (!challenger.isAlive()){
				challengers.remove(indexHero);
			}
			if (!opponent.isAlive()){
				opponents.remove(indexCreature);
			}
			finish = true;
	    }
		return finish;
	}
}



