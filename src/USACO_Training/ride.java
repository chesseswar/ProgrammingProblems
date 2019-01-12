/*
ID: chesses1
LANG: JAVA
TASK: ride
*/

//package USACO_Training;

import java.util.*;
import java.io.*;

public class ride {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new FileWriter("ride.out"));
        String x = f.readLine();
        String y = f.readLine();
        int a = 1;
        for (char c : x.toCharArray()) {
            a *= c-64;
        }
        a %= 47;
        int b = 1;
        for (char c : y.toCharArray()) {
            b *= c-64;
        }
        b %= 47;
        out.println(a==b ? "GO" : "STAY");
        out.close();
    }
}
