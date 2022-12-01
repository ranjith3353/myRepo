package year2021;

import dto.Y2021.Bingo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day4Solution {

    public static final String INPUT_FILE = "D:\\Users\\lakumar\\Desktop\\GIT-Ranjith\\Advent-of-Code\\src\\year2021\\puzzle-4-input.txt";

    public static void main(String[] args) {
        String[] inputLine;
        String inputFromFile = "",s="";
        List<Bingo[][]> inputBingos= new ArrayList<>();
        Bingo[][] bingoPuzzle = new Bingo[5][5];
        File inputFile = new File(INPUT_FILE);
        Scanner scan;
        try {
            scan = new Scanner(inputFile);
            inputFromFile = String.valueOf(scan.nextLine());
            String[] bing = inputFromFile.split(",");
            while(scan.hasNext()) {
                scan.nextLine();
                for (int i = 0; i < bingoPuzzle.length; i++) {
                    s = String.valueOf(scan.nextLine()).strip();
                    inputLine = s.split("\\s+");
                    for (int j = 0; j < inputLine.length; j++) {
                        bingoPuzzle[i][j] = new Bingo(inputLine[j]);
                    }
                }
                inputBingos.add(bingoPuzzle);
                bingoPuzzle = new Bingo[5][5];
            }
            System.out.println("input received");
            System.out.println("Part-1 Output: "+ part1(bing, inputBingos));
            System.out.println("Part-2 Output: "+ part2(bing, inputBingos));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int part1(String[] bing, List<Bingo[][]> input) {
        int num;
        for(int i = 0; i< bing.length;i++) {//going through each bing
            num = Integer.valueOf(bing[i]);
            for(int j=0;j < input.size();j++) {//going through each bingo set
                for(int g=0;g<input.get(j).length;g++) {//going through each piece in bingo set
                    for(int h=0;h<input.get(j)[0].length;h++) {
                        if(input.get(j)[g][h].getNumber().equals(String.valueOf(num)))
                            input.get(j)[g][h].setMarked();
                    }
                }
                if (check(input.get(j)))
                    return getSum(input.get(j))*num;
            }
        }
        return 0;
    }

    public static int part2(String[] bing, List<Bingo[][]> input) {
        int num,ans = 0; int counter= input.size();boolean[] skip = new boolean[input.size()];
//		System.out.println(input.size());
        for(int i = 0; i< bing.length;i++) {//going through each bing
            num = Integer.valueOf(bing[i]);
            for(int j=0;j < input.size();j++) {//going through each bingo set
                for(int g=0;g<input.get(j).length;g++) {//going through each piece in bingo set
                    for(int h=0;h<input.get(j)[0].length;h++) {
                        if(input.get(j)[g][h].getNumber().equals(String.valueOf(num)) && !skip[j])
                            input.get(j)[g][h].setMarked();
                    }
                }
                if (check(input.get(j)) && !skip[j]) {
                    counter--;
                    skip[j] = true;
                    if(counter == 0)
                        ans = j;
                }
            }
            if(counter == 0) {
                System.out.println("board is : "+ getSum(input.get(ans)) + "  " +num);
                return getSum(input.get(ans))*num;
            }
        }
        return 0;
    }

    public static boolean check(Bingo[][] input) {
        for(int i=0;i<input.length;i++) {
            final int index = i;
            if(Arrays.stream(input[i]).allMatch(val -> val.isMarked()))
                return true;
            if(Arrays.stream(input).allMatch(val -> val[index].isMarked()))
                return true;
        }
        return false;
    }
    public static int getSum(Bingo[][] input) {
        int sum=0;
        for(int g=0;g<input.length;g++) {//going through each piece in bingo set
            for(int h=0;h<input[0].length;h++) {
                if(!input[g][h].isMarked())
                    sum+= Integer.valueOf(input[g][h].getNumber());
            }
        }
        return sum;
    }
}
