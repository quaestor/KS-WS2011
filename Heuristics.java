//
// Copyright © 2011 by Bjørn Zenker
//
import java.util.Comparator;


public class Heuristics {

	/**
	 * Heuristik: Anzahl der falsch besetzten Felder
	 * 
	 * @param p n-Puzzle
	 * @return
	 */
	public static int h1(NPuzzle p){

		int h1 = 0;
		
		int[][] m = p.getPuzzle();
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < m.length; j++) {
				if(i < m.length-1 && j < m.length -1) {
					h1 += m[i][j] == (i*m.length+j)+1 ? 0 : 1;
				}
				else {
					h1 += m[i][j] == NPuzzle.EMPTY ? 0 : 1;
				}
			}
		return h1;
	}
	
	/**
	 * Heuristik: Summe der Manhattan-Entfernungen von falsch besetzten Felden zu deren Zielposition
	 * 
	 * @param p n-Puzzle
	 * @return
	 */
	public static int h2(NPuzzle p){

		int h2 = 0;
		int[][] m = p.getPuzzle();
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < m.length; j++) {
				int c = m[i][j];
				if(c == NPuzzle.EMPTY) c = (m.length * m.length);
				h2 += c - 1 - j - (m.length * i);
			}
		return h2;
	}
}
