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
            if (dp.length < 3){
                System.out.println(1);
            } else {
                Arrays.fill(dp,1);
                dp[2] = 2;
                dp[3] = 3;
                dp[4] = 6;
                for (int i = 1; i < notes.length; i++){
                    for (int j = 4; j < dp.length; j++){
                        if (j >= notes[i]){
                            dp[j] = dp[j-1] + dp[j-2] + dp[j-4];
                        }
                    }
                }

                System.out.println(dp[dp.length-1]);
            }
        }
    }
}
