/*
ID: chesses1
LANG: JAVA
TASK: ariprog
 */

//package USACO_Training;

import java.io.*;
import java.util.*;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.PriorityQueue;

public class ariprog {
    static int n, m;
    static PriorityQueue<ArithmeticSequence> sequences;
    static boolean[] bisquares;
    public static void main(String[] args) throws IOException {
        FastReader f = new FastReader("ariprog.in");
        PrintWriter out = new PrintWriter("ariprog.out");
        n = f.nextInt();
        m = f.nextInt();
        //n = 3; m = 2;
        sequences = new PriorityQueue<>();
        bisquares = new boolean[251 * 251 * 2];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j<= m; j++) {
                bisquares[(i * i + j * j)] = true;
            }
        }
        //System.out.println(bisquares);

        for (int i = 0; i < 2 * m * m; i++) { //starting value
            if (bisquares[i]) {
                for (int j = 1; i + (n-1) * j <= 2 * m * m ; j++) { //increment
                    if (check(i, j)) {
                        sequences.add(new ArithmeticSequence(i, j));
                    }
                }
            }
        }

        if (sequences.size() > 0) {
            while (sequences.size() > 0) {
                out.println(sequences.poll());
            }
        } else {
            out.println("NONE");
        }

        out.close();
    }

    static boolean check(int a, int b) {
        int index = 0;
        while (index < n) {
            if (!bisquares[(a + b * index)]) {
                return false;
            }
            index++;
        }

        return true;
    }

    static class ArithmeticSequence implements Comparable<ArithmeticSequence> {
        int a, b;

        public ArithmeticSequence(int a, int b) {
            this.a =a;
            this.b =b;
        }

        public int compareTo(ArithmeticSequence other) {
            if (b != other.b) {
                return b - other.b;
            } else {
                return a - other.a;
            }
        }

        public String toString() {
            return a + " " + b;
        }
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader(String file) {
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException  e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

