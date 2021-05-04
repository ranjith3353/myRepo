package training.java_training.basic_examples;

import java.util.Scanner;

public class FactorialOfN {
	
	//Using recursion - below is the static block for factorial
	
	static Integer factorial(Integer number) {
		if(number == 1) {
			return number;
		} else {
			return (number * factorial(number-1));
		}
	}

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number to calculate factorial: ");
		Integer number = scanner.nextInt();
		System.out.println("Factorial for number: " + number +" is: " +  factorial(number));
		scanner.close();
	}
}
