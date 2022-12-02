package year2022;

import dto.Y2022.ElfsDto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day_2 {

    public static final String INPUT_FILE = "D:\\Users\\lakumar\\Desktop\\GIT-Ranjith\\Advent-of-Code\\src\\year2022\\puzzle-2-input.txt";

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
        int roundTotal = 0;
        int selectionValue;
        int win = 6,draw = 3,lose=0;
        for (String line:input) {
            String[] s = line.split(" ");
            // A,X - Rock -1 ; B,Y - Paper - 2; C,Z - Scissors - 3
            // Win - 6, Draw - 3, Lost - 0

            for (int i = 0; i < s.length; i+=2) {
                if(s[i].equals("A") && s[i+1].equals("X")){
                    selectionValue = 1;
                    roundTotal = draw+selectionValue;
                }
                if(s[i].equals("A") && s[i+1].equals("Y")){
                    selectionValue = 2;
                    roundTotal = win+selectionValue;
                }
                if(s[i].equals("A") && s[i+1].equals("Z")){
                    selectionValue = 3;
                    roundTotal = lose+selectionValue;
                }
                if(s[i].equals("B") && s[i+1].equals("X")){
                    selectionValue = 1;
                    roundTotal = lose+selectionValue;
                }
                if(s[i].equals("B") && s[i+1].equals("Y")){
                    selectionValue = 2;
                    roundTotal = draw+selectionValue;
                }
                if(s[i].equals("B") && s[i+1].equals("Z")){
                    selectionValue = 3;
                    roundTotal = win+selectionValue;
                }
                if(s[i].equals("C") && s[i+1].equals("X")){
                    selectionValue = 1;
                    roundTotal = win+selectionValue;
                }
                if(s[i].equals("C") && s[i+1].equals("Y")){
                    selectionValue = 2;
                    roundTotal = lose+selectionValue;
                }
                if(s[i].equals("C") && s[i+1].equals("Z")){
                    selectionValue = 3;
                    roundTotal = draw+selectionValue;
                }
            }
            total += roundTotal;
        }
        return total;
    }

    private static Integer part2(List<String> input) {
        int total = 0;
        int roundTotal = 0;
        int selectionValue;
        int win = 6,draw = 3,lose=0;
        for (String line:input) {
            String[] s = line.split(" ");
            // A,X - Rock -1 ; B,Y - Paper - 2; C,Z - Scissors - 3
            // Win(Z) - 6, Draw(Y) - 3, Lost(X) - 0

            for (int i = 0; i < s.length; i+=2) {
                if(s[i].equals("A") && s[i+1].equals("X")){
                    //As we have X, we need to lose - so, assuming to convert X to Z
                    selectionValue = 3;
                    roundTotal = lose+selectionValue;
                }
                if(s[i].equals("A") && s[i+1].equals("Y")){
                    //As we have Y, we need to draw - so, assuming to convert Y to X
                    selectionValue = 1;
                    roundTotal = draw+selectionValue;
                }
                if(s[i].equals("A") && s[i+1].equals("Z")){
                    //As we have Z, we need to win - so, assuming to convert Z to Y
                    selectionValue = 2;
                    roundTotal = win+selectionValue;
                }
                if(s[i].equals("B") && s[i+1].equals("X")){
                    //As we have X, we need to lose
                    selectionValue = 1;
                    roundTotal = lose+selectionValue;
                }
                if(s[i].equals("B") && s[i+1].equals("Y")){
                    //As we have Y, we need to draw
                    selectionValue = 2;
                    roundTotal = draw+selectionValue;
                }
                if(s[i].equals("B") && s[i+1].equals("Z")){
                    //As we have Z, we need to win
                    selectionValue = 3;
                    roundTotal = win+selectionValue;
                }
                if(s[i].equals("C") && s[i+1].equals("X")){
                    //As we have X, we need to lose - so, assuming to convert X to Y
                    selectionValue = 2;
                    roundTotal = lose+selectionValue;
                }
                if(s[i].equals("C") && s[i+1].equals("Y")){
                    //As we have Y, we need to draw - so, assuming to convert Y to Z
                    selectionValue = 3;
                    roundTotal = draw+selectionValue;
                }
                if(s[i].equals("C") && s[i+1].equals("Z")){
                    //As we have Z, we need to win - so, assuming to convert Z to X
                    selectionValue = 1;
                    roundTotal = win+selectionValue;
                }
            }
            total += roundTotal;
        }
        return total;
    }
}
