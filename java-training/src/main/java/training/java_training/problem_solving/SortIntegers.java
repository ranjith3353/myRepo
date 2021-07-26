package training.java_training.problem_solving;

public class SortIntegers {

	public static void main(String[] args) {
		int[] arr = {4,2,5,1,3,8,4,9,0,5,11};
		System.out.println("Before sorting: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i] > arr[i+1]) {
				int temp = arr[i+1];
				arr[i+1] = arr[i];
				arr[i]=temp;
			}
			if(i != 0) {
				if(arr[i] < arr[i-1]) {
					int temp = arr[i-1];
					arr[i-1] = arr[i];
					arr[i]=temp;
					// check for commented lines
				}
			}
		}
		
		System.out.println("\nafter sorting: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
	}
	
	//commented lines
	/*if(arr[0] > arr[i-1]) {
	int temp2 = arr[i-1];
	arr[i-1] = arr[0];
	arr[0] = temp2;
	} else if(arr[0] < arr[i-1]) {
		int temp3 = arr[i-1];
		arr[i-1] = arr[0];
		arr[0] = temp3;
	}*/

}
