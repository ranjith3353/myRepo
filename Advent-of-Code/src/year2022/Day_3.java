package year2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day_3 {

    public static final String INPUT_FILE = "D:\\Users\\lakumar\\Desktop\\GIT-Ranjith\\Advent-of-Code\\src\\year2022\\puzzle-3-input.txt";

    public static void main(String args[]) {
        List<String> input = new ArrayList<>();
        String s="";
        File inputFile = new File(INPUT_FILE);
        Scanner scan;
        //System. out. println("lowercase alphabets:");
        char lowercaseAlphabet;
        Map<String, Integer> alphabets = new HashMap<>();
        Map<String, Integer> lowerAlphabets = new HashMap<>();
        Map<String, Integer> upperAlphabets = new HashMap<>();
        Integer i =1;
        for(lowercaseAlphabet = 'a'; lowercaseAlphabet <= 'z'; lowercaseAlphabet++, i++) {
          //  System.out.print(lowercaseAlphabet+" - "+i+" ; ");
            lowerAlphabets.put(String.valueOf(lowercaseAlphabet), i);
        }
        //System.out.println();
        //System. out. println("uppercase alphabets:");
        Integer j =27;
        for(Map.Entry entry:lowerAlphabets.entrySet()){
            String.valueOf(entry.getKey()).toUpperCase();
          //  System.out.print(String.valueOf(entry.getKey()).toUpperCase() +" - "+j+" ; ");
            upperAlphabets.put(String.valueOf(entry.getKey()).toUpperCase(), j);
            j++;
        }
        //System.out.println();
        alphabets.putAll(lowerAlphabets);
        alphabets.putAll(upperAlphabets);
        try {
            scan = new Scanner(inputFile);
            while(scan.hasNext()) {
                s = scan.nextLine();
                input.add(s);
            }
          //  System.out.println("input received");

            //System.out.println(part1(input, alphabets));
            System.out.println(part2(input, alphabets));

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static Integer part1(List<String> input, Map<String, Integer> alphabets) {
        int total = 0;
        List<Integer> commonCharValues = new ArrayList<>();
        String commonCharacter;
        List<String> commonChar = new ArrayList<>();
        for (String line:input) {
            String s1 = line.substring(0,line.length()/2);
            char[] chars = s1.toCharArray();
            String s2 = line.substring(line.length()/2);
            char[] chars2 = s2.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < chars2.length; j++) {
                    if(chars[i] == chars2[j]) {
                        commonCharacter = String.valueOf(chars[i]);
                        //System.out.println(commonCharacter + " - "+Integer.valueOf(alphabets.get(commonCharacter)));
                        if(!commonChar.contains(commonCharacter)) {
                            commonChar.add(commonCharacter);
                            commonCharValues.add(Integer.valueOf(alphabets.get(commonCharacter)));
                            total += Integer.valueOf(alphabets.get(commonCharacter));
                        }
                    }
                }
            }
            commonChar = new ArrayList<>();
        }
        int sum = 0;
        System.out.println(input.size());
        System.out.println(commonCharValues.size());
        for (Integer number:commonCharValues) {
            sum += number;
        }
        System.out.println(sum);
        return total;
    }

    private static Integer part2(List<String> input, Map<String, Integer> alphabets) {
        int total = 0;
        List<Integer> commonCharValues = new ArrayList<>();
        String commonCharacter;
        List<String> groupOfElfs = new ArrayList<>();
        List<List<String>> setOfElfsGroups = new ArrayList<>();
        for (int i=0; i < input.size(); i++) {
            groupOfElfs.add(input.get(i));
            if(groupOfElfs.size() == 3) {
                setOfElfsGroups.add(groupOfElfs);
                groupOfElfs = new ArrayList<>();
            }
        }
        System.out.println(setOfElfsGroups.size());
        List<String> commonChar = new ArrayList<>();
        for (List<String> elfGroup:setOfElfsGroups) {
                String s1 = elfGroup.get(0);
                char[] chars = s1.toCharArray();
                String s2 =  elfGroup.get(1);
                char[] chars2 = s2.toCharArray();
                String s3 =  elfGroup.get(2);
                char[] chars3 = s3.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (int j = 0; j < chars2.length; j++) {
                        for (int k = 0; k < chars3.length; k++) {
                            if(chars[i] == chars2[j] && chars[i] == chars3[k]) {
                                commonCharacter = String.valueOf(chars[i]);
                                if(!commonChar.contains(commonCharacter)) {
                                    //System.out.println(commonCharacter + " - "+Integer.valueOf(alphabets.get(commonCharacter)));
                                    commonChar.add(commonCharacter);
                                    commonCharValues.add(Integer.valueOf(alphabets.get(commonCharacter)));
                                    total += Integer.valueOf(alphabets.get(commonCharacter));
                                }
                            }
                        }
                    }
                }
                commonChar = new ArrayList<>();
            }
        System.out.println(commonCharValues.size());
        return total;
    }
}
