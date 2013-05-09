package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.listener.RulesListener;

import view.Interface;
// Gere la fenetre "rules" qui est juste une image + 1 bouton
public class Rules extends JPanel {
	
	private Image image = Toolkit.getDefaultToolkit().getImage("rules.jpg");
	private JButton bouton;

	public Rules (Interface inter){
		bouton = new JButton("Retour");
		
		RulesListener rulesListener = new RulesListener(inter);		
		bouton.addActionListener(rulesListener);
		
		bouton.setBounds(120, 210, 160, 28);
		this.add(bouton);
		this.setFocusable(true);
		this.setLayout(null);
	}
	
	public void paintComponent(Graphics g){
	     // super.paintComponent(g); // ça marche sans ça
	        if (image != null) {
	            int height = this.getSize().height;
	            int width = this.getSize().width;          
	            g.drawImage(image,0,0, width, height, this);
	}
}
}
