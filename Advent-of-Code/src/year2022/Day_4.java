package year2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day_4 {
    public static final String INPUT_FILE = "D:\\Users\\lakumar\\Desktop\\GIT-Ranjith\\Advent-of-Code\\src\\year2022\\puzzle-4-input.txt";

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
            System.out.println(part1(input));
            System.out.println(part2(input));

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static Integer part1(List<String> input) {
        int total = 0;
        int pl1 =0, pu1=0, pl2=0, pu2=0;
        for (String entryValue:input) {
            String[] s = entryValue.split(",");
            String[] split1 = s[0].split("-");
            pl1 = Integer.valueOf(split1[0]);
            pu1 = Integer.valueOf(split1[1]);
            String[] split2 = s[1].split("-");
            pl2 = Integer.valueOf(split2[0]);
            pu2 = Integer.valueOf(split2[1]);
            if(pl1<=pl2 && pu1>=pu2) {
                total++;
            } else if(pl1>=pl2 && pu1<=pu2) {
                total++;
            } else if(pl1==pl2 && pu1==pu2) {
                total++;
            }
        }
        return total;
    }

    private static Integer part2(List<String> input) {
        int total = 0;
        int pl1 =0, pu1=0, pl2=0, pu2=0;
        for (String entryValue:input) {
            String[] s = entryValue.split(",");
            String[] split1 = s[0].split("-");
            pl1 = Integer.valueOf(split1[0]);
            pu1 = Integer.valueOf(split1[1]);
            String[] split2 = s[1].split("-");
            pl2 = Integer.valueOf(split2[0]);
            pu2 = Integer.valueOf(split2[1]);

            List<Integer> p1 = new ArrayList<>();
            for (int i = pl1;i <=pu1; i++) {
                p1.add(i);
            }
            List<Integer> p2 = new ArrayList<>();
            for (int i = pl2;i <=pu2; i++) {
                p2.add(i);
            }
            boolean isContainsInP2 = false;
            boolean isContainsInP1 = false;
            for (Integer num:p1) {
                isContainsInP2 = p2.contains(num);
            }
            if(isContainsInP2) {
                total++;
            }
            for (Integer num:p2) {
                isContainsInP1 = p1.contains(num);
            }
            if((!isContainsInP2) && isContainsInP1) {
                total++;
            }
        }
        return total;
    }
}
