package model;

import java.util.ArrayList;
import java.util.List;

import controller.Observer;

import view.Interface;
import view.InterfaceObservable;
import view.InterfaceObserver;

import model.*; 
//Contient et manipule tous les éléments du niveau

public class GamePlay implements InterfaceObservable, Runnable, GamePlayObservable{
	
	private static boolean paused;
	private static boolean information;
	private ArrayList<InterfaceObserver> observerList = new ArrayList<InterfaceObserver>(); 
	private ArrayList<Observer> observer2List = new ArrayList<Observer>(); 
	private GameBoard carte;
	private List<ICreature> monsters;
	private  List<IHero> heros;
	private List<IPotion> potions;
	private List<IPotion> superPotions;
	private String gameState= "map";
	private Interface inter;
	private Tournament tournament;
	private int inthero =0;
	private int intindexcreature;
	private int intindexhero;
	private boolean bool;
	
	public GamePlay(GameBoard carte,  List<IHero> heros, List<ICreature> monsters, List<IPotion> potions, List<IPotion> superPotions){
		this.carte=carte;
		this.heros = heros;
		this.monsters=monsters;
		this.potions = potions;
		this.superPotions = superPotions;
		
	}
	// Mise à jour
	public void run(){
		while (true){
			if (gameState=="map"){
				for (int i = 0; i< heros.size(); i++){
					heros.get(i).hero(); 
				}
				if (rencontre(heros, monsters)){
						setState("arena");
				}
			}
			if (gameState=="arena"){
				/*/if (tournament.finish()){
					
				}/*/
			}
			
			this.prevenirInterfaceObserver();
			try {
				Thread.sleep(40); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	// Renvoi des éléments
	public GameBoard getCarte() {
		return carte;
	}
	public List<IHero> getHero() {
		return heros;
	}
	public int getintHero() {
		return inthero;
	}
	public int getintindexHero() {
		return intindexhero;
	}
	public int getintindexCreature() {
		return intindexcreature;
	}
	public List<ICreature> getCreature() {
		return monsters;
	}
	public List<IPotion> getPotion(){
		return potions;
	}
	public List<IPotion> getSuperPotion(){
		return superPotions;
	}
	public String getState(){
		return gameState;
	}
	// Modifications
	
	public void setState(String gameState){
		this.gameState=gameState;
		this.prevenirgamePlayObserver();
	}
	public void setintHero(int varhero){ 
		if(inthero+varhero > heros.size()-1){
			System.out.println("trop grand"); //marche pas ici
			inthero=0;
		}
		if(inthero+varhero<0){
			System.out.println("trop petit");
			inthero= heros.size()-1;
		}
		else {
			inthero= inthero+varhero;
		}
		prevenirInterfaceObserver();
	}
	// rencontre
	
	public boolean rencontre(List<IHero> heros, List<ICreature> opponents){
		bool = false;
		for ( int j = 0 ; j < heros.size() ; j++) {
			IHero hero = heros.get(j);
			for (int i=0 ; i<opponents.size() ; i++){
				ICreature creature = opponents.get(i);
				if ( Math.sqrt(  Math.pow(hero.getpositionX()- creature.getPositionX(),2)+  Math.pow(hero.getpositionY()- creature.getPositionY(),2) )<15){
					bool = true;
					intindexhero=i;
					intindexcreature=j;
				}
		}
		}
		return bool;
	}
	//Pause-Information
	
	public static boolean isPaused() {
		return paused;
	}
	
	public void setPaused() {
		GamePlay.paused = !GamePlay.paused;
	}
	
	public static boolean isInformation(){
		return information;
	}
	
	public void setInformation(){
		GamePlay.information = !GamePlay.information;
	}
	
	// observer
	
	public void addInterfaceObserver(InterfaceObserver obs) {
		this.observerList.add(obs);
	}
	public void prevenirInterfaceObserver() {
		for(InterfaceObserver obs : this.observerList){
			obs.draw();
		}
	}
	public void addgamePlayObserver(Observer obs) {
		this.observer2List.add(obs);
		System.out.println("add maintenant la liste contient "+this.observer2List.size());
	}
	
	public void prevenirgamePlayObserver() {
		for(Observer obs : this.observer2List){
			obs.controlState();
		}
		
	}
	
	
	
}
