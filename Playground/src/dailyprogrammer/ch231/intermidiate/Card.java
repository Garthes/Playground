package dailyprogrammer.ch231.intermidiate;

/**
 * @author Gerrit Teege
 *
 */
public class Card {
	private Shape shape;
	private Color color;
	private int number;
	private Shading shading;

	public Card(String desc) {
		this.shape = Shape.valueOf(desc.charAt(0));
		this.color = Color.valueOf(desc.charAt(1));
		this.number = Character.getNumericValue(desc.charAt(2));
		this.shading = Shading.valueOf(desc.charAt(3));
	}

	public Card(Shape shape, Color color, int number, Shading shading) {
		this.shape = shape;
		this.color = color;
		this.number = number;
		this.shading = shading;
	}

	public Shape getShape() {
		return shape;
	}

	public Color getColor() {
		return color;
	}

	public Shading getShading() {
		return shading;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + number;
		result = prime * result + ((shading == null) ? 0 : shading.hashCode());
		result = prime * result + ((shape == null) ? 0 : shape.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (color != other.color)
			return false;
		if (number != other.number)
			return false;
		if (shading != other.shading)
			return false;
		if (shape != other.shape)
			return false;
		return true;
	}

}
