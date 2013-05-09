package model;
import java.awt.BorderLayout;
import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;
import model.*;
import view.BoardGame;
import view.Interface;

//Construit et change les niveaux

public class Game {
	
	private GameBoard carte;
	private static boolean gameOver;
	private GamePlay gamePlay;
	private int level;
	private int levelmax =2;
	private String filename;
	private List<ICreature> monsters;
	private  List<IHero> heros;
	private List<IPotion> potions;
	private List<IPotion> superPotions;
	
	
	public Game(){
		gameOver = false;
		this.heros = generateChallengers();
		this.monsters = generateOpponents(1);
		this.potions = generatePotions();
		this.superPotions = generateSuperPotions();
		}
	

	public void setLevel(int level){
		// Genère les éléments des niveaux : carte, monstres, potions
		
		//Carte
		int i = 1;
		if (i == level){ // Niveau 1 -> Lire la carte1
			filename = "map1.txt";
		}
		if (i+1 == level){ 
			filename = "map2.txt";
		}
				
		try {
			carte = InOut.LireCarte(filename);
			} catch (IOException e) {e.printStackTrace();}
		//Monstre
		monsters = generateOpponents(level);
		//potions et heros
		if (level == 1){
			heros = generateChallengers();
			potions = generatePotions();
			superPotions = generateSuperPotions();
		}
		gamePlay = new GamePlay(carte, heros, monsters, potions, superPotions);
		Thread tgamePlay = new Thread(gamePlay);
		tgamePlay.start();
	}
	
	
	public void nextlevel(){
		if ( level < levelmax){
			setLevel(level+1);
		}
		else {
			endGamePlay();
			}
		}
	
	public GamePlay getGamePlay() {
		return gamePlay;
	}
	

	public void endGamePlay() {
		gamePlay = null;
	}
	
	public List<ICreature> generateOpponents(int level){
		// Recevoir en argument le niveau et adaper la liste en conséquence?
		List<ICreature> opp = null;
		switch (level)
		{
		case 1:
			List<ICreature> opponents = new ArrayList<ICreature>();
			opponents.add(new Vermine(350,200));
			opponents.add(new Vermine(200,50));
			opp = opponents;
			break;
		case 2:
			List<ICreature> opponents2 = new ArrayList<ICreature>();
			opponents2.add(new Vermine(100, 250));
			opponents2.add(new Ogre(150,150));
			opponents2.add(new Ogre(50,200));
			opp = opponents2;
			break;
		}
		return opp;
		
	}
	
	public List<IHero> generateChallengers(){
		List<IHero> challengers = new ArrayList<IHero>();
		challengers.add(new Hero());
		challengers.add(new Hero());
		return challengers;
	}
	
	public List<IPotion> generatePotions(){
		List<IPotion> potions = new ArrayList<IPotion>();
		potions.add(new Potion());
		potions.add(new Potion());
		return potions;
	}
	
	public List<IPotion> generateSuperPotions(){
		List<IPotion> superPotions = new ArrayList<IPotion>();
		superPotions.add(new SuperPotion());
		return superPotions;
	}
	
	public List<ICreature> getCreatures(){
		return monsters;
	}
	public List<IPotion> getPotions(){
		return potions;
	}
	public List<IPotion> getSuperPotions(){
		return superPotions;
	}
	public List<IHero> getHeros(){
		return heros;
	}
}
