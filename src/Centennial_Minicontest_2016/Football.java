package Centennial_Minicontest_2016;

import java.util.*;
import java.io.*;

public class Football {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        HashMap<String,Integer> scores = new HashMap<>();
        HashMap<String,Integer> add = new HashMap<>();
        add.put("TOUCHDOWN",6);
        add.put("EXTRAPOINT",1);
        add.put("FIELDGOAL",3);
        add.put("CONVERSION",2);
        String first = in.next();
        scores.put(first,0);
        String second = in.next();
        scores.put(second,0);
        String input = in.next();
        String team = in.next();
        while (!input.equals("0")){
            if (!input.equals("SAFETY")){
                scores.put(team,scores.get(team) + add.get(input));
            } else if (team.equals(first)){
                scores.put(second,scores.get(second) + 2);
            } else {
                scores.put(first,scores.get(first) + 2);
            }

            input = in.next();
            team = in.next();
        }

        if (scores.get(first) > scores.get(second)){
            System.out.println(first + " " + scores.get(first));
        } else if (scores.get(first) == scores.get(second)){
            System.out.println("TIE " + scores.get(first));
        } else {
            System.out.println(second + " " + scores.get(second));
        }

    }
}
