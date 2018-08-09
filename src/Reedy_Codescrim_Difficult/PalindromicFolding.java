package Reedy_Codescrim_Difficult;

import java.util.*;
import java.io.*;

public class PalindromicFolding {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        int numCase = in.nextInt();
        while(numCase-- > 0){
            String[] input = in.nextLine().split(" ");
            int[] nums = new int[input.length];
            for (int i = 0; i < input.length; i++){
                nums[i] = Integer.parseInt(input[i]);
            }

            boolean done = false;
            for (int[] arr : moves(nums)){
                if (palindromic(arr)){
                    System.out.println("YES");
                    done = true;
                    break;
                }
            }

            if (!done){
                System.out.println("NO");
            }

        }
    }

    public static ArrayList<Integer[]> moves(int[] nums){
        ArrayList<Integer[]> output = new ArrayList<>();
        for (int i = 1; i <= nums.length/2; i++){
            int[] arr = new int[nums.length-i-1];
            for (int j = 0; j < i; j++){
                arr[j] = nums
            }
        }
    }
}
