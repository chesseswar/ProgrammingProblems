package Centennial_Minicontest_2016;

import java.util.*;
import java.io.*;

public class Platformer {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        int numCase = in.nextInt();
        while (numCase-- > 0){
            System.out.println(collision(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt()) ? "COLLISION DETECTED" : "NO COLLISION");
        }
    }

    public static boolean collision(int firstx1, int firsty1, int firstx2, int firsty2, int secondx1, int secondy1, int secondx2, int secondy2){
        int biggest = Math.max(Math.max(firsty1,secondy1),Math.max(firstx2,secondx2));
        boolean[][] plane = new boolean[biggest+1][biggest+1];
        for (int i = firsty1; i >= firsty2; i--){
            for (int j = firstx1; j <= firstx2; j++){
                plane[i][j] = true;
            }
        }
        for (int i = secondy1; i >= secondy2; i--){
            for (int j = secondx1; j <= secondx2; j++){
                if (plane[i][j]){
                    return true;
                }
            }
        }

        return false;
    }

    public static void print(boolean[][] arr){
        for (boolean[] arr2: arr){
            System.out.println(Arrays.toString(arr2));
        }
        System.out.println();
    }
}
