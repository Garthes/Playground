package dailyprogrammer.ch231.intermidiate;

public enum Color {
	RED, PURPLE, GREEN;

	/**
	 * 
	 * @param c
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static Color valueOf(char c) throws IllegalArgumentException{
		c = Character.toUpperCase(c);
		switch (c) {
		case 'R':
			return RED;
		case 'P':
			return PURPLE;
		case 'G':
			return GREEN;
		default:
			throw new IllegalArgumentException();
		}
	}

}
