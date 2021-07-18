package training.java_training.problem_solving;

public class ArmStrongNumber {

	public static void main(String[] args) {
		int number = 153;
		isArmStrongNumber(number);
	}

	private static void isArmStrongNumber(int number) {
		int temp = number;
		int asn = 0;
		while(temp>0) {
			int reminder = temp%10;
			asn = asn+(reminder*reminder*reminder);
			temp = temp/10;
		}
		if(number == asn) {
			System.out.println("The number "+number+" is an ArmStrong Number");
		}
		else {
			System.out.println("The number "+number+" is not an ArmStrong Number");
		}
	}

}
