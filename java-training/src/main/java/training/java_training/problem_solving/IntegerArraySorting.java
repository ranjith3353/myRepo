package training.java_training.problem_solving;

public class IntegerArraySorting {

	public static void main(String[] args) {
		int[] arr = {1,0,2,0,0,2,0,1,0,1};
		//before sorting
		System.out.println("before sorting: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		// to sort 0s 1s & 2s -> consider their low, mid & high positions of array
		int low = 0, mid = 0, temp = 0;
		int high = arr.length-1;
		
		while (mid <= high) {
			if(arr[mid] == 0){
				temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				low++;
				mid++;
			} else if(arr[mid] == 1){
				mid++;
			} else if(arr[mid]==2){
				temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				high--;
			}
		}
		
		//after sorting
		System.out.println("\nafter sorting: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		
	}

}
