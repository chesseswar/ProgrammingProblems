/*
ID: chesses1
LANG: JAVA
TASK: milk
 */

//package USACO_Training;

import java.util.*;
import java.io.*;

public class milk {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk.in"));
        PrintWriter out = new PrintWriter(new FileWriter("milk.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int unitsNeeded = Integer.parseInt(st.nextToken());
        int numFarmers = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> prices = new PriorityQueue<>();
        HashMap<Integer,Integer> pricesAndUnits = new HashMap<>();
        for (int i = 0; i < numFarmers; i++) {
            st = new StringTokenizer(f.readLine());
            int price = Integer.parseInt(st.nextToken());
            int units = Integer.parseInt(st.nextToken());
            if (pricesAndUnits.containsKey(price)) {
                pricesAndUnits.put(price,pricesAndUnits.get(price) + units);
            } else {
                prices.add(price);
                pricesAndUnits.put(price,units);
            }
        }

        int cost = 0;
        int unitsBought = 0;
        while (unitsBought < unitsNeeded) {
            int lowestPrice = prices.poll();
            int units = Math.min(unitsNeeded-unitsBought, pricesAndUnits.get(lowestPrice));
            unitsBought += units;
            cost += units * lowestPrice;
        }


        out.println(cost);
        out.close();
    }


}
