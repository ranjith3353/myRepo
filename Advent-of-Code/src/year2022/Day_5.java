package year2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day_5 {

    public static final String INPUT_FILE = "D:\\Users\\lakumar\\Desktop\\GIT-Ranjith\\Advent-of-Code\\src\\year2022\\puzzle-5-input.txt";

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

            System.out.println(result(input));

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static String result(List<String> input) {
        LinkedList<Stack<String>> stackList = new LinkedList<>();
        LinkedList<Stack<String>> arrangedStackList = new LinkedList<>();
        String outputMessage = "";
        for (int i = 0; i < 9; i++) {
            stackList.add(new Stack<>());
        }
        List<String> actions = new ArrayList<>();
        for (String line:input) {
            if(!line.equals("") && !line.startsWith("m")) {
                String []s = line.split("");
                int j = 0;
                for (int i = 0; i < s.length-1; i +=4) {
                    if(s[i+1].equals("9")) {
                        stackList.get(j).add(s[i].concat(s[i+1]));
                    } else {
                        String concat = s[i].concat(s[i + 1]).concat(s[i + 2]);
                        if(!concat.equals("   ")) {
                            stackList.get(j).add(concat);
                        }
                    }
                    if(j < stackList.size()){
                        j++;
                    }
                }
            }
            else {
                actions.add(line);
            }
        }
        Stack<String> stack;
        arrangeStacks(stackList, arrangedStackList);
        System.out.println(stackList.size() + " & "+actions.size());
        for (String line: actions) {
            String []s = line.split("");
            if(line!="") {
                int quantity=0, fromStack=0, toStack=0;
                if(s.length == 18) {
                    quantity = Integer.valueOf(line.substring(5,6));
                    fromStack = Integer.valueOf(line.substring(12,13));
                    toStack = Integer.valueOf(line.substring(17,18));
                } else if(s.length == 19) {
                    quantity = Integer.valueOf(line.substring(5,7));
                    fromStack = Integer.valueOf(line.substring(13,14));
                    toStack = Integer.valueOf(line.substring(18,19));
                }

                //part-1 solution
                for (int i = 0; i < quantity; i++) {
                    Stack<String> strings = arrangedStackList.get(fromStack - 1);
                    String pop = strings.pop();
                    arrangedStackList.get(toStack-1).push(pop);
                }

                //part-2 solution change is below commented lines
                /*Stack<String> tempStack = new Stack<>();
                for (int i = 0; i < quantity; i++) {
                    Stack<String> strings = arrangedStackList.get(fromStack - 1);
                    String pop = strings.pop();
                    tempStack.push(pop);
                }
                for (int i = tempStack.size()-1; i >= 0; i--) {
                    Stack<String> strings = arrangedStackList.get(toStack - 1);
                    strings.push(tempStack.get(i));
                }*/
            }
        }
        LinkedList<Stack<String>> finalStackList = new LinkedList<>();
        Stack<String> temStack;
        for (Stack<String> tempStack:arrangedStackList) {
            temStack = new Stack<>();
            temStack.push(tempStack.pop());
            finalStackList.add(temStack);
        }

        for(int i = 0; i < finalStackList.size(); i++) {
            Stack<String> strings = finalStackList.get(i);
            String pop = strings.pop();
            //outputMessage = outputMessage.concat(pop);
            if(pop.equals("   ")) {
                pop = strings.pop();
            } if (pop.startsWith("[")) {
                outputMessage = outputMessage.concat(pop.substring(1,2));
            }
        }
        return outputMessage;
    }

    private static void arrangeStacks(LinkedList<Stack<String>> stackList, LinkedList<Stack<String>> finalStackList) {
        Stack<String> stack;
        for (Stack<String> tempStack:stackList) {
            stack = new Stack<>();
            for (int i = tempStack.size()-2; i >= 0; i--) {
                stack.push(tempStack.get(i));
            }
            finalStackList.add(stack);
        }
    }
}
