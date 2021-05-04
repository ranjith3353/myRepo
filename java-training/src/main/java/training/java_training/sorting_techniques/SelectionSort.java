package training.java_training.sorting_techniques;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		System.out.println("Selection Sort Example");
		int arr[] = { 100, 20, 15, 30, 5, 75, 40 };
		System.out.println("Before Sorting: "+ Arrays.toString(arr));
		selectionSort(arr);
		System.out.println("After Sorting: "+ Arrays.toString(arr));
	}

	private static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[index])
					index = j;
			}
			int smallNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallNumber;
		}
	}

}
