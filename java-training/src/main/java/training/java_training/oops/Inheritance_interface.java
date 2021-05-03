package training.java_training.oops;

public interface Inheritance_interface {

	public static String OBJECT_NAME = "inheritance-example";
	
	public void printDetails();
	
	//private void dontProvideDetails(); //This is not valid because interface doesn't allow private access modifier to methods.
	
	default String printNumber() {
		return "xxxxxxxx";
	}
	
}
