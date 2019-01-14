/*
ID: chesses1
LANG: JAVA
TASK: barn1
 */
//package USACO_Training;

import java.io.*;
import java.util.*;

public class barn1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter out = new PrintWriter(new FileWriter("barn1.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int maxBoards = Integer.parseInt(st.nextToken());
        int totalStalls = Integer.parseInt(st.nextToken());
        int numCows = Integer.parseInt(st.nextToken());
        int[] occupiedStalls = new int[numCows];
        for (int i = 0; i < numCows; i++) {
            occupiedStalls[i] = Integer.parseInt(f.readLine());
        }

        Arrays.sort(occupiedStalls);
        PriorityQueue<Gap> unoccupiedStalls = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < numCows; i++) {
            if (occupiedStalls[i] - 1 > occupiedStalls[i-1]) {
                unoccupiedStalls.add(new Gap(occupiedStalls[i-1] + 1, occupiedStalls[i]-1));
            }
        }

        int numBoards = 1;
        int stallsCovered = occupiedStalls[numCows-1] - occupiedStalls[0] + 1;
        while (unoccupiedStalls.size() > 0 && numBoards < maxBoards) {
            stallsCovered -= unoccupiedStalls.peek().end - unoccupiedStalls.poll().start + 1;
            numBoards++;
        }

        out.println(stallsCovered);
        out.close();
    }

    public static class Gap implements Comparable<Gap>{
        public int start, end;

        public Gap(int s, int e) {
            start = s;
            end = e;
        }

        public int compareTo(Gap other) {
            return (end - start) - (other.end - other.start);
        }
    }
}
