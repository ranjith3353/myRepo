package training.java_training.problem_solving;

import java.util.Arrays;

public class RemoveDuplicatesFromArray {
	static int[] arrayWithDuplicates = {1,1,2,3,4,5,6,4,3,3};
	
	public static void main(String[] args) {
		System.out.println("Before removing duplicates: "+Arrays.toString(arrayWithDuplicates));
		int[] updatedArray = removeDuplicateElementsFromArray(arrayWithDuplicates);
		System.out.println("After removing duplicates: "+Arrays.toString(updatedArray));
	}

	private static int[] removeDuplicateElementsFromArray(int[] duplicateElementsArray) {
		Arrays.sort(duplicateElementsArray); 
		int arrayLength = duplicateElementsArray.length;
		int[] result = new int[arrayLength];
		int previous = duplicateElementsArray[0];
		result[0] = previous;
		for (int i = 1; i < duplicateElementsArray.length; i++) {
			int ch = duplicateElementsArray[i];
			
			if(previous != ch) {
				result[i] = ch;
			} 
			previous = ch;
		}
		System.out.println("Bineary Search for value 6: "+Arrays.binarySearch(result, 6));
		return result;
	}
}
