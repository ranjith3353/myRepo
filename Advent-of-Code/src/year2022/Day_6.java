package year2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

            //System.out.println(part1(input));

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
