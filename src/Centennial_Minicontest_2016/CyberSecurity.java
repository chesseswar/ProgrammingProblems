package Centennial_Minicontest_2016;

import java.util.*;
import java.io.*;

public class CyberSecurity {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        int numCase = in.nextInt(); in.nextLine();
        while (numCase-- > 0){
            String key = in.nextLine();
            String input = in.nextLine();
            System.out.println(danger(key,input) ? "DANGEROUS" : "SAFE");
        }
    }

    public static boolean danger(String key, String input){
        int count = 0;
        while (input.contains(key)){
            input = input.substring(0,input.indexOf(key)) + input.substring(input.indexOf(key) + key.length(),input.length());
            count++;
            if (count == 10){
                return false;
            }
        }

        return count % 2 != 0;
    }
}
