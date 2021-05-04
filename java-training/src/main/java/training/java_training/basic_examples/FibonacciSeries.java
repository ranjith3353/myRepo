package training.java_training.basic_examples;

import java.util.Scanner;

public class FibonacciSeries {
	
	static int number1 = 0, number2 = 1, number3 = 0;
	
	static void printFibo(Integer count) {
		if(count > 0) {
			number3 = number1 + number2;
			number1 = number2;
			number2 = number3;
			System.out.print(number3 + " ");
			printFibo(count-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter integer value to build the fibonacci series: ");
		Integer count = scanner.nextInt();
		System.out.println("Fibonacci Series for number: " + count + " is: " );
		System.out.print(number1 + " "+ number2 + " "); // printing first two values
		printFibo(count-2); // because 2 numbers are already printed
		scanner.close();
	}

}
