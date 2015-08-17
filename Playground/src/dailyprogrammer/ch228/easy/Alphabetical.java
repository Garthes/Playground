/**
 * 
 */
package dailyprogrammer.ch228.easy;

import java.util.Scanner;

/**
 * @author Gerrit
 *
 */
public class Alphabetical {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word;
		System.out.println("Input any word. empty to close");
		while (true) {
			word = sc.nextLine();
			if (word.equals("")){
				break;
			}

			switch(order(word)){
			case -1:
				System.out.println(word + " REVERSE ORDER");
				break;
			case 0:
				System.out.println(word + " NOT IN ORDER");
				break;
			case 1:
				System.out.println(word + " IN ORDER");
				break;
			}
		}

		sc.close();
	}

	public static int order(String word) {
		boolean reverse = true;
		boolean forward = true;
		
		word = word.toLowerCase();
		int pValue = word.charAt(0);
		for (char c : word.toCharArray()) {
			if (pValue > c) {
				forward = false;
			}
			if (pValue < c) {
				reverse = false;
			}
			pValue = c;
		}
		
		return forward ? 1 : (reverse ? -1 : 0);
	}

}
