package dailyprogrammer.ch231.intermidiate;

public enum Shading {
	OPEN, HATCHED, FILLED;

	public static Shading valueOf(char c) throws IllegalArgumentException{
		c = Character.toUpperCase(c);
		switch (c) {
		case 'O':
			return OPEN;
		case 'H':
			return HATCHED;
		case 'F':
			return FILLED;
		default:
			throw new IllegalArgumentException();
		}
	}
}
