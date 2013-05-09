package model;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import java.util.Random;

public class Chaos implements ICreature {
	
	//LE BIG MECHANT BOSS
	
	private int life = 200;
	private Image skin = Toolkit.getDefaultToolkit().getImage("chaos.gif");
	private int positionX;
	private int positionY;
	private Random random;
	private Knife knife;
	private Sword sword;
	private Arch arch;
	
	public Chaos(int positionX, int positionY){
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
        if (this.life > 200) {
            this.life = 200;
        }
	}
	
	
    @Override
    public void receiveHealing() {
        this.life = 200;
    }

	@Override
	public boolean isAlive() {
		return this.life > 0;
	}
	
	public String giveWeapon (Hero opponent, List weapons){
		this.random = new Random();
		int rand2 = this.random.nextInt(5);
		String weapon = null;
		if (rand2 < 2){
			weapons.add("Couteau");
			weapon = "Couteau";
			knife.giveWeaponExp(opponent);
		}
		if (rand2 > 1 || rand2 <4){
			weapons.add("Epee");
			weapon = "Epee";
			sword.giveWeaponExp(opponent);
		}
		if (rand2 > 3 || rand2 < 5){
			weapons.add("Arc");
			weapon = "Arc";
			arch.giveWeaponExp(opponent);
		}
		return weapon;
	}
	
	public void givePotion (Hero opponent, List<IPotion> potions){
		this.random = new Random();
		int rand3 = this.random.nextInt(5);
		if (rand3 <3){
			potions.add(new Potion());
		}
		else {
			potions.add( new SuperPotion());
		}
	}
	

	@Override
	public void attack(IHero opponent) {
		opponent.receiveExp(10);
		this.random = new Random();
		int rand1 = this.random.nextInt(30);
		receiveHealing(rand1);          // La creature recupere entre 0 et 30 points de vie points vie a chaque tour
		this.random = new Random();
		int rand2 = this.random.nextInt(10);
		if (rand2<1){
			opponent.receiveDamage(50);
			//1 chance sur 10 de recevoir de gros degats
		}
		if (rand2>0 || rand2<5){
			opponent.receiveDamage(30);
			//4 chances sur 10 de recevoir de moyens degats
		}
		if (rand2>4 || rand2<9){
			opponent.receiveDamage(20);
			//4 chances sur 10 de recevoir de petits degats
		}
		else{
			opponent.receiveDamage(0);
			//1 chance sur de 10 de ne pas recevoir de degat
		}
		
	}

}
