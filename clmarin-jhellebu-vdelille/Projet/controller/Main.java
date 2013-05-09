package controller;
// Fenetre principale qui déclenche tout le jeu

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import javax.swing.*;
import model.*;
import view.*;

public class Main implements Observer ,ActionListener {

	public static Main main;
	private Interface inter;
	private Game game;

	public static void main(String[] args){
		main = new Main();
	}
	
	public Main() {
		game = new Game();
		inter = new Interface(game);
	}

	public void nextlevel(){ 
		if (game.getGamePlay().getCreature()==null){
			game.nextlevel();
			inter.ConstructGame();
			inter.changePanel("GAMEPLAY");
		}
	}
	
	public void controlState(){
		if(game.getGamePlay().getState()=="arena"){
			inter.ConstructArena();
			inter.changePanel("ARENA");
		}
		if (game.getGamePlay().getState()=="map"){
			inter.changePanel("GAMEPLAY");
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

	
	
}
