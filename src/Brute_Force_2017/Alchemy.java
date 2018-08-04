package Brute_Force_2017;

import java.util.*;
import java.io.*;

public class Alchemy {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        HashMap<String,Double> conversions = new HashMap<>();
        int numConvert = in.nextInt();
        for (int i = 0; i < numConvert; i++){
            conversions.put(in.next(),in.nextDouble());
        }

        int numCase = in.nextInt();
        while (numCase-- > 0){
            String input = in.next();
            System.out.println(input + " " + conversions.get(input) * in.nextDouble());
        }
    }
}
