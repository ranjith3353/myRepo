package year2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day_6 {

    public static final String INPUT_FILE = "D:\\Users\\lakumar\\Desktop\\GIT-Ranjith\\Advent-of-Code\\src\\year2022\\puzzle-6-input.txt";

    public static void main(String args[]) {
        List<String> input = new ArrayList<>();
        String s="";
        File inputFile = new File(INPUT_FILE);
        Scanner scan;
        try {
            scan = new Scanner(inputFile);
            while(scan.hasNext()) {
                s = scan.nextLine();
                input.add(s);
            }
            System.out.println("input received");

            System.out.println(part2(input));

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static Integer part1(List<String> input) {
        int totalChars = 0;
        //List<String> charactersProcessed = new ArrayList<>();
        for (String line:input) {
            char[] chars = line.toCharArray();
            //char tempChar;
            int j = 3;
            System.out.println(line.substring(0, 1569));
            for (int i = 0; i < chars.length; i++) {
                //tempChar = chars[i];
                //charactersProcessed.add(String.valueOf(tempChar));
                //!charactersProcessed.contains(String.valueOf(tempChar))
                if(i == j) { // this check will validate every 4th element from the input
                    char aChar = chars[i];
                    char aChar1 = chars[i - 1];
                    char aChar2 = chars[i - 2];
                    char aChar3 = chars[i - 3];
                    if((aChar != aChar1) && (aChar != aChar2) && (aChar != aChar3)) {
                        if((aChar1 != aChar2) && (aChar1 != aChar3)) {
                            if((aChar2 != aChar3)) {
                                totalChars++;
                                System.out.println("start-of-packet marker is detected after " + totalChars + " characters processed & character is: "+ aChar);
                                return totalChars;
                            }
                        }
                    }
                    j++;
                }
                totalChars++;
            }
        }
        return totalChars;
    }

    private static Integer part2(List<String> input) { // Correct answer : 2265
        int totalChars = 0;
        for (String line:input) {
            for(int startIndex = 0, endIndex = 13; startIndex < line.length()-14;startIndex++, endIndex++ ) {
                String test = line.substring(startIndex, endIndex);
                boolean unique = isUnique(test);
                if(unique) {
                  System.out.println("Index: "+endIndex+ " string: "+test);
                  return endIndex;
                }
            }
        }
        return totalChars;
    }
    public static boolean isUnique(String input) { // Create a Set to insert characters
        Set<Character> set = new HashSet<>();
        // get all characters form String
        char[] characters = input.toCharArray();
        for (Character c : characters) {
            if (!set.add(c)) {
                return false;
            }
        } return true;
    }

}
