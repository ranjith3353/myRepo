package training.java_training;

public class OverloadingExample {
	
	//overloading & overriding example
	
	//overloading : compile time polymorphism & overriding: runtime or dynamic polymorphism

	private void method(int i) {
		System.out.println("Int: "+ i);
	}

	private void method(long l) {
		System.out.println("Long: "+ l);
	}
	
	private void method(double d) {
		System.out.println("Double: "+ d);
	}
	
	private void method(float f) {
		System.out.println("Float: "+ f);
	}

	private int method(String s) {
		System.out.println("String: "+ s);
		return Integer.valueOf(s);
	}
	
	private void method(StringBuffer sb) {
		System.out.println("String Buffer: "+ sb);
	}
	
	public static void main(String[] args) {
		OverloadingExample sampleClass = new OverloadingExample();
		int number = sampleClass.method("10");
		System.out.println("Returned integer with string input" + number);
		sampleClass.method('x'); //char will promote to int -> Automatic promotion in overlodaing
		sampleClass.method(12.5f);
	}
}
