package training.java_training;

public class SampleClass {

	private static int[] intArray = {1,9,10,20,25,30,15,35};
	
	private static int expectedSum = 45;
	
	static void printSum() {
		
		for (int i = 0; i < intArray.length; i++) {
			for (int j = i; j < intArray.length-1-i; j++) {
				if(intArray[j] + intArray[j+1] == expectedSum) {
					System.out.print("[" +intArray[j] + "," + intArray[j+1]+"]");
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		printSum();
	}
}
