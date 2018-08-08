package UTD_Contest_Camp_2018;

import java.util.*;
import java.io.*;

public class CommonArray {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        int[] arr1 = new int[in.nextInt()];
        for (int i = 0; i < arr1.length; i++){
            arr1[i] = in.nextInt();
        }
        int[] arr2 = new int[in.nextInt()];
        for (int i = 0; i < arr2.length; i++){
            arr2[i] = in.nextInt();
        }


        Arrays.sort(arr2);
        HashSet<Integer> done = new HashSet<>();
        for (int i : arr1){ //n
            if (!done.contains(i)) {
                done.add(i);
                int search = bin(arr2,i,0,arr2.length-1); //log m
                if (search != -1){
                    System.out.println(arr2[search]);
                }
            }
        }
    }

    public static int bin(int[] arr, int search, int left, int right){
        int middle = (left + right) / 2;
        if (arr[middle] == search){
            return middle;
        }

        if (right - left == 1){
            if (arr[right] == search){
                return right;
            }

            if (arr[left] == search){
                return left;
            }

            return -1;
        }

        if (arr[middle] > search){
            return bin(arr,search,left,middle);
        } else {
            return bin(arr,search,middle,right);
        }
    }
}
