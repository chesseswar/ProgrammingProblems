package Brute_Force_2017;

import java.util.*;
import java.io.*;

public class AlgosRhythm {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);

        int numCase = in.nextInt();
        int[] notes = new int[]{1,2,4};
        while (numCase-- > 0){
            int[] dp = new int[in.nextInt()+1];
            Arrays.fill(dp,1);
            dp[2] = 2;
            for (int i = 1; i < notes.length; i++){
                for (int j = 1; j < dp.length; j++){
                    if (j >= notes[i]){
                        dp[j] = sum(dp,j);
                    }
                }
            }

            System.out.println(dp[dp.length-1]);
        }
    }

    public static int sum(int[] arr, int index){
        int sum = 0;
        if (index == 2){
            return arr[0] + arr[1];
        } else if (index == 1){
            return arr[0];
        }
        for (int i = index-3; i < index; i++){
            sum += arr[i];
        }
        return sum;
    }
}
