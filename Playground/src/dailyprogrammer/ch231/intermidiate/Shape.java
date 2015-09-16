package dailyprogrammer.ch231.intermidiate;

public enum Shape {
	DIAMOND, OVAL, SQUIGGLE;

	public static Shape valueOf(char c) throws IllegalArgumentException{
		c = Character.toUpperCase(c);
		switch (c) {
		case 'D':
			return DIAMOND;
		case 'O':
			return OVAL;
		case 'S':
			return SQUIGGLE;
		default:
			throw new IllegalArgumentException();
		}
	}
}
