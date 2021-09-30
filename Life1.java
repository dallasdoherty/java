package gameoflife;

import java.util.Arrays;

public class Life1 {

	public static boolean[] makeCells(int n, boolean value) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		boolean[] cells = new boolean[n];
		Arrays.fill(cells, value);
		return cells;
	}
	
	
	public static void printCells(boolean[] cells) {
		for (boolean c : cells) {
			if (c) {
				System.out.print("#");
			}
			else {
				System.out.print("-");
			}
		}
		System.out.println();
	}
	
	// continue translating life1.py here
	
	public static boolean[] getSlice(boolean[] cells, int startIndex, int endIndex) {
		boolean[] slicedCells = new boolean[endIndex - startIndex];
		for (int i = 0; i < slicedCells.length; i++) {
			slicedCells[i] = cells[startIndex + i];
		}
		return slicedCells;
	}
	
	public static boolean[] neighborhood(boolean[] cells, int index) {
		if (index < 0) {
		 throw new IllegalArgumentException();
	}
	boolean[] slc = getSlice(cells, (Math.max(0,  index - 2)), (Math.min(index + 3, cells.length)));
	return slc;
}
	public static boolean isAlive(boolean[] cells, int index) {
		if (index < 0) {
			throw new IllegalArgumentException();
		}
		return cells[index];
		}
	
	public static int trueCounter(boolean[] cells) {
		int counter = 0;
		for (int i= 0; i< cells.length; i++) {
			if (cells[i] == true) {
				counter++;
			}
		}
		return counter;
		
	}
	
	
	public static boolean isBorn(boolean[] cells, int index) {
		if (index < 0) {
			throw new IllegalArgumentException();
		}
		if (isAlive(cells, index)) {
			return false;
		}
		boolean[] slc = neighborhood(cells, index);
		int neighbors = trueCounter(slc);
		return neighbors == 2 || neighbors == 3;
		}
	
	public static boolean survives(boolean[] cells, int index) {
		if (index < 0) {
			throw new IllegalArgumentException();
		}
		if (! isAlive(cells, index)) {
			return false;
		}
		boolean[] slc = neighborhood(cells, index);
		int neighbors = trueCounter(slc) - 1;
		return neighbors == 2 || neighbors ==4;
}
	
	public static void evolve(boolean[] cells) {
		if (cells.length == 0){
			throw new IllegalArgumentException();
		}
		boolean[] tmp = getSlice(cells, 0, cells.length);
		for (int i = 0; i < cells.length; i++ ) {
			if (isAlive(tmp, i)) {
				if (!survives(tmp,i)) {
					cells[i] = false;
				}
			}
			else {
				if (isBorn(tmp,i)) {
					cells[i] = true;
				}
				}
	}
	
}
}

	
	
