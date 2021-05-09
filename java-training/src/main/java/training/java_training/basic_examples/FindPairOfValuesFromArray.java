package training.java_training.basic_examples;

import java.util.HashSet;
import java.util.Set;

import edu.emory.mathcs.backport.java.util.Arrays;

public class FindPairOfValuesFromArray {

	
	public static void main(String[] args) {
		int A[] = {1, 2, 3, 5, 4, 7, 9, 12, 10, -3};
		
		int expectedSum = 11;
		
		int expectedDifference = 4;
		
		printSumCombinationsUsingTwoPointersTechnique(A, expectedSum);
		System.out.println("===========================================");
		
		printSumCombinationsUsingHashSet(A, expectedSum);
		System.out.println("===========================================");
		
		printDifferenceCombinationsUsingTwoPointersTechnique(A, expectedDifference);
		System.out.println("===========================================");
		
		printDifferenceCombinationsUsingHashSet(A, expectedDifference);
		System.out.println("===========================================");
	}

	private static void printDifferenceCombinationsUsingTwoPointersTechnique(int[] intArray, int output) {
		System.out.println("Sorting & two pointer technique for difference");
		Arrays.sort(intArray);
		int left = 0;
		int right = 0;
		int count = 0;
		System.out.print("The pair of values equals expected sum: "+output+" are: ");
		while(right < output) {
			if (intArray[right] - intArray[left] == output) {
				System.out.print("["+intArray[left] +","+intArray[right]+"]");
				left++;
				right++;
				count++;
			} else if(intArray[right] - intArray[left] < output) {
				right++;
			} else {
				left++;
			}
		}
		System.out.println();
		System.out.println("Total pairs: "+ count);
		System.out.println("This approcah can't give all pairs - so try using hashing technique");
		
	}

	private static void printDifferenceCombinationsUsingHashSet(int[] intArray, int output) {
		System.out.println("Hashing Technique for difference");
		Set<Integer> s = new HashSet<Integer>();
		int count = 0;
		System.out.print("The pair of values equals expected sum: "+output+" are: ");
		for (int i = 0; i < intArray.length; ++i) {
			int temp = intArray[i] - output;
			if(s.contains(temp)) {
				System.out.print("["+intArray[i] +","+temp+"]");
				count++;
			}
			s.add(intArray[i]);
		}
		System.out.println();
		System.out.println("Total pairs: "+ count);
	}

	private static void printSumCombinationsUsingTwoPointersTechnique(int[] intArray, int output) {
		System.out.println("Sorting & two pointer technique");
		Arrays.sort(intArray);
		int left = 0;
		int right = intArray.length-1;
		int count = 0;
		System.out.print("The pair of values equals expected sum: "+output+" are: ");
		while(left < right) {
			if (intArray[left] + intArray[right] == output) {
				System.out.print("["+intArray[left] +","+intArray[right]+"]");
				left++;
				count++;
			} else if(intArray[left] + intArray[right] < output) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println();
		System.out.println("Total pairs: "+ count);
	}

	private static void printSumCombinationsUsingHashSet(int[] intArray, int output) {
		System.out.println("Hashing Technique");
		Set<Integer> s = new HashSet<Integer>();
		int count = 0;
		System.out.print("The pair of values equals expected sum: "+output+" are: ");
		for (int i = 0; i < intArray.length; ++i) {
			int temp = output - intArray[i];
			if(s.contains(temp)) {
				System.out.print("["+intArray[i] +","+temp+"]");
				count++;
			}
			s.add(intArray[i]);
		}
		System.out.println();
		System.out.println("Total pairs: "+ count);
	}
}
