/*
ID: chesses1
LANG: JAVA
TASK: beads
 */

package USACO_Training;
import java.util.*;
import java.io.*;

public class beads {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new FileWriter("beads.out"));
        int length = Integer.parseInt(f.readLine());
        String necklace = f.readLine();
        int biggest = 0;
        for (int i = 0; i < necklace.length(); i++) {
            if (!(necklace.lastIndexOf('b') > -1 || necklace.lastIndexOf('r') > -1)) {
                biggest = necklace.length();
                break;
            }

            int count = beads(split(i,necklace));
            if (beads(reverse(split(i, necklace))) > length - count) {
                biggest = necklace.length();
                break;
            } else {
                count += beads(reverse(split(i,necklace)));
            }

            if (count > biggest) {
                biggest = count;
            }
        }

        out.println(biggest);
        out.close();
        f.close();
    }

    public static int beads(String necklace) {
        int index = 1;
        char start = necklace.charAt(0);
        if (start == 'w') {
            int i = 1;
            while (i < necklace.length() && necklace.charAt(i) == 'w') {
                i++;
            }

            start = necklace.charAt(i);
        }



        while (index < necklace.length() && (necklace.charAt(index) == start || necklace.charAt(index) == 'w')) {
            index++;
        }

        return index;
    }

    public static String reverse(String input) {
        String output = "";
        for (int i = input.length()-1; i > -1; i--) {
            output += input.charAt(i);
        }
        return output;
    }

    public static String split(int index, String necklace) {
        return necklace.substring(index) + necklace.substring(0,index);
    }
}