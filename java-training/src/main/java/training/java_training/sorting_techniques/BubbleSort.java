package training.java_training.sorting_techniques;

public class BubbleSort {

	public static void main(String args[]) {
		System.out.println("Bubble Sort Example");
		int arr[] = { 100, 20, 15, 30, 5, 75, 40 };
		bubbleSort(arr);
		System.out.print("Sorted Array: ");
		printIteration(arr);
	}

	private static void bubbleSort(int[] arr) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			int length1 = length - 1 - i;
			for (int j = 0; j < length1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			System.out.print("Iteration" + (i + 1) + ": ");
			printIteration(arr);
		}
	}

	private static void printIteration(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
