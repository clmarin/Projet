package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// Affiche le jeu!
public class GameBoard {
	private int width;
	private int height;
	private List<Map<Integer, IBoardPiece>> board;

	public GameBoard(int width, int height) {
		this.width = width;
		this.height = height;
		this.board = new ArrayList<Map<Integer, IBoardPiece>>();
		for(int i = 0; i < width; i++) {
			this.board.add(new HashMap<Integer, IBoardPiece>());
		}
	}
	

	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public boolean isEmpty(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) {
			throw new RuntimeException(String.format("Invalid location (%d, %d)", x, y));
		}
		return !this.board.get(x).containsKey(y);
	}

	public void put(IBoardPiece p, int x, int y) {
		this.board.get(x).put(y, p);
	}
	
	public IBoardPiece get(int x, int y) {
		return this.board.get(x).get(y);
	}
	
	public void delete(int x, int y) {
		this.board.get(x).remove(y);
	}
}
