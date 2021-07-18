package training.java_training.problem_solving;

public class IntegerPalindrome {

	public static void main(String[] args) {
		int number = 1221;
		int temp = number;
		int revNum = 0;
		
		while(temp>0) {
			int reminder = temp%10;
			revNum = revNum*10+reminder;
			temp = temp/10;
		}
		System.out.printf("Reverse of "+number+" is: "+revNum+"\n");
		if(number == revNum){
			System.out.println("The given number is palindrome");
		} else {
			System.out.println("The given number is not palindrome");
		}
	}

}
