package model;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;



public class Ogre implements ICreature {
	
	// plus difficile que la vermine, mais reste facile
	
	private int life = 20;
	private Image skin = Toolkit.getDefaultToolkit().getImage("greenogre.gif");
	private int positionX;
	private int positionY;
	private Random random;
	
	public Ogre (int positionX, int positionY){
		this.positionX = positionX;
		this.positionY = positionY;		
	}

	
	//renvoie des donnees
	
	public Image getSkin() {
		return skin;
	}

	public int getLife(){
		return life;
	}
	
	public int getPositionX(){
		return positionX;
	}
	
	public int getPositionY(){
		return positionY;
	}


	
	//actions possibles
	
	@Override
	public void receiveDamage(int damages) {
		this.life -= damages;
	}

	@Override
	public void receiveHealing(int healing) {
		this.life += healing;
        if (this.life > 20) {
            this.life = 20;
        }
	}
	
	
    @Override
    public void receiveHealing() {
        this.life = 20;
    }

	@Override
	public boolean isAlive() {
		return this.life > 0;
	}
	

	
	
	public void receiveWeapon(){
		
	}

	@Override
	public void attack(IHero opponent) {
		opponent.receiveExp(3);
		this.random = new Random();
		int rand = this.random.nextInt(10);
		opponent.receiveDamage(rand);          //peut etre modifi� pour rendre le jeu plus dur/facile
	}

}

