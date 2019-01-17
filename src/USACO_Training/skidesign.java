/*
ID: chesses1
LANG: JAVA
TASK: skidesign
 */

//package USACO_Training;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class skidesign {
    static int n;
    static int[] heights;
    public static void main(String[] args) throws IOException {
        FastReader f = new FastReader("skidesign.in");
        PrintWriter out = new PrintWriter(new FileWriter("skidesign.out"));
        n = f.nextInt();
        heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = f.nextInt();
        }

        Arrays.sort(heights);
        if (heights[n-1] - heights[0] > 17) {
            PriorityQueue<Integer> costs = new PriorityQueue<>();
            for (int i = 0; i < heights[n-1]-17; i++) {
                costs.add(cost(i));
            }

            out.println(costs.peek());
        } else {
            out.println(0);
        }

        out.close();
    }

    static int cost(int lowerBound) {
        int upperBound = lowerBound + 17;
        int cost = 0;
        //System.out.println(lowerBound + " " + upperBound);
        for (int h : heights) {
            if (h > upperBound) {
                //System.out.println(h);
                cost += (upperBound-h)*(upperBound-h);
            } else if (h < lowerBound) {
                //System.out.println(h);
                cost += (lowerBound-h)*(lowerBound-h);
            }
        }

        return cost;
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
            } catch (IOException e) {
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
