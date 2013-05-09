package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.*;
import model.*;
import controller.*;

public class BoardGame extends JPanel implements InterfaceObserver{

	private GameBoard carte;
	private GamePlay gamePlay;
	private IHero hero;
	private List<ICreature> creatures;
	private ICreature creature;
	
	int height;
	int width;
	int life;
	int hposX;
	int hposY;
	int mposX;
	int mposY;
	int inthero;
	
	private Image image;
	private Image background = Toolkit.getDefaultToolkit().getImage("background.jpg");
	private Image imgPause = Toolkit.getDefaultToolkit().getImage("pause.jpg");
	
	public BoardGame(GamePlay gamePlay){
		this.gamePlay = gamePlay;
		gamePlay.addInterfaceObserver(this);
		this.setFocusable(true);
		/*/
		heros = gamePlay.getHero();
		for (int i = 0; i< heros.size(); i++){
			heros.get(i).addInterfaceObserver(this); 
		}
		/*/
		
	}
	
	public void draw() {
	    repaint();
	}
	
	// Dessine 
	public  void  paintComponent(Graphics g){
		Graphics2D g2d=(Graphics2D)g;
		super.paintComponent(g);
		carte = gamePlay.getCarte(); 
		width = carte.getWidth();
		height =  carte.getHeight();
		if (GamePlay.isInformation()){
			
			g.drawImage(background, 0, 0, width ,height, this);
			Font font = new Font ("Arial", Font.BOLD, 20);
			g.setFont(font);
			g.setColor(Color.blue);
			
			List<IHero> heros = gamePlay.getHero();
			IHero hero1 = heros.get(0);
			IHero hero2 = heros.get(1);
			String name1 = hero1.getName();
			String name2 = hero2.getName();
			String PV1 = String.valueOf(hero1.getLife());
			String PV2 = String.valueOf(hero2.getLife());
			String exp1 = String.valueOf(hero1.getExp());
			String exp2 = String.valueOf(hero2.getExp());
			String wExp1 = String.valueOf(hero1.getWeaponExp());
			String wExp2 = String.valueOf(hero2.getWeaponExp());
			
			g.drawString(name1, 160, 5);
			g.drawString(name2, 240, 5);
			g.drawString("points de Vie", 5, 25);
			g.drawString(PV1, 160, 25);
			g.drawString(PV2, 240, 25);
			g.drawString("Expérience", 5, 45);
			g.drawString(exp1, 160, 45);
			g.drawString(exp2, 240, 45);
			g.drawString("Points d'armes", 5, 65);
			g.drawString(wExp1, 160, 65);
			g.drawString(wExp2, 240, 65);
		}
		g.drawImage(background, 0, 0, width ,height, this);
		drawMap(g);
		drawHero(g);
		drawCreatures(g);
		if( GamePlay.isPaused() ){ 
			g.drawImage(imgPause, 0, 0, width , height, this);
		}	
	}


	// Dessine le hero
	public  void  drawHero(Graphics g){
		Graphics2D g2d=(Graphics2D)g; 
		for (int i = 0; i< gamePlay.getHero().size(); i++){
			hero=gamePlay.getHero().get(i);
			hposX = hero.getpositionX()-hero.getSkin().getWidth(this)/2; 
			hposY= hero.getpositionY()-hero.getSkin().getHeight(this)/2;
			g2d.drawImage(hero.getSkin(), hposX, hposY, this);
			g.setColor(Color.YELLOW);
			life = hero.getLife()/4;
			g.fillRect(hposX, hposY -10, life, 10);
		}
		
	}
	
	// Dessine les creatures
	public void drawCreatures(Graphics g){
		Graphics2D g2d=(Graphics2D)g; 
		creatures = gamePlay.getCreature(); 
		for (int i = 0; i< creatures.size(); i++){
			creature=creatures.get(i);
			g2d.drawImage(creature.getSkin(), creature.getPositionX()-creature.getSkin().getWidth(this)/2,  creature.getPositionY()-creature.getSkin().getHeight(this)/2, this);
			}	
	}
	
	public void drawMap(Graphics g){
		for(int i=1;i<width;i++){
			for(int j=1;j<height;j++) {
				if (carte.isEmpty(i,j)==false) { 
					mposX=i-carte.get(i,j).getSkin().getWidth(null)/2;
					mposY=j-carte.get(i,j).getSkin().getHeight(null)/2;
					image = carte.get(i,j).getSkin();
					g.drawImage(image, mposX, mposY, this);
				}
			}
		}
	}
	
	
}
