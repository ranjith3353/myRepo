package year2022;

import dto.Y2022.ElfsDto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day_1 {


    public static final String INPUT_FILE = "D:\\Users\\lakumar\\Desktop\\GIT-Ranjith\\Advent-of-Code\\src\\year2022\\puzzle-1-input.txt";
    public static void main(String args[]){
        List<Integer> totalCalories = new ArrayList<>();
        List<ElfsDto> elfsDtos = new ArrayList<>();
        String s="";
        File inputFile = new File(INPUT_FILE);
        Scanner scan;
        try {
            scan = new Scanner(inputFile);
            ElfsDto elf = new ElfsDto();
            while(scan.hasNext()) {
                s = scan.nextLine();
                if(!s.equals("")) {
                    elf.getCalories().add(Integer.valueOf(s));
                } else {
                    int total = 0;
                    for (int i = 0; i < elf.getCalories().size(); i++) {
                       total += elf.getCalories().get(i);
                    }
                    elf.setTotalCalories(total);
                    elfsDtos.add(elf);
                    elf = new ElfsDto();
                }

            }
            System.out.println("input received");
            int i = 0;
            for (ElfsDto elfsDto : elfsDtos) {
                //System.out.println("Elf-"+String.valueOf(i)+" total calories: "+elfsDto.getTotalCalories());
                totalCalories.add(elfsDto.getTotalCalories());
                i++;
            }


            Collections.sort(totalCalories);
            int max = totalCalories.get(0);
            for (int j = 1; j <= totalCalories.size()-1; j++) {
                if(max < totalCalories.get(j)){
                    max = totalCalories.get(j);
                    //System.out.println("Max :"+ max);
                }
            }
            System.out.println("Part-1 -> Max Calories carried by Elf:"+ max);
            Collections.sort(totalCalories);
            int sumOf3 = (totalCalories.get(totalCalories.size()-1))+(totalCalories.get(totalCalories.size()-2))+(totalCalories.get(totalCalories.size()-3));
            System.out.println("Part-1 -> Max Calories carried by 3 Elfs:"+ sumOf3);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
