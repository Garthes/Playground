public class Pure {

	public static void main(String[] args) {
		int num = 90238594;
		String s = toString(num);
		System.out.println(s);
		System.out.println(toInt(s));

	}

	public static String toString(int num) {
		String ret = "";
		char c;
		while (num > 0) {
			c = (char) (num % 10 + 48);
			num /= 10;
			ret = c + ret;
		}
		return ret;
	}

	public static int toInt(String num) {
		int ret = 0;
		int place = 1;

		for (int i = 1; i < num.length(); i++) {
			place *= 10;
		}

		for (char c : num.toCharArray()) {
			ret += (((int) c) - 48) * place;
			place /= 10;
		}
		return ret;
	}

}
