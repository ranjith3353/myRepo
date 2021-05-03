package training.java_training.oops;

public abstract class Abstraction {

	abstract String getName() throws Exception;
	
	abstract String getNumber();
	
	public static void staticMethod() {
		System.out.println("Static Method in Abstraction class");
	}
	
	public void display() throws Exception {
		System.out.println("Display from Abstract class for user: " + getName() + " & " +  getNumber());
	}
}
