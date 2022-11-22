package year2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day2Solution {

    public static final String INPUT_FILE = "D:\\Users\\lakumar\\Desktop\\GIT-Ranjith\\Advent-of-Code\\src\\year2021\\puzzle-2-input.txt";
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

            System.out.println(part1(input));
            System.out.println(part2(input));

            //executePart1(input);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void executePart1(List<String> input) {
        int horizontal_position = 0;
        int depth = 0;

        int up=0;
        int down=0;
        int forward=0;

        for (int i = 0; i < input.size(); i++) {
            String[] arr = input.get(i).split("\\s");
            if(arr[0].equals("forward")) {
                horizontal_position+=Integer.valueOf(arr[1]);
                forward+=Integer.valueOf(arr[1]);
                System.out.println(" - horizontal_position: "+horizontal_position);
            } else if(arr[0].equals("down")){
                depth+=Integer.valueOf(arr[1]);
                down+=Integer.valueOf(arr[1]);
                System.out.println(" - depth: "+depth);
            } else if(arr[0].equals("up")){
                depth-=Integer.valueOf(arr[1]);
                down+=Integer.valueOf(arr[1]);
                System.out.println(" - depth: "+depth);
            }
        }
        int finalValue =  horizontal_position * depth;

        System.out.println("Forward Value: "+forward);
        System.out.println("Down Value: "+down);
        System.out.println("UP Value: "+up);
        System.out.println("Depth Value: "+depth);
        System.out.println("Position Value: "+horizontal_position);
        System.out.println("Total Value: "+finalValue);
    }

    public static int part1(List<String> input) {
        int foward=0;
        int depth =0;
        for(int i=0;i < input.size();i++) {
            String[] arr = input.get(i).split("\\s");
            if(arr[0].equals("forward"))
                foward+= Integer.valueOf(arr[1]);
            else
            if(arr[0].equals("down"))
                depth+= Integer.valueOf(arr[1]);
            else
            if(arr[0].equals("up"))
                depth-= Integer.valueOf(arr[1]);
        }
        return depth*foward;
    }

    public static int part2(List<String> input) {
        int forward=0;
        int depth =0;
        int aim =0;
        for(int i=0;i < input.size();i++) {
            String[] arr = input.get(i).split("\\s");
            if(arr[0].equals("forward")) {
                forward+= Integer.valueOf(arr[1]);
                depth+= aim*Integer.valueOf(arr[1]);
            }
            else if(arr[0].equals("down")) {
                aim += Integer.valueOf(arr[1]);
            }
            else if(arr[0].equals("up"))
                aim-= Integer.valueOf(arr[1]);
        }
        System.out.println("Final Horizontal position: "+forward);
        System.out.println("Final Aim: "+aim);
        System.out.println("Final Depth: "+depth);
        return depth*forward;
    }

}
