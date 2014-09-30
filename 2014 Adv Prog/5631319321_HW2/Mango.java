public class Mango implements Edible {

	private String color;

	public Mango() {
		color = "Yellow";
	}

	public String getColor() {
		return color;
	}
	@Override
	public String howToEat() { // Override method from Edible interface
		return "How to eat mango?: Peel it!";
	}
}
/*
 * Mango class implements Edible interface. When an interface is implemented by
 * class (not an abstract one), all methods in that interface is also
 * implemented. This class implements howToEat() method from Edible interface
 * and overrides it. Mango Class implements Edible to define that mango can be
 * eaten.
 */