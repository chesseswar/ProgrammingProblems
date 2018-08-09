package Reedy_Codescrim_Difficult;

import java.util.*;
import java.io.*;

public class LinearSolitaire {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        int count = 1;
        while (in.hasNext()){
            System.out.print("Case " + count + ": ");
            String input = in.next();
            ArrayDeque<String> queue = new ArrayDeque<>();
            queue.add(input);
            boolean done = false;
            while (queue.size() > 0){
                String current = queue.poll();
                if (current.contains("1") && current.lastIndexOf("1") == current.indexOf("1")){
                    System.out.println("yes");
                    done = true;
                    break;
                }

                for (String s : moves(current)){
                    queue.add(s);
                }
            }

            if (!done){
                System.out.println("no");
            }
            count++;
        }
    }

    public static ArrayList<String> moves(String current){
        ArrayList<String> output = new ArrayList<>();
        String pos1 = "011";
        String pos2 = "110";
        for (int i = 0; i < current.length()-3; i++){
            if (current.substring(i,i+3).equals(pos1)){
                output.add(current.substring(0,i) + "100" + current.substring(i+3));
            } else if (current.substring(i,i+3).equals(pos2)){
                output.add(current.substring(0,i) + "001" + current.substring(i+3));
            }
        }

        return output;
    }
}