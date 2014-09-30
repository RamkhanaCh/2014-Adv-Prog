public class Chicken implements Edible {
	private double weight;

	public Chicken() {
		weight = 0.0;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public String howToEat() { // Override method form Edible interface
		return "How to eat chicken?: Grill it!";
	}

	public static void main(String[] args) {
		Edible c = new Chicken(); /*
								 * I define reference of Edible type with the
								 * name c and assign c to be Chicken object
								 */
		System.out.print(c.howToEat()); /*
										 * This is to check that Java call
										 * method from object's instance type
										 * not it's reference type
										 */
	}
}
/*
 * Chicken class implements Edible interface. When an interface is implemented
 * by class (not an abstract one), all methods in that interface is also
 * implemented. Chicken class implements howToEat() method from Edible interface
 * and overrides it. Chicken Class implements Edible to define that chicken can
 * be eaten.
 */