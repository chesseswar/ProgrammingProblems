package Cen10_Club_Meeting;

import java.util.*;
import java.io.*;

public class GoingDown {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        int numCase = in.nextInt();
        while (numCase-- > 0){
            int input = in.nextInt();
            int temp = input;
            input *= 2;
            while (!decreasing(input)){
                input += temp;
            }
            System.out.println(input);
        }
    }

    public static boolean decreasing(int input){
        char[] digs = Integer.toString(input).toCharArray();
        for (int i = 0; i < digs.length-1; i++){
            if (digs[i+1] > digs[i]){
                return false;
            }
        }
        return true;
    }
}
