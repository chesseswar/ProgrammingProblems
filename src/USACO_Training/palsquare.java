/*
ID: chesses1
LANG: JAVA
TASK: palsquare
 */

//package USACO_Training;

import java.util.*;
import java.io.*;

public class palsquare {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new FileWriter("palsquare.out"));

        int base = Integer.parseInt(f.readLine());
        for (int i = 1; i <= 300; i++) {
            System.out.println(i + " " + Integer.toString(i*i,base));
            if (isPal(Integer.toString(i*i,base))) {
                out.println((Integer.toString(i,base).toUpperCase() + " " + Integer.toString(i * i,base).toUpperCase()));
            }
        }

        out.close();
    }

    public static boolean isPal(String str) {
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)) {
                return false;
            }
        }

        return true;
    }
}