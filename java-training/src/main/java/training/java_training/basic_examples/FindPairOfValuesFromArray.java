package training.java_training.basic_examples;

import java.util.HashSet;
import java.util.Set;

import edu.emory.mathcs.backport.java.util.Arrays;

public class FindPairOfValuesFromArray {

	
	public static void main(String[] args) {
		int A[] = {1, 2, 3, 5, 4, 7, 9, 12, 10, -3};
		
		int expectedSum = 11;
		
		int expectedDifference = 4;
		
		int expectedProduct = 20;
		
		printSumCombinationsUsingTwoPointersTechnique(A, expectedSum);
		System.out.println("===========================================");
		
		printSumCombinationsUsingHashSet(A, expectedSum);
		System.out.println("===========================================");
		
		printDifferenceCombinationsUsingTwoPointersTechnique(A, expectedDifference);
		System.out.println("===========================================");
		
		printDifferenceCombinationsUsingHashSet(A, expectedDifference);
		System.out.println("===========================================");
		
		printMultiplicationCombinationsUsingHashSet(A, expectedProduct);
		System.out.println("===========================================");
		
		printMultiplicationCombinationsUsingTwoPointersTechnique(A, expectedProduct);
		System.out.println("===========================================");
		
		printPairsHavingProductEqualsToX(A);
		System.out.println("===========================================");
	}

	private static void printMultiplicationCombinationsUsingTwoPointersTechnique(int[] intArray, int output) {
		System.out.println("Sorting & two pointer technique for multiplication");
		//Arrays.sort(intArray); // even if we don't sort, we can achieve the output
		int left = 0;
		int right = intArray.length-1;
		int count = 0;
		System.out.print("The pair of values equals expected sum: "+output+" are: ");
		while(left < right) {
			if (intArray[left] * intArray[right] == output) {
				System.out.print("["+intArray[left] +","+intArray[right]+"]");
				left++;
				count++;
			} else if(intArray[left] * intArray[right] < output) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println();
		System.out.println("Total pairs: "+ count);
	}

	private static void printMultiplicationCombinationsUsingHashSet(int[] intArray, int output) {
		System.out.println("Hashing Technique for multiplication");
		Set<Integer> s = new HashSet<Integer>();
		int count = 0;
		System.out.print("The pair of values equals expected product: "+output+" are: ");
		for (int i = 0; i < intArray.length; ++i) {
			int temp = output / intArray[i];
			if(s.contains(temp)) {
				System.out.print("["+intArray[i] +","+temp+"]");
				count++;
			}
			s.add(intArray[i]);
		}
		System.out.println();
		System.out.println("Total pairs: "+ count);
		System.out.println("This approcah can't give all pairs - so try using two pointer technique");
	}

	private static void printPairsHavingProductEqualsToX(int[] a) {
		System.out.println("Product of Sum & Difference equals X example");
		int count = 0;
		int x = 3;
		System.out.print("The pairs are: ");
		for (int i = 1, j = 0; i < a.length && i > j; i++,j++) {
			if((a[i]+a[j])*(a[i]-a[j]) == x) {
				System.out.print("["+a[j] +","+a[i]+"]");
				count++;
			}
		}
		System.out.println();
		System.out.println("Total pairs: "+ count);
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
