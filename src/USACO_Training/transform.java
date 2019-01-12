/*
ID: chesses1
LANG: JAVA
TASK: transform
 */

//package USACO_Training;

import java.io.*;
import java.util.*;

public class transform {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("input.txt"));
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new FileWriter("transform.out"));
        int n = Integer.parseInt(f.readLine());
        char[][] original = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = f.readLine();
            for (int j = 0; j < n; j++) {
                original[i][j] = line.charAt(j);
            }
        }

        char[][] transformed = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = f.readLine();
            for (int j = 0; j < n; j++) {
                transformed[i][j] = line.charAt(j);
            }
        }

        out.println(answer(original, transformed, false));
        out.close();
    }

    public static int answer(char[][] original, char[][] transformed, boolean reflected) {
        if (compare(transformed, ninety(original))) {
            return reflected ? 5 : 1;
        } else if (compare(transformed, ninety(ninety(original)))) {
            return reflected ? 5 : 2;
        } else if (compare(transformed, ninety(ninety(ninety(original))))) {
            return reflected ? 5 : 3;
        } else if (compare(transformed, reflect(original))) {
            return reflected ? 5 : 4;
        } else if (!reflected) {
            return answer(reflect(original), transformed, true);
        } else if (compare(transformed, original)){
            return 6;
        } else {
            return 7;
        }
    }

    public static void print(char[][] input) {
        for (char[] c : input) {
            for (char x : c) {
                System.out.print(x);
            }
            System.out.println();
        }
    }

    public static char[][] reflect(char[][] input) {
        char[][] output = new char[input.length][input.length];
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output.length; j++) {
                output[i][j] = input[i][input.length-1-j];
            }
        }

        return output;
    }

    public static char[][] ninety(char[][] input) {
        char[][] output = new char[input.length][input.length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                output[i][j] = input[input.length - 1 - j][i];
            }
        }

        return output;
    }

    public static Boolean compare(char[][] original, char[][] transform) {
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[0].length; j++) {
                if (original[i][j] != transform[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
