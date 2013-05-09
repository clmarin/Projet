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

public class Main implements Observer,ActionListener {

	public static Main main;
	private Interface inter;
	private Game game;

	public Main() {
		game = new Game();
		game.setLevel(1);
		inter = new Interface(game);
	}

	public static void main(String[] args){
		main = new Main();
	}

	public void nextlevel(){ 
		game.nextlevel();
		inter.ConstructGame();
		inter.changePanel("GAMEPLAY");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
