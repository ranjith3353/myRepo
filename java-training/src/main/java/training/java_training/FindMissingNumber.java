package training.java_training;

public class FindMissingNumber {
	
	static Integer getMissingNumber(int[] arr, int length) {
		int total = 1;
		
		for (int i = 2; i < length+1; i++) {
			total += i;
			total -= arr[i-2];
		}
		
		return total;
	}
	
	static Integer getMissingNumberUsingXOR(int[] arr, int length) {
		
		int x1 = arr[0];
		int x2 = 1;
		
		// Find XOR of all elements in an array
		for (int i = 1; i < length; i++) {
			x1 = x1 ^ arr[i];
		}
		
		// Find XOR for all elements from 1 to length + 1
		for (int i = 2; i <= length+1; i++) {
			x2 = x2 ^ i;
		}
		
		return (x1 ^ x2);
	}
	
	static void printMissingNumber(int arr[]) {
		
		int i;
        System.out.print("The repeating element is ");
  
        for (i = 0; i < arr.length; i++) {
            int abs_val = Math.abs(arr[i]);
            if (arr[abs_val - 1] > 0)
                arr[abs_val - 1] = -arr[abs_val - 1];
            else
                System.out.print(abs_val + " ");
        }
  
        System.out.println("And the missing element is ");
        for (i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                System.out.print(i + 1 + " ");
        }
        
        /*int[] temp = new int[arr.length];
		int number = 0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i-1] != i) {
				temp[number] = i;
				number++;
			}
		}*/
        
		/*for (int i = 0; i < temp.length; i++) {
			if(temp[i] != 0)
				System.out.print(temp[i]);
			if(i < temp.length-1)
				System.out.print(" ");
			else if(i == temp.length-1)
				System.out.println();
		}*/
	}
	
	
	
	public static void main(String[] args) {
		
		// Print missing number from array containing repeated values 
		
		int arr[] = { 7, 3, 4, 5, 8, 5, 5, 2, 4 };
		 
		 printMissingNumber(arr);
		 
		 // Print missing number for distinct values
		 
		 int[] arr2 = { 1, 2, 4, 5, 6};
		 
		 System.out.println("Missing Number is: "+ getMissingNumber(arr2, arr2.length));
		 
		 System.out.println("Missing Number is: "+ getMissingNumberUsingXOR(arr2, arr2.length));
		 
	}

}
