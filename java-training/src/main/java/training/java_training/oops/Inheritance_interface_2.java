package training.java_training.oops;

public interface Inheritance_interface_2 {

	public static String OBJECT_NAME = "inheritance-example";
	
	public String printDetails();
	
	//private void dontProvideDetails(); //This is not valid because interface doesn't allow private access modifier to methods.
	
	default String printNumber() {
		return "xxxxxxxx";
	}
	
}
