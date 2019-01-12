/*
ID: chesses1
LANG: JAVA
TASK: dualpal
 */

//package USACO_Training;

import java.util.*;
import java.io.*;
public class dualpal {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new FileWriter("dualpal.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken())+1;
        int count = 0;
        while (count < n) {
            if (isDualPal(s)) {
                out.println(s);
                count++;
            }
            s++;
        }
        out.close();
    }

    public static boolean isDualPal(int s) {
        int count = 0;
        for (int i = 2; i <= 10; i++) {
            if (isPal(Integer.toString(s,i))) {
                count++;
            }

            if (count > 1) {
                return true;
            }
        }

        return false;
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
