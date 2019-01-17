/*
ID: chesses1
LANG: JAVA
TASK: crypt1
 */

package USACO_Training;

import java.util.*;
import java.io.*;

public class crypt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
        //BufferedReader f = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("crypt1.out"));
        int setSize = Integer.parseInt(f.readLine());
        int[] set = new int[setSize];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int i = 0; i < setSize; i++) {
            set[i] = Integer.parseInt(st.nextToken());
        }
    }

    //public
}
