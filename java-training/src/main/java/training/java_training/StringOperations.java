package training.java_training;

public class StringOperations {
	
	static void concat(String s1) {
		s1 = s1 + " value";
	}
	
	public static void main(String[] args) {
		String s1 = "first";
		concat(s1);
		System.out.println("String: "+ s1);
		
		StringBuilder s2 = new StringBuilder(s1);
		concat2(s2);
		System.out.println("String Builder: "+ s2);
		
		StringBuffer s3 = new StringBuffer(s1);
		concat3(s3);
		System.out.println("String Buffer: "+ s3);
	}
	

	private static void concat3(StringBuffer s3) {
		s3.append(" value");
	}

	private static void concat2(StringBuilder s2) {
		s2.append(" value");
	}

}
