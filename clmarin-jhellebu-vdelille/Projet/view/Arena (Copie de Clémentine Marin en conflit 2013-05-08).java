package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.*;
import controller.*;
import controller.listener.*;

public class Arena extends JPanel implements InterfaceObserver{
	
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private Image background = Toolkit.getDefaultToolkit().getImage("arena.jpg");
	private ICreature creature;
	private IHero hero;
	private List<IHero> heros;
	private List<ICreature> creatures;
	private Rencontre rencontre;
	private GamePlay gamePlay;
	
	public Arena(Game game, Interface inter){
		List<IPotion> potions = gamePlay.getPotion();
		List<IPotion> superPotions = gamePlay.getSuperPotion();
		int size1 = potions.size();
		int size2 = superPotions.size();
		String nombre = String.valueOf(size1);
		String nombre2 = String.valueOf(size2);
		JButton b1 = new JButton("Attaque");
		JButton b2 = new JButton("Potion (" + nombre + ")");
		JButton b3 = new JButton("Superpotion (" + nombre2 + ")");
		JButton b4 = new JButton("Fuire");
		ArenaListener arenaListener = new ArenaListener(game, inter, b1, b2, b3, b4);
		b1.addActionListener(arenaListener);
		b2.addActionListener(arenaListener);
		b3.addActionListener(arenaListener);
		b4.addActionListener(arenaListener);
		
		b1.setBounds(320, 75, 80, 56);
		b2.setBounds(320, 140, 80, 56);
		b3.setBounds(320, 30, 80, 56);
		b4.setBounds(320, 160, 80,56);
		this.setLayout(null); 
	   	this.add(b1);
	   	this.add(b2);
	   	this.add(b3);
	   	this.add(b4);
		this.setFocusable(true);
		// get.creature
		// get.hero
		// get inventory
	}
	
	public void draw() {
	    repaint();
	}
	
	
	public void paintComponent(Graphics g){
		drawHero(g);
		drawCreature(g);
		g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
		Font font = new Font("Courier", Font.BOLD, 20); //(ecriture, bold/italic/..., taille police
		g.setFont(font);
		g.setColor(Color.red);
		String PVCreature = String.valueOf(creature.getLife()); 
		String PVHero = String.valueOf(hero.getLife());
		g.drawString("Points de Vie :" + PVCreature, 5, 5);
		g.drawString("points de Vie :" + PVHero, 165, 5);
	}

	public void drawCreature(Graphics g){
		this.creature = rencontre.Monster(heros, creatures);
		Graphics2D g2d=(Graphics2D)g; 
		g2d.drawImage(creature.getSkin(), 100, 150, this);
				
	}
	
	public void drawHero(Graphics g){
		int ind = rencontre.indexHero(heros, creatures);
		this.hero = heros.get(ind);
		Graphics2D g2d=(Graphics2D)g; 
		g2d.drawImage(hero.getSkin(), 200, 150, this);
	}

}
