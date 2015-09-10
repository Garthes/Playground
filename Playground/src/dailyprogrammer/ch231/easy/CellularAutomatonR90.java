package dailyprogrammer.ch231.easy;

import java.util.Scanner;

public class CellularAutomatonR90 {

	int[] cells;
	int last;

	public CellularAutomatonR90(String cells) {
		this.cells = new int[cells.length()];
		for (int i = 0; i < cells.length(); i++) {
			this.cells[i] = cells.charAt(i) - 48;
		}
		this.last = cells.length() - 1;
	}

	public void step() {
		int[] newCells = new int[this.cells.length];
		for (int i = 0; i < this.cells.length; i++) {
			newCells[i] = rule90(i) ? 1 : 0;
		}
		this.cells = newCells;
	}

	private boolean rule90(int index) {
		if (index == 0 && cells[1] == 1) {
			return true;
		}
		if (index == last && cells[last - 1] == 1) {
			return true;
		}
		if (index != 0 && index != last) {
			if (cells[index - 1] == 1 ^ cells[index + 1] == 1) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int c : cells) {
			if (c == 0) {
				sb.append(' ');
			} else {
				sb.append('X');
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CellularAutomatonR90 aut;
		String cells = "0001000";
		int steps = 2;
		
		System.out.println("StartPattern: ");
		while(!sc.hasNext("[01]+")){
			System.out.println("invalid pattern try again: ");
			sc.nextLine();
		}
		cells = sc.next("[01]+");
		System.out.println("How Many Steps? ");
		while(!sc.hasNextInt()){
			System.out.println("Not a number try again: ");
			sc.nextLine();
		}
		steps = sc.nextInt();
		sc.close();
		
		aut = new CellularAutomatonR90(cells);

		System.out.println(aut);
		for (int i = 0; i < steps; i++) {
			aut.step();
			System.out.println(aut);
		}

	}

}
