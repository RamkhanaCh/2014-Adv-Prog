public interface Comparable {

	public int getAge(); // This is an abstract method return the object's age
							// value

	public int isYoungerThan(int a, int b); // This abstract method defines the
											// object that is younger

	public void displayResult(int a); // This also an abstract method, its
										// purpose is to display the result (String types) on
										// the screen
}

// I use Comparable interface to defines that the class that implements this interface
// can be compared by its age.