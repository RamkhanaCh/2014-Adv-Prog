public class Chicken implements Edible {
	private double weight;

	public Chicken() {
		weight = 0.0;
	}

	@Override
	public String howToEat() { // Override method form Edible interface
		return "How to eat chicken?: Grill it!";
	}

	@Override
	public String getHowToEat() {

		return new Chicken().howToEat();
	}

	

}
/*
 * Chicken class implements Edible interface. When an interface is implemented
 * by class (not an abstract one), all methods in that interface is also
 * implemented. Chicken class implements howToEat() method from Edible interface
 * and overrides it. Chicken Class implements Edible to define that chicken can
 * be eaten.
 */