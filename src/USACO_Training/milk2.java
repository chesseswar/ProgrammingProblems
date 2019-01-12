/*
ID: chesses1
LANG: JAVA
TASK: milk2
 */

package USACO_Training;

import java.util.*;
import java.io.*;

public class milk2 {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("input.txt"));
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new FileWriter("milk2.out"));
        int numCows = Integer.parseInt(f.readLine());
        PriorityQueue<Interval> farmers = new PriorityQueue<>();
        for (int i = 0; i < numCows; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            farmers.add(new Interval(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Integer> longestTime = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> longestIdle = new PriorityQueue<>(Collections.reverseOrder());
        int start = farmers.peek().start;
        int end = farmers.peek().end;
        int currentEnd = end;
        farmers.poll();
        while (farmers.size() > 0) {
            Interval i = farmers.poll();
            if (i.start <= end) {
                end = Math.max(end,i.end);
                currentEnd = end;
            } else {
                longestIdle.add(i.start - end);
                longestTime.add(end - start);
                end = i.end;
                start = i.start;
            }
        }

        longestTime.add(end-start);

        out.println(longestTime.peek() + " " + (longestIdle.peek() != null ? longestIdle.peek() : 0));
        out.close();
    }

    public static class Interval implements Comparable<Interval> {
        public int start, end;
        public Interval(int s, int e) {
            start = s;
            end = e;
        }

        public int compareTo(Interval other) {
            return start - other.start;
        }
    }
}
