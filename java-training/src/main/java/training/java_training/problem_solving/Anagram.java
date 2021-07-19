package training.java_training.problem_solving;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("life","file"));
	}

	public static boolean isAnagram(String word, String anagramWord) {
		char[] wordCharArray = word.toCharArray();
		char[] anagramWordCharArray = anagramWord.toCharArray();
		Arrays.sort(wordCharArray);
		Arrays.sort(anagramWordCharArray);
		return Arrays.equals(wordCharArray, anagramWordCharArray);
	}
}
