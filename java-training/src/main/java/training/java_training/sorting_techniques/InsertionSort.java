package training.java_training.sorting_techniques;

public class InsertionSort {
	
	public static void main(String args[])
    {
		System.out.println("Insertion Sort Example");
        int  arr[]={100,20,15,30,5,75};
        insertionSort(arr);
        System.out.print("Sorted Array: ");
        printArray(arr);
    }

	private static void insertionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int valueToSort = arr[i];
			int j;
			
			for (j = i; j > 0 && arr[j - 1] > valueToSort; j--) {
				arr[j] = arr[j-1];
			}
			arr[j] = valueToSort;
			System.out.println("Iteration"+i+" : ");
			printArray(arr);
		}
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
