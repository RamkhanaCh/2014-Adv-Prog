public class Dog implements Comparable {
	public int age;

	public Dog() {
		age = 0;
	}

	public Dog(int n) {
		age = n;
	}

	@Override
	public int getAge() { // Overrides method from Comparable interface
		return age;
	}

	@Override
	public int isYoungerThan(int a, int b) { // Overrides method from Comparable
												// interface
		Plant p = new Plant(b);
		Dog d = new Dog(a);
		if (p.getAge() < d.getAge()) {
			return 1;
		} else if (p.getAge() > d.getAge()) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public void displayResult(int a) { // Overrides method from Comparable
										// interface
		if (a == 1) {
			System.out.print("Plant is younger than dog.");
		} else if (a == -1) {
			System.out.print("Dog is younger than plant.");
		} else {
			System.out.print("They have the same age.");
		}
	}
}

/*
 * Dog class implements Comparable interface. When an interface is implemented
 * by class (not an abstract one), all methods in that interface is also
 * implemented. This class implements getAge() and isYoungerThan() method from
 * Comparable interface and overrides them. Dog Class implements Comparable to
 * define that object from Dog class can be compared relatively to its age .
 */

