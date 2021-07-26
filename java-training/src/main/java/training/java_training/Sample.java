package training.java_training;

import java.util.Arrays;

public class Sample {

	public static void main(String[] args) {
		int[] arr = {5,3,2,1};
		int[] arr2 = {4,2,3,5};
		
		int[] arr3 = new int[arr.length+arr2.length];
		
		for (int i = 0; i < arr.length; i++) {
			arr3[i] = arr[i];
		}
		for (int i = 0, j=arr3.length-arr.length; i < arr2.length; i++,j++) {
			arr3[j] = arr2[i];
		}
		System.out.println("arr3: ");
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] +"\t");
		}
		
		
		for (int i = 0; i < arr3.length; i++) {
			int temp = i;
			for (int j = i+1; j < arr3.length-1; j++) {
				if(arr3[j] < arr3[temp])
					temp = j;
			}
			int num = arr3[temp];
			arr3[temp] = arr3[i];
			arr3[i] = num;
		}
		
		System.out.println("\nAfter sorting");
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] +"\t");
		}
		
		
		
		System.out.println("\nremove duplicates");
		//stream example
		int[] arr4 = {5,3,2,1,4,5};
		Arrays.stream(arr4).distinct().forEach((int n) -> {System.out.print(n+"\t");});
		
		
	}

}
