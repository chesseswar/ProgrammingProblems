package Codecember_2017;

import java.util.*;
import java.io.*;

public class MathIsCool {
    static int[] memo = new int[999999];
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        int numCase = in.nextInt();
        Arrays.fill(memo,-1);
        memo[1] = 0;
        while (numCase-- > 0){
            int[] dp = new int[in.nextInt()+1];
            dp[1] = 0;
            for (int i = 2; i < dp.length; i++){
                if (i % 6 == 0){
                    dp[i] = Math.min(Math.min(dp[i-1],dp[i/2]),dp[i/3])+1;
                } else if (i % 2 == 0){
                    dp[i] = Math.min(dp[i-1],dp[i/2])+1;
                } else if (i % 3 == 0){
                    dp[i] = Math.min(dp[i-1],dp[i/3])+1;
                } else {
                    dp[i] = dp[i-1]+1;
                }
            }
            System.out.println(dp[dp.length-1]);
        }
    }
}
