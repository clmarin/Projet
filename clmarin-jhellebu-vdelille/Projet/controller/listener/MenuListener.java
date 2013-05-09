package controller.listener;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;


import model.*;
import view.*;
// Permet aux boutons de fonctionner et leur dis quoi faire
public class MenuListener implements ActionListener {

	private Game game;
	private Interface inter;
	private JButton b1;
	private JButton b2;
	
	public MenuListener(Game game, Interface inter, JButton b1, JButton b2) {
		this.game = game;
		this.inter = inter;
		this.b1 = b1;
		this.b2 = b2;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == b2){
			game.setLevel(1);
			game.getGamePlay().addgamePlayObserver(controller.Main.main); 
			inter.ConstructGame();
			inter.changePanel("GAMEPLAY");
		}
		else if (arg0.getSource() == b1) {
			inter.changePanel("RULES");
		}
	}

}
