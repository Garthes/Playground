package dailyprogrammer.ch229.hard;

import java.math.BigInteger;

public class Main {

	public static int N = 7;

	public static void main(String[] args) {
		BigInteger sum = BigInteger.ZERO;
		BigInteger start = BigInteger.ZERO;
		BigInteger upper = BigInteger.TEN;
		upper = upper.pow(N);

		for (; start.compareTo(upper) <= 0; start = start.add(BigInteger.ONE)) {
			sum = sum.add(start);
		}

		System.out.println(sum);

	}

	private static Long reverse(long n) {
		long reverse = 0;

		while (n != 0) {
			reverse = reverse * 10;
			reverse = reverse + n % 10;
			n = n / 10;
		}

		return reverse;
	}

	private static boolean bySeven(int num) {
		if (num < 10) {
			return num == 7 || num == 0;
		}
		int newNum = num / 10;
		int last = num - newNum * 10;

		return bySeven(newNum - (last * 2));
	}

}
