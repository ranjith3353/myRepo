package training.java_training.problem_solving;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FibonacciSeries {
	
	static int number1 = 1, number2 = 1, number3 = 0;
	
	static void printFibo(Integer count) {
		if(count > 0) {
			number3 = number1 + number2;
			number1 = number2;
			number2 = number3;
			System.out.print(number3 + " ");
			printFibo(count-1);
		}
	}
	
	static void printFiboInRecursive(int count) {
		for (int i = 1; i <= count; i++) {
			System.out.print(printNumber(i) + " ");
		}
	}

	private static int printNumber(int number) {
		if(number == 1 || number == 2) {
			return 1;
		} else {
			return printNumber((number-1))+ printNumber((number-2));
		}
	}
	
	public static void main(String[] args) {
		Map<Integer, Integer> numberMap = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter integer value to build the fibonacci series: ");
		final Integer count = scanner.nextInt();
		improvedFibo(numberMap, count);
		printFiboInRecursive(count);
		System.out.println();
		improvedFibo(numberMap, count);
		timeProcessed(numberMap, count);
		System.out.println("Fibonacci Series for number: " + count + " is: " );
		System.out.print(number1 + " "+ number2 + " "); // printing first two values
		printFibo(count-2); // because 2 numbers are already printed
		System.out.println();
		scanner.close();
	}

	private static void improvedFibo(Map<Integer, Integer> numberMap, Integer count) {
		System.out.println("Fibonacci Number: " + printFibonocci(numberMap, count));
	}

	private static int printFibonocci(Map<Integer, Integer> numberMap, Integer count) {
		Integer number = numberMap.get(count);
		if(number != null && number != 0) {
			return number;
		} else {
			int fiboNum = printFiboNum(count); //fibonacci number with memoization 
			numberMap.put(count, fiboNum);
			return fiboNum;
		}
	}
	
	static void timeProcessed(Map<Integer, Integer> numberMap, int count) {
		// This methods tells us the importance of caching the values to reduce the processing time
		
		long startTime = System.nanoTime(); 
		printFiboNum(count); //fibonacci number with memoization 
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Time taken to calculate Fibonacci number upto 100M without memorization:" + elapsedTime);
		
		startTime = System.nanoTime(); 
		improvedFibo(numberMap, count); //Fibonacci number with memoization 
		elapsedTime = System.nanoTime() - startTime; 
		System.out.println("Time taken to calculate Fibonacci number upto 100M with memorization:" + elapsedTime);

	}

	private static int printFiboNum(Integer number) {
		for (int i = 3; i <= number; i++) {
			number3 = number1 + number2;
			number1 = number2;
			number2 = number3;
		}
		return number3;
	}

}
