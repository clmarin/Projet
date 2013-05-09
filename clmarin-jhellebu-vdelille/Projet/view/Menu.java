package view;

import java.awt.*;

import javax.swing.*; 
import controller.listener.MenuListener;

import model.Game;
// Infos du menu : boutons,...
public class Menu extends JPanel {
	
	private JButton b1;
	private JButton b2;
	private Image background = Toolkit.getDefaultToolkit().getImage("ouverture.jpg");
	
	public Menu(Game game, Interface inter){
		JButton b1 = new JButton("Rules");
		JButton b2 = new JButton("New Game");
		MenuListener menuListener = new MenuListener(game, inter, b1, b2);
		b1.addActionListener(menuListener);
		b2.addActionListener(menuListener);
		
		b1.setBounds(75, 75, 110, 56);
		b2.setBounds(75, 140, 110, 56);
		this.setLayout(null); // cest ce qui fait marcher les setbounds
	   	this.add(b1);
	   	this.add(b2);
		this.setFocusable(true);
	}
	

	public void paintComponent(Graphics g){
		g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
	}

}
