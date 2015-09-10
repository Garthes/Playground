package dailyprogrammer.ch231.intermidiate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sets {

	public static void main(String[] args) {
		List<String> cards = new ArrayList<>();
		// input
		int inputLines = 12;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < inputLines; i++) {
			cards.add(sc.next());
		}
		sc.close();
		// logic
		List<List<String>> sets = sets(cards.toArray(new String[cards.size()]));
		for (List<String> l : sets) {
			System.out.println(l);
		}
	}

	/**
	 * makes all possible combinations of cards and returns those that are sets
	 */
	public static List<List<String>> sets(String[] cards) {
		List<List<String>> sets = new ArrayList<>();
		int length = cards.length;
		//make all combinations
		for (int i = 0; i < length - 2; i++) {
			for (int j = i + 1; j < length - 1; j++) {
				for (int k = j + 1; k < length; k++) {
					//check if set
					if (isSet(cards[i], cards[j], cards[k])) {
						//add to sets
						List<String> temp = new ArrayList<>();
						temp.add(cards[i]);
						temp.add(cards[j]);
						temp.add(cards[k]);
						sets.add(temp);
					}
				}
			}
		}
		//return sets
		return sets;
	}

	/**
	 * checks if three cards form a set
	 */
	public static boolean isSet(String a, String b, String c) {
		// convert to array for ease of access
		char[] a1 = a.toCharArray();
		char[] b1 = b.toCharArray();
		char[] c1 = c.toCharArray();

		for (int i = 0; i < 4; i++) {
			// if not all equal (a==b==c) or all distinct (a!=b, b!=c, a!=c)
			// return false
			if (!((a1[i] == b1[i] && b1[i] == c1[i]) || (a1[i] != b1[i]
					&& b1[i] != c1[i] && a1[i] != c1[i]))) {
				return false;
			}
		}
		// returns true as default case
		return true;
	}

}
