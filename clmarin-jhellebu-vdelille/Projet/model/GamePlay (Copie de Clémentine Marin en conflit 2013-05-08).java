package model;

import java.util.ArrayList;
import java.util.List;

import view.InterfaceObservable;
import view.InterfaceObserver;

import model.*; 
//Contient et manipule tous les éléments du niveau

public class GamePlay implements InterfaceObservable, Runnable{
	
	private static boolean paused;
	private static boolean information;
	private ArrayList<InterfaceObserver> observerList = new ArrayList<InterfaceObserver>(); 
	private GameBoard carte;
	private List<ICreature> monsters;
	private  List<IHero> heros;
	private int inthero = 0;
	private List<IPotion> potions;
	private List<IPotion> superPotions;
	
	public GamePlay(GameBoard carte,  List<IHero> heros, List<ICreature> monsters, List<IPotion> potions, List<IPotion> superPotions){
		this.carte=carte;
		this.heros = heros;
		this.monsters=monsters;
		this.potions = potions;
		this.superPotions = superPotions;
		// if rencontre (list hero, list icreature) { tournament(ce hero, ce monstre)}
		
		// même chose avec des objets? inventoru.add(..)
		
	}
	// Mise à jour
	public void run(){
		while (true){
			for (int i = 0; i< heros.size(); i++){
				heros.get(i).hero(); 
			}
			
			this.prevenirInterfaceObserver();
			try {
				Thread.sleep(75); // bon c'est hyper lent
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
	public List<ICreature> getCreature() {
		return monsters;
	}
	public List<IPotion> getPotion(){
		return potions;
	}
	public List<IPotion> getSuperPotion(){
		return superPotions;
	}
	
	// changer de hero
	public void setintHero(int inthero){
		this.inthero = inthero;
		prevenirInterfaceObserver();
	}
	//Pause
	public static boolean isPaused() {
		return paused;
	}
	
	public void setPaused() {
		GamePlay.paused = !GamePlay.paused;
	}
	
	/*/public static boolean isInformation(){
		return information;
	}
	
	public void setInformation(){
		GamePlay.information = !GamePlay.information;
	}
	/*/
	// observer
	//Ajoute un observateur à la liste
	public void addInterfaceObserver(InterfaceObserver obs) {
		this.observerList.add(obs);
	}
	public void prevenirInterfaceObserver() {
		//Avertit les observateurs que l'objet observable a changé 
		for(InterfaceObserver o : this.observerList){
			o.draw();
		}
	}
	
}
