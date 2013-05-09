package model;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.imageio.ImageIO;

// Un element du decor

public class Mountain implements IBoardPiece {
	private Image Skin = Toolkit.getDefaultToolkit().getImage("mountain.gif");
	boolean obstacle = true;
	
	public Mountain() {
		
	}

	public Image getSkin() {
		return Skin;
	}

	public boolean getObstacle() {
		return obstacle;
	}
}
	
