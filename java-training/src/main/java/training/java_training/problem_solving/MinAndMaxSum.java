package training.java_training.problem_solving;


// This class process the minimum & maximum sum of n-1 elements of an array

public class MinAndMaxSum {

	public static void main(String[] args) {
		int[] arr = {1,2,4,5,7,8,6};
		
		// to get min & max values, declare their objects
		int min = arr[0], max =0;
		int sum = 0;
		
		// fetch min & max values and total sum
		for (int i = 0; i < arr.length; i++) {
			if(min > arr[i]){
				min = arr[i];
			}else if(max < arr[i]) {
				max = arr[i];
			}
			sum = sum+arr[i];
		}
		System.out.println("Total Sum of elements: "+sum);
		System.out.println("Minimum Number: " + min);
		System.out.println("Maximum Number: " + max);
		
		//minimum sum of n-1 elements -> excluding maximum number
		System.out.println("Minimum sum of n-1 elements: "+(sum-max));
		
		//maximum sum of n-1 elements -> excluding minimum number
		System.out.println("Maximum sum of n-1 elements: "+(sum-min));
	}
}
