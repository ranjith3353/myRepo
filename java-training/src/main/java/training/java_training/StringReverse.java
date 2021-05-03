package training.java_training;

public class StringReverse {

	public String BASEBALL = "baseball";

	public void method1() {
		char[] charArray = new char[10];
		for (int i = 1; i <= BASEBALL.length(); i++) {
			char charAt = BASEBALL.charAt(BASEBALL.length() - i);
			charArray[i] = charAt;
		}

		System.out.println(String.valueOf(charArray));

	}

	public static void main(String[] args) {
		StringReverse sample = new StringReverse();
		sample.method1();
	}
}
