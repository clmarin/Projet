package controller.listener;

import java.awt.event.*;
import java.util.List;

import view.*;
import model.*;

public class HeroListener implements KeyListener {
	
	private Game game;
	private GamePlay gamePlay;
	private Interface inter;
	private BoardGame boardgame;
	private GameBoard carte; 
	private int inthero;
	private Rencontre renc;
	//private List<IHero> heros;
	//private List<ICreature> creatures;
	
	public HeroListener(Game game, Interface inter, BoardGame boardgame) {
		this.game = game;
		this.gamePlay = game.getGamePlay();
		this.inter = inter;
		this.boardgame = boardgame;
	}
	
	public void keyPressed(KeyEvent touche) {
		/*/List<IHero> heros = game.getHeros();
		List<ICreature> creatures = game.getCreatures();
		if (renc.rencontre(heros, creatures)){
			inter.changePanel("ARENA");
			gamePlay.setState("arena");
		}/*/
		
		inthero = gamePlay.getintHero();
		switch(touche.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			game.endGamePlay();
			inter.changePanel("MENU");
			break; //Pourquoi ?
		case KeyEvent.VK_P:
			gamePlay.setPaused();
			boardgame.draw();
			break;
		case KeyEvent.VK_I:
			gamePlay.setInformation();
			boardgame.draw();
			break;
		case KeyEvent.VK_1:  
			gamePlay.setintHero(-1);
			break; 
		case KeyEvent.VK_2:
			gamePlay.setintHero(+1);
			break;
		//HERO
		case KeyEvent.VK_RIGHT:
			gamePlay.getHero().get(inthero).varPosXX(1); 
			break;
		case KeyEvent.VK_LEFT:
			// c'est pas trop lourd?
			/*/for (int i=1;i<carte.getWidth();i++){
				if (carte.isEmpty(i, gamePlay.getHero().getpositionY()) ){
				change position
				if (rencontre )
					gamePlay.gameplay()
					inter.
				}
		}/*/
			gamePlay.getHero().get(inthero).varPosXX(-1); 
			break;
		case KeyEvent.VK_UP:
			gamePlay.getHero().get(inthero).varPosY(-1); 
			break;
		case KeyEvent.VK_DOWN:
			gamePlay.getHero().get(inthero).varPosY(1);
			break;
		//}
		}
}

	public void keyReleased(KeyEvent arg0) {
		gamePlay.getHero().get(inthero).varPosXX(0); 
		gamePlay.getHero().get(inthero).varPosY(0);
	}
	

	public void keyTyped(KeyEvent touche) {
	}

}
