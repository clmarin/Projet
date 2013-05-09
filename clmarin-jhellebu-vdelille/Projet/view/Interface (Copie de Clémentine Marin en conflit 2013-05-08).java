package view;

import java.awt.*;
import java.awt.event.*; 
import java.io.IOException;
import java.util.List;

import javax.swing.*;

import controller.Observer;
import controller.listener.*;
import model.*;
public class Interface  {
	
	private JFrame window;
	private Menu menu;
	private Rules rules;
	private JPanel cards;
	private CardLayout card;
	private BoardGame boardgame;
	private Game game;
	private GamePlay gamePlay;
	private Arena arena;
	
	private GameBoard carte;
	private  List<IHero> heros;
	private List<IPotion> potions;
	private List<IPotion> superPotions;
	
// l'interface recoit le jeu et va chercher à partir de là les infos du gamePlay pour gerer le dessin
	
	public Interface(Game game) {
		this.game=game;
		this.potions = game.getPotions();
		this.superPotions = game.getSuperPotions();
		// Window
		window = new JFrame("Blabla");
		window.setSize(400, 300);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
		// Menu + Rules
		rules = new Rules(this);
		menu = new Menu(game, this);	
		//arena
		arena = new Arena(game, this);
		//card
		card = new CardLayout();
		cards = new JPanel(card);
		cards.add(menu, "MENU");
		cards.add(rules, "RULES");
		cards.add(arena, "ARENA");
		cards.setLayout(card);
	    window.getContentPane().add(cards, BorderLayout.CENTER);
	}
	
	
	public  void ConstructGame(){
		this.gamePlay = game.getGamePlay();
		carte = gamePlay.getCarte(); 
		heros = gamePlay.getHero();
		
		boardgame = new BoardGame(gamePlay);
		HeroListener heroListener = new HeroListener(game, this, boardgame);
		boardgame.addKeyListener(heroListener); 
		cards.add(boardgame, "GAMEPLAY");
	}
		
	public void changePanel(String sen) {
		card.show(cards, sen);
		if(sen == "GAMEPLAY"){
			boardgame.requestFocus();
		}
		if ( sen ==  "ARENA"){
			arena.requestFocus();
		}
			
		else if(sen == "RULES"){
			rules.requestFocus();
			}
	}
}


