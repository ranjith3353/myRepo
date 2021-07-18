package training.java_training.problem_solving;

import java.util.Scanner;

public class FindPrimeNumber {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int number = 1;
		System.out.println("Enter number to check if prime or not ");
		while (number != 0) {
			number = scnr.nextInt();
			System.out.printf("Does %d is prime? %s %s %s %n", number, isPrime(number), isPrimeOrNot(number),
					isPrimeNumber(number));
		}
		scnr.close();
	}

	private static boolean isPrime(int number) {
		int sqrt = (int) Math.sqrt(number)+1;
		for (int i = 2; i < sqrt; i++) {
			if(number%i == 0) {
				return false;
			} 
		}
		return true;
	}

	private static String isPrimeOrNot(int number) {
		if(number < 0)
			return "not valid";
		if(number == 0 || number == 1)
			return "not prime";
		if(number ==2 || number == 3)
			return "prime";
		if((number*number-1)%24 == 0)
			return "prime";
		else
			return "not prime";
	}

	private static boolean isPrimeNumber(int number) {
		if(number == 2 || number == 3)
			return true;
		if(number % 2 == 0)
			return false;
		else
			return isPrime(number);
	}

}
