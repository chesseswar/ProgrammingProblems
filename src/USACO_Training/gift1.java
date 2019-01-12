/*
ID: chesses1
LANG: JAVA
TASK: gift1
 */
//package USACO_Training;

import java.io.*;
import java.util.*;

public class gift1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new FileWriter("gift1.out"));
        int np = Integer.parseInt(f.readLine());
        String[] ppl = new String[np];
        HashMap<String,Integer> people = new HashMap<>();
        for (int i = 0; i < np; i++) {
            ppl[i] = f.readLine();
            people.put(ppl[i],0);
        }

        String giver = f.readLine();
        while(giver != null) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int money = Integer.parseInt(st.nextToken());
            int numPpl = Integer.parseInt(st.nextToken());
            if (numPpl > 0) {
                people.put(giver,people.get(giver) - money + money % numPpl);
                money /= numPpl;
                for (int i = 0; i < numPpl; i++) {
                    String receiver = f.readLine();
                    people.put(receiver,people.get(receiver) + money);
                }
            } else {
                people.put(giver,people.get(giver) + money);
            }

            giver = f.readLine();
        }

        for (String s : ppl) {
            out.println(s + " " + people.get(s));
        }
        out.close();
    }
}
