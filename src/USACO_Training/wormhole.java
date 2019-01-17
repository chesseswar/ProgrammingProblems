/*
ID: chesses1
LANG: JAVA
TASK: wormhole
 */

package USACO_Training;

import java.io.*;
import java.util.*;

public class wormhole {
    static int n;
    static int[] x, y, pairs, neighbor;
    public static void main(String[] args) throws IOException {
        FastReader f = new FastReader("wormhole.in");
        PrintWriter out = new PrintWriter(new FileWriter("wormhole.out"));
        n = f.nextInt();
        x = new int[n+1];
        y = new int[n+1];
        pairs = new int[n+1];
        neighbor = new int[n+1];
        for (int i = 1; i <= n; i++) {
            x[i] = f.nextInt();
            y[i] = f.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (y[i] == y[j] && x[i] < x[j]) {
                    if (neighbor[i] == 0 || x[neighbor[i]] - x[i] > x[j] - x[i]) {
                        neighbor[i] = j;
                    }
                }
            }
        }


        out.println(answer());
        out.close();
    }

    static boolean hasCycle() {
        for (int i = 1; i <= n; i++) {
            int position = i;
            for (int steps = 0; steps <= n; steps++) {
                position = pairs[neighbor[position]];
            }

            if (position != 0) {
                return true;
            }
        }
        return false;
    }
    static int answer() {
        int i, output = 0;
        for (i = 1; i <= n; i++) {
            if (pairs[i] == 0) {
                break;
            }
        }

        if (i > n) {
            if (hasCycle()) {
                return 1;
            } else {
                return 0;
            }
        }

        for (int j = i+1; j <= n; j++) {
            if (pairs[j] == 0) {
                pairs[i] = j;
                pairs[j] = i;
                output += answer();
                pairs[i] = 0;
                pairs[j] = 0;
            }
        }

        return output;
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

