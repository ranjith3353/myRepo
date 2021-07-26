package training.java_training;

public class IntegerArrayExample {

	public static void main(String[] args) {
		int[] intArray = {4,3,5,7,1};
		int length = intArray.length;
		
		int minNumber = 0;
		int maxNumber = 0;
		int sumTotal = 0;
		for (int i = 0; i < length; i++) {
			if(minNumber > intArray[i]) {
				minNumber = intArray[i];
			} 
			if(maxNumber < intArray[i]){
				maxNumber = intArray[i];
			}
			sumTotal = sumTotal+intArray[i];
		}
		System.out.println("Max sum of n-1 elements: "+(sumTotal-minNumber));
		System.out.println("Min sum of n-1 elements: "+(sumTotal-maxNumber));
		
	}

}
