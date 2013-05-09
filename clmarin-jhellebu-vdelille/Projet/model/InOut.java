package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
// Va chercher les infos dans la base de donnée en txt et crée la carte
public class InOut {

	
	public static GameBoard LireCarte(String filename) throws IOException {
		FileReader file = new FileReader(filename);
		
		ArrayList elements;
		BufferedReader buffer = new BufferedReader(file); 
		String line;
		GameBoard carte;
		IBoardPiece piece = null;
		int i;
		
		elements = new ArrayList();
		carte = new GameBoard(400, 300);
		i = 0;
		while((line = buffer.readLine()) != null) { 
			if ( i == Integer.parseInt(""+line.charAt(0))){
				piece = new Mountain(); // Pour faire correspondre 0 à Mountain
			}
			carte.put( piece,  Integer.parseInt(""+line.subSequence(2,5)) ,  Integer.parseInt(""+line.subSequence(6,9)) );
			//System.out.println(""+line.subSequence(2,5)); TEST
		}
		buffer.close();
		file.close();
		return carte;
	}
}
