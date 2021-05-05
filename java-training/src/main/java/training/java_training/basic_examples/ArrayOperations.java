package training.java_training.basic_examples;

import java.util.Scanner;

public class ArrayOperations {

	public static int[] arr = new int[10];

	static Scanner scanner = new Scanner(System.in);

	static void readInputFromConsole() {
		for (int i = 1; i <= arr.length; i++) {
			System.out.print("Input integer" + i +": ");
			int nextInt = scanner.nextInt();
			System.out.print(nextInt);
			arr[i-1] = nextInt;
			System.out.println();
		}
		System.out.println();
	}
	
	static void displayArray(int[] arr) {
		System.out.print("Displaying values in array: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	private static void addNewValueIntoArray() {
		System.out.print("Add new value into the array : ");
		int nextInt = scanner.nextInt();
		System.out.print(nextInt + " after last index \n");
		int[] newArr = new int[arr.length+1];
		try {
			for (int i = 0; i < arr.length; i++) {
				newArr[i] = arr[i];
			}
			newArr[arr.length] = nextInt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		displayArray(newArr);
		
	}

	private static void deleteValueInArray() {
		System.out.print("Deleting value in array of index: ");
		int indexToremove = scanner.nextInt();
		System.out.print(indexToremove + " and value in this index is: "+ arr[indexToremove] + "\n");
		
		if (!(arr == null
	            || indexToremove < 0
	            || indexToremove >= arr.length)) {

			int[] anotherArray = new int[arr.length-1];
			
			for (int i = 0, k=0; i < arr.length; i++) {
				if(i == indexToremove) {
					continue;
				}
				
				anotherArray[k++] = arr[i];
			}
			displayArray(anotherArray);
        } else {
        	displayArray(arr);
        }
		
	}

	private static void updateValueInArray() {
		System.out.print("Updating value in array of index: ");
		int nextInt = scanner.nextInt();
		System.out.print(nextInt + " and value to update:");
		int valueToUpdate = scanner.nextInt();
		System.out.print(valueToUpdate + "\n");
		arr[nextInt] = valueToUpdate;
	}
	
	public static void main(String[] args) {
		//Example 1
		readInputFromConsole();
		
		//Example 2
		updateValueInArray();
		
		//Example 3
		displayArray(arr);
		
		//Example 4
		addNewValueIntoArray();
		
		// Example 5
		deleteValueInArray();
		
		scanner.close();
	}
}
