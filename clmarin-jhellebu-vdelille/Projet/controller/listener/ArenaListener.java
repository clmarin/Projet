package controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import model.*;
import view.Interface;

public class ArenaListener implements ActionListener {
	private Game game;
	private Interface inter;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private Hero hero;
	private ICreature creature;
	private Tournament tournament;
	private Potion pot;
	private SuperPotion superPot;
	private List<IPotion> potions;
	private List<IPotion> superPotions;
	

	public ArenaListener(Game game, Interface inter, JButton b1, JButton b2, JButton b3, JButton b4){
		this.game = game;
		this.inter = inter;
		this.b1 = b1;
		this.b2 = b2;
		this.b3 = b3;
		this.b4 = b4;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == b1){
			tournament.fight(hero, creature);
		}
		
		else if (arg0.getSource() == b2) {
			pot.giveHealing (hero, potions);
		}
		
		else if (arg0.getSource()==b3){
			superPot.giveHealing (hero, superPotions);
		}
		
		else if (arg0.getSource() == b4){
			if (tournament.escape(hero)){
				inter.changePanel("GAMEPLAY");
			}
			else {
				creature.attack(hero);
			}
		}
	}
}
