package training.java_training;

public class SortIntegers {
	
	static int[] numbers = { 7, 3, 6, 4, 2, 9 };
	static int missingNumber;	
	public static void main(String[] args) {
		
		SortIntegers.sortIntegers();
	}
	
	static void sortIntegers() {
		int[] numbers = { 2,6,8,4,3,9,1};
		int tempVariable;
		for (int i = 0; i < numbers.length-1; i++) {
			for (int j = i; j < numbers.length-1; j++) {
				for (int k = j; k < numbers.length-1; k++) {
					if(numbers[k] > numbers[k+1]) {
						tempVariable = numbers[k];
						numbers[k] = numbers[k+1];
						numbers[k+1] = tempVariable;
					}
				}
			}
		}
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

}
