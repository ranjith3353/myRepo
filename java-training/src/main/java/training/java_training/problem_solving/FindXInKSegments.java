package training.java_training.problem_solving;

public class FindXInKSegments {

	public static void main(String[] args) {
		int[] numbers = new int[] {3, 5, 2, 4, 3, 9, 1, 7, 3, 11, 12, 3 };
		int x = 3, k = 3; // x is the value to find & k is the segment size in array
		//In the given array, the segments looks like: {3,5,2}, {4,9,3}, {1,7,3}, {11,12,3}
		
		int arrayLength = numbers.length;
		
		if(findXInKSegments(numbers, arrayLength, x, k))
			System.out.println("Yes - the value of X: "+x+" is present in all K segments");
		else 
			System.out.println("NO - the value of X: "+x+" is not present in all K segments");
		
	}

	private static boolean findXInKSegments(int[] numbers, int arrayLength, int x, int k) {
		int i = 0;
		boolean isPresent = false;
		
		// First iteration should be on arrayLength - 1
		for (i = 0; i < arrayLength; i=i+k) {
			
			//Second iteration should be on segementLength - 1
			for (int j = 0; j < k; j++) {
				if(i+j < arrayLength && numbers[i+j] == x) {
					System.out.println("value at index: i+j :: " + (i+j) +" is "+ numbers[i+j]);
					break; //If satisfies, the process breaks here and goes to first for loop
				}
				if(j == k)
					return false;
				if(i+j >= arrayLength)
					return false;
				
			}
		}
		if(i >= arrayLength)
			return true;
		else
			return isPresent;
	}

}
