package model;

import java.util.List;

public class Rencontre {
	
	private List<IHero> heros;
	private List<ICreature> opponents;
	private ICreature creature;
	private ICreature creature2;
	private int posXHero;
	private int posYHero;
	private int posXCreature;
	private int posYCreature;
	private boolean bool;
	
	
	public boolean rencontre(List<IHero> heros, List<ICreature> opponents){

		this.heros = heros;
		this.opponents = opponents;
		bool = false;
		
		for ( int j = 0 ; j < heros.size() ; j++) {
			IHero hero = heros.get(j);
			posXHero = hero.getpositionX();
			posYHero = hero.getpositionY();
			for (int i=0 ; i<opponents.size() ; i++){
				creature = opponents.get(i);
				posXCreature = creature.getPositionX();
				posYCreature = creature.getPositionY();
				if ((posXHero - posXCreature) < 10 
						&& (posXHero - posXCreature) > -10
						&& (posYHero - posYCreature) < 10
						&& (posYHero - posYCreature) > -10){
					bool = true;
				}
			}		
		}
		return bool;
	}
	
	public ICreature Monster(List<IHero> heros, List<ICreature> opponents){

		this.heros = heros;
		this.opponents = opponents;
		creature2 = null;
		
		for ( int j = 0 ; j < heros.size() ; j++) {
			IHero hero = heros.get(j);
			posXHero = hero.getpositionX();
			posYHero = hero.getpositionY();
			for (int i=0 ; i<opponents.size() ; i++){
				creature = opponents.get(i);
				posXCreature = creature.getPositionX();
				posYCreature = creature.getPositionY();
				if ((posXHero - posXCreature) < 10 
						&& (posXHero - posXCreature) > -10
						&& (posYHero - posYCreature) < 10
						&& (posYHero - posYCreature) > -10){
					creature2 = creature;
				}
			}		
		}
		return creature2;
	}
	
	public int indexCreature(List<IHero> hero, List<ICreature> opponents){

		this.heros = heros;
		this.opponents = opponents;
		int ind = 0;
		
		for ( int j = 0 ; j < heros.size() ; j++) {
			IHero hero1 = heros.get(j);
			posXHero = hero1.getpositionX();
			posYHero = hero1.getpositionY();
			for (int i=0 ; i<opponents.size() ; i++){
				creature = opponents.get(i);
				posXCreature = creature.getPositionX();
				posYCreature = creature.getPositionY();
				if ((posXHero - posXCreature) < 10 
						&& (posXHero - posXCreature) > -10
						&& (posYHero - posYCreature) < 10
						&& (posYHero - posYCreature) > -10){
					ind = i;
				}
			}		
		}
		return ind;
	}
	
	public int indexHero(List<IHero> heros, List<ICreature> opponents){

		this.heros = heros;
		this.opponents = opponents;
		int ind = 0;
		
		for ( int j = 0 ; j < heros.size() ; j++) {
			IHero hero = heros.get(j);
			posXHero = hero.getpositionX();
			posYHero = hero.getpositionY();
			for (int i=0 ; i<opponents.size() ; i++){
				creature = opponents.get(i);
				posXCreature = creature.getPositionX();
				posYCreature = creature.getPositionY();
				if ((posXHero - posXCreature) < 10 
						&& (posXHero - posXCreature) > -10
						&& (posYHero - posYCreature) < 10
						&& (posYHero - posYCreature) > -10){
					ind = j;
				}
			}		
		}
		return ind;
	}
}


