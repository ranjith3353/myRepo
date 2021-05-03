package training.java_training;

import java.util.HashMap;
import java.util.Scanner;

public class NonRepeatableString {

	private static final int NO_OF_CHARS = 256;
	static char count[] = new char[NO_OF_CHARS];

	static void getCharCountArray(String str) {
		for (int i = 0; i < str.length(); i++)
			count[str.charAt(i)]++;
	}

	static int firstNonRepeatableString(String str) {
		getCharCountArray(str);

		int index = -1, i;

		for (i = 0; i < str.length(); i++) {
			if (count[str.charAt(i)] == 1) {
				index = i;
				break;
			}
		}

		return index;

	}

	private static Character findLastNonRepeatingCharacter(String string) {
		HashMap<Character, Integer> characterMap = new HashMap<>();

		// iterate the string and store count of each character in the map
		for (int i = 0; i < string.length(); i++) {
			Character currentCharacter = string.charAt(i);
			if (characterMap.containsKey(currentCharacter)) {
				// character is already added to the map. Increment the count.
				characterMap.put(currentCharacter, characterMap.get(currentCharacter) + 1);
			} else { // character is not added to the map. add it with value as
						// 1
				characterMap.put(currentCharacter, 1);
			}
		}
		for (int i = string.length() - 1; i >= 0; i--) {
			if (characterMap.get(string.charAt(i)) == 1) {
                return string.charAt(i);
            }
		}
		return null;

	}

	public static void main(String[] args) {
		String str = "samplestring";

		// first non repeatable character
		int index = firstNonRepeatableString(str);

		System.out.println(index == -1 ? "Either all characters are repeating or string " + "is empty"
				: "First non-repeating character is " + str.charAt(index));

		// last non repeatable character
		Character chrct = findLastNonRepeatingCharacter(str);
		System.out.println("Last non repeatbale character of string: " + str + " is: " + chrct);
		
		String userInputString;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string : ");
        userInputString = scanner.nextLine();
        Character c = findLastNonRepeatingCharacter(userInputString);

        if (c == null) {
        	System.out.println("No character found.");
        } else {
        	System.out.println("Last non repeating character is " + c);
        }
        scanner.close();
	}
}
