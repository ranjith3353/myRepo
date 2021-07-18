package training.java_training.problem_solving;

public class Palindrome {

	public static void main(String[] args) {
		String name = "alala";
		System.out.println("name: "+name);
		isPalindrome(name);
		isPalindromeUsingStringBuffer(name);
		isPalindromeUsingStringBuilder(name);
	}

	private static void isPalindromeUsingStringBuilder(String name) {
		char[] array = name.toCharArray();
		StringBuilder sb = new StringBuilder(name.length());
		for (int i = name.length()-1; i >= 0; i--) {
			sb.append(array[i]);
		}
		String reverse = sb.toString();
		System.out.println("Is name equals reversed name - using string builder: " + name.equals(reverse));
	}

	private static void isPalindrome(String name) {
		String reverse = reverse(name);
		System.out.println("Is name equals reversed name - using native reverse method: " + name.equals(reverse));
	}

	private static String reverse(String name) {
		if(name == null || name == "") {
			return name;
		}
		if(name.length() == 0)
			return name;
		else
			return name.charAt(name.length()-1) + reverse(name.substring(0, name.length()-1));
	}

	private static void isPalindromeUsingStringBuffer(String name) {
		StringBuffer sb = new StringBuffer(name);
		String reversedName = sb.reverse().toString();
		System.out.println("Is name equals reversed name - using string buffer: " + name.equals(reversedName));
	}
}
