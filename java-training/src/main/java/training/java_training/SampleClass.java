package training.java_training;

import java.util.List;
import java.util.OptionalDouble;

import edu.emory.mathcs.backport.java.util.Arrays;

public class SampleClass {

	private static Integer[] intArray = { 1, 9, 10, 20, 25, 30, 15, 35 };

	private static int expectedSum = 45;

	static void printSum() {

		for (int i = 0; i < intArray.length; i++) {
			for (int j = i; j < intArray.length - 1 - i; j++) {
				if (intArray[j] + intArray[j + 1] == expectedSum) {
					System.out.print("[" + intArray[j] + "," + intArray[j + 1] + "]");
				}
			}
		}

	}

	static public Integer[] arr = { 5, 2, 15, 9, 13, -5 };

	static Integer k = 11;

	static void printSumOfTwoValuesFromArray() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length - 1 - j; j++) {
				int sum = arr[i] + arr[j + 1];
				if (sum == k) {
					System.out.print("[" + arr[i] + "," + arr[j + 1] + "]");
					break;
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		printSum();

		List<Integer> integers = Arrays.asList(intArray);
		OptionalDouble average = integers.stream().mapToInt(n -> n * n).filter(n -> n > 1000).average();
		if (average.isPresent())
			System.out.println(average.getAsDouble());
	}
}
