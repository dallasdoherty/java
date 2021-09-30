package gameoflife;

public class ExLife1 {

	public static void main(String[] args) {
		boolean[] cells = Life1.makeCells(50, false);
		String s = "---##--##---####------####------#---#-#---#-#-#--#";

		// continue translating ex_life1.py here
		
		char target = '#';{
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(c == target) {
					cells[i] = true;
				}
			}
		}
				
		Life1.printCells(cells);
		int[] range = range(0,30);
		for (int j = 0; j < range.length; j++) {
			Life1.evolve(cells);
			Life1.printCells(cells);
		}
	}
		
	public static int[] range(int start, int length)
	{
		int[] range = new int[length - start + 1];
		
		for (int i= start; i <= length; i++)
			range[i - start] = i;
		
		return range;
	}

}
