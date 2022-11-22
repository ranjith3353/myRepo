package year2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Day3Solution {

    public static final String INPUT_FILE = "D:\\Users\\lakumar\\Desktop\\GIT-Ranjith\\Advent-of-Code\\src\\year2021\\puzzle-3-input.txt";
    public static Scanner reader= new Scanner(System.in);

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        File inputFile = new File(INPUT_FILE);
        Scanner scan;
        try {
            scan = new Scanner(inputFile);
            while(scan.hasNext()) {
                input.add(scan.nextLine());
            }
            System.out.println("input received");

            //System.out.println("Power Consumption: "+part1(input));
            System.out.println("Life Support Rating: "+part2(input));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int part1(List<String> input) {
        String gammaRate="";
        String epsilon="";
        String sample="";
        int inputLength = input.get(0).length();
        int[] count0 = new int[inputLength];
        int[] count1 = new int[inputLength];
        for(int i=0;i < input.size();i++) {
            for (int j=0; j<inputLength; j++){
                sample=String.valueOf(input.get(i).charAt(j));
                //System.out.println("i value: "+i + " and j value: "+j + " and string char value: "+sample);
                if(sample.equals("1"))
                    count1[j]++;
                else
                    count0[j]++;
            }
        }
        /*System.out.println("Total Number of 0's: "+count0[0]);
        System.out.println("Total Number of 1's: "+count1[0]);*/

        for (int i=0; i<inputLength; i++) {
            if(count0[i]<count1[i]) {
                gammaRate += "1";
                epsilon += "0";
            } else {
                gammaRate += "0";
                epsilon += "1";
            }

        }

        return (int) (Long.parseLong(gammaRate, 2) * Long.parseLong(epsilon, 2));
    }

   /* public static int part2(List<String> input) {
        int length = input.get(0).length();
        String oxygen = "", co2 = "";

        int[] count0 = new int[length];
        int[] count1 = new int[length];
        List<String> temp = input.stream().collect(Collectors.toList());
        List<String> number0 = new ArrayList<>();
        List<String> number1 = new ArrayList<>();
        oxygen = oxygenCalculation(length, count0, count1, oxygen, temp, number0, number1);

        number0 = new ArrayList<>();
        number1 = new ArrayList<>();
        temp = input.stream().collect(Collectors.toList());
        count0 = new int[length];
        count1 = new int[length];
        co2 = co2Calculation(length, count0, count1, co2, temp, number0, number1);

        long oxygenRating = Long.parseLong(oxygen, 2);
        long co2Rating = Long.parseLong(co2, 2);
        return (int) (oxygenRating * co2Rating);
    }

    private static String oxygenCalculation(int length, int[] count0, int[] count1, String oxygen, List<String> temp, List<String> number0, List<String> number1) {
        String s;
        for (int j = 0; j< length; j++) {
            for (int i = 0; i < temp.size(); i++) {
                s = String.valueOf(temp.get(i).charAt(j));
                if(s.equals("1")) {
                    count1[j]++;
                    number1.add(temp.get(i));
                } else {
                    count0[j]++;
                    number0.add(temp.get(i));
                }
            }
            *//*System.out.println("Total Number of 0's: "+ count0[j]);
            System.out.println("Total Number of 1's: "+ count1[j]);*//*

            if(count0[j] >= count1[j]) {
                temp = number0;
                if(number0.size() == 1)
                    oxygen = number0.get(0);
            } else {
                temp = number1;
                if(number1.size() == 1)
                    oxygen = number1.get(0);
            }
            number0 = new ArrayList<>();
            number1 = new ArrayList<>();
            count0 = new int[length];
            count1 = new int[length];
        }
        return oxygen;
    }

    private static String co2Calculation(int length, int[] count0, int[] count1, String co2, List<String> temp, List<String> number0, List<String> number1) {
        String s="";
        for (int j = 0; j< length; j++){
            for (int i = 0; i < temp.size(); i++) {
                s = String.valueOf(temp.get(i).charAt(j));
                if(s.equals("1")) {
                    count1[j]++;
                    number1.add(temp.get(i));
                } else {
                    count0[j]++;
                    number0.add(temp.get(i));
                }
            }
            *//*System.out.println("Total Number of 0's: "+ count0[j]);
            System.out.println("Total Number of 1's: "+ count1[j]);*//*

            if(count0[j] >= count1[j]) {
                temp = number1;
                if(number1.size() == 1)
                    co2 = number1.get(0);
            } else {
                temp = number0;
                if(number0.size() == 1)
                    co2 = number0.get(0);
            }
            number0 = new ArrayList<>();
            number1 = new ArrayList<>();
            count0 = new int[length];
            count1 = new int[length];
        }
        return co2;
    }*/

    public static int part2(List<String> input) {
        String oxg="",co2="";
        int len = input.get(0).length();String s="";
        int[] cnt1 = new int[len];
        int[] cnt0 = new int[len];
        List<String> list1 = new LinkedList<String>();
        List<String> list0 = new LinkedList<String>();
        List<String> newinput= input.stream()
                .collect(Collectors.toList());
        for(int j = 0 ;j < len; j++) {
            for(int i=0;i < newinput.size(); i++) {
                s = String.valueOf(newinput.get(i).charAt(j));
                if (s.equals("1")) {
                    cnt1[j]++;
                    list1.add(newinput.get(i));
                }
                else {
                    cnt0[j]++;
                    list0.add(newinput.get(i));
                }
            }
            if (cnt1[j] >= cnt0[j]) {
                newinput = list1;
                if(list1.size() == 1)
                    oxg = list1.get(0);
            }
            else
            {
                newinput = list0;
                if(list0.size() == 1)
                    oxg = list0.get(0);
            }
            list1 = new LinkedList<String>();
            list0 = new LinkedList<String>();
            cnt1 = new int[len];
            cnt0 = new int[len];
        }
        cnt1 = new int[len];
        cnt0 = new int[len];
        list1 = new LinkedList<String>();
        list0 = new LinkedList<String>();
        newinput= input.stream()
                .collect(Collectors.toList());
        for(int j = 0 ;j < len; j++) {
            for(int i=0;i < newinput.size(); i++) {
                s = String.valueOf(newinput.get(i).charAt(j));
                if (s.equals("1")) {
                    cnt1[j]++;
                    list1.add(newinput.get(i));
                }
                else {
                    cnt0[j]++;
                    list0.add(newinput.get(i));
                }
            }
            if (cnt1[j] >= cnt0[j]) {
                newinput = list0;
                if(list0.size() == 1)
                    co2 = list0.get(0);
            }
            else
            {
                newinput = list1;
                if(list1.size() == 1)
                    co2 = list1.get(0);
            }
            list1 = new LinkedList<String>();
            list0 = new LinkedList<String>();
            cnt1 = new int[len];
            cnt0 = new int[len];
        }
        return (int) (Long.parseLong(oxg,2)*Long.parseLong(co2,2));
    }


}
