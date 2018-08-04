package Cen10_Misc;

import java.util.*;
import java.io.*;

public class Autocomplete {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        int numItems = in.nextInt(); in.nextLine();
        String[] items = new String[numItems];
        for (int i = 0; i < numItems; i++){
            items[i] = in.nextLine();
        }

        String input = in.nextLine();
        ArrayList<String> output = new ArrayList<>();
        for (String str : items){
            if (str.substring(0,input.length()).equals(input)){
                output.add(str);
            }
        }

        Collections.sort(output);
        for (String str : output) {
            System.out.println(str);
        }
    }
}
