import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class No96 {

	public static int sum = 0;
	public static int[][] feld = new int[9][9];
	public static Scanner sc;

	public static void main(String[] args) {
		try {
			sc = new Scanner(new File("sudoku.txt"));
			while(sc.hasNext()) {
				String s = readNextSudoku();
				createSudoku(s);
				writeMatrix(feld);
				solve(0, 0, feld);
				writeMatrix(feld);
				sumNumbers();
			}
			System.out.println(sum);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void sumNumbers() {
		sum+=feld[0][0]*100+feld[0][1]*10+feld[0][2];
	}


	public static String readNextSudoku() {
		String line;

		line=sc.nextLine();
		line="";
		for(int i=0; i<9; i++) {
			line+=sc.nextLine();
		}
		return line;
	}

	public static void createSudoku(String s) {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				feld[i][j]=Integer.parseInt(s.substring(j+(i*9), j+1+(i*9)));
			}
		}
	}	

	static boolean solve(int i, int j, int[][] cells) {
		if (i == 9) {
			i = 0;
			if (++j == 9)
				return true;
		}
		if (cells[i][j] != 0)  // skip filled cells
			return solve(i+1,j,cells);

		for (int val = 1; val <= 9; ++val) {
			if (legal(i,j,val,cells)) {
				cells[i][j] = val;
				if (solve(i+1,j,cells))
					return true;
			}
		}
		cells[i][j] = 0; // reset on backtrack
		return false;
	}

	static boolean legal(int i, int j, int val, int[][] cells) {
		for (int k = 0; k < 9; ++k)  // row
			if (val == cells[k][j])
				return false;

		for (int k = 0; k < 9; ++k) // col
			if (val == cells[i][k])
				return false;

		int boxRowOffset = (i / 3)*3;
		int boxColOffset = (j / 3)*3;
		for (int k = 0; k < 3; ++k) // box
			for (int m = 0; m < 3; ++m)
				if (val == cells[boxRowOffset+k][boxColOffset+m])
					return false;

		return true; // no violations, so it's legal
	}

	static void writeMatrix(int[][] solution) {
		for (int i = 0; i < 9; ++i) {
			if (i % 3 == 0)
				System.out.println(" -----------------------");
			for (int j = 0; j < 9; ++j) {
				if (j % 3 == 0) System.out.print("| ");
				System.out.print(solution[i][j] == 0
						? " "
								: Integer.toString(solution[i][j]));

				System.out.print(' ');
			}
			System.out.println("|");
		}
		System.out.println(" -----------------------");
	}
}
