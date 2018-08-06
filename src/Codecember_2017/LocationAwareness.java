package Codecember_2017;

import java.util.*;
import java.io.*;

public class LocationAwareness {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        double s1 = in.nextDouble();
        double s2 = in.nextDouble();
        double s3 = in.nextDouble();

        while (s1 != 0 || s2 != 0 || s3 != 0){

            double d1d2Ratio = Math.sqrt(s1/s2); //d2 = d1 * sqrt(s1/s2)
            double d2d3Ratio = Math.sqrt(s2/s3); //d3 = d2 * sqrt(s2/s3)
            Vector<Integer> answer = answer(d1d2Ratio,d2d3Ratio);
            System.out.println(answer.get(0) + " " + answer.get(1));


            s1 = in.nextDouble();
            s2 = in.nextDouble();
            s3 = in.nextDouble();
        }
    }

    public static double dist(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow((x1 - x2),2) + Math.pow((y1-y2),2));
    }

    public static Vector<Integer> answer(double d1d2, double d2d3){
        for (int x = -99; x < 100; x++){
            for (int y = 99; y > -100; y--){
                double r1 = dist(x,y,-100,-100)/dist(x,y,0,100);
                double r2 = dist(x,y,100,-100)/dist(x,y,-100,-100);

                if (Math.abs(r1-d1d2) < .002 && Math.abs(r2-d2d3) < .002){
                    Vector<Integer> v = new Vector<>();
                    v.add(x); v.add(y);
                    return v;
                }
            }
        }

        return null;
    }
}
