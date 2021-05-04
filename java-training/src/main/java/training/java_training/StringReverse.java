package training.java_training;

public class StringReverse {

	public static String BASEBALL = "baseball";

	public static void method1() {
		char[] charArray = new char[10];
		for (int i = 1; i <= BASEBALL.length(); i++) {
			char charAt = BASEBALL.charAt(BASEBALL.length() - i);
			charArray[i] = charAt;
		}

		System.out.println(String.valueOf(charArray));

	}
	
	static void printReverseOfAString(String word) {
		byte[] input = word.getBytes();
		byte[] result = new byte[input.length];
		for (int i = 0; i < input.length; i++) {
			result[i] = input[input.length-1-i];
		}
		System.out.println(new String(result));
	}

	public static void main(String[] args) {
		method1();
		printReverseOfAString(BASEBALL);
	}
}
