package year2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day_7 {
    public static final String INPUT_FILE = "D:\\Users\\lakumar\\Desktop\\GIT-Ranjith\\Advent-of-Code\\src\\year2022\\puzzle-7-input.txt";

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
                /*if(s.startsWith("dir")) {
                    System.out.println(s);
                }*/
            }
            System.out.println("input received");

            System.out.println(part1(input));

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static Integer part1(List<String> input) {
        int total = 0, filesSize = 0;
        Map<String, Integer> directoryFilesTotalSize = new HashMap<>();
        Map<String, List<String>> mapofDirectories = new HashMap<>();
        Map<String, Integer> fileSizes = new HashMap<>();
        List<String> directoryDetails = new ArrayList<>();
        String directory = input.get(0).substring(5);
        directoryDetails.add(input.get(0));
        for (int i = 0; i<input.size(); i++) {
            String s = input.get(i);
            if (s.startsWith("$ cd")) {
                directoryDetails = new ArrayList<>();
                directory = s.substring(5);
                filesSize = 0;
            }
            if(!(s.startsWith("$ cd") || s.startsWith("$ ls") || s.startsWith("dir"))) {
                String[] split = s.split(" ");
                String s1 = split[0];
                filesSize += Integer.valueOf(s1);
            }
            directoryDetails.add(s);
            mapofDirectories.put(directory, directoryDetails);
            fileSizes.put(directory, filesSize);

        }
        Map<String, List<String>> temp = new HashMap<>();
        temp.putAll(mapofDirectories);
        /*for (Map.Entry entry:mapofDirectories.entrySet()) {
            int sum = 0;
            String key = (String) entry.getKey();
            //System.out.println("Directory: "+ key +" & files size: "+fileSizes.get(key));
            List<String> value = (List<String>) entry.getValue();
            //value.forEach(System.out::println);
            for (String line:value) {
                if(line.startsWith("dir")) {
                    String substring = line.substring(4);
                    Integer sum1 = fileSizes.get(substring);
                    if(sum1 != null) {
                        sum += sum1;
                    }
                }
            }
            sum += fileSizes.get(key);
            directoryFilesTotalSize.put(key, sum);
            //System.out.println("Directory: "+ key +" & Total Directory Size: "+sum);
            //System.out.println("========================================================");
        }*/
        int count = 0;
        for (Map.Entry entry:fileSizes.entrySet()) {
            Integer value = (Integer) entry.getValue();
            if(value.intValue() <= 100000) {
                total += value;
                count++;
                System.out.println("Directory: "+ entry.getKey() +" & Total Directory Size: "+value);
            }
        }
        System.out.println("Total count: "+ count);
         return total;
    }
}
