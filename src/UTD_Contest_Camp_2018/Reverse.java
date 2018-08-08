package UTD_Contest_Camp_2018;

import java.io.*;
import java.util.*;

public class Reverse {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        int[] arr = new int[in.nextInt()];
        for (int i = 0; i < arr.length; i++){
            arr[i] = in.nextInt();
        }

        //System.out.println(Arrays.toString(rev(arr)));
        //System.out.println(Arrays.toString(cycle(arr)));
        System.out.println(bin(arr,41,0,arr.length-1));
    }

    public static int bin(int[] arr, int search, int left, int right){
        int middle = (left + right) / 2;
        if (arr[middle] == search){
            return middle;
        }

        if (arr[middle] > search){
            return bin(arr,search,left,middle);
        } else {
            return bin(arr,search,middle,right);
        }
    }

    public static int[] cycle(int[] arr){
        int last = arr[arr.length-1];
        for (int i = arr.length-2; i > -1; i--){
            arr[i+1] = arr[i];
        }
        arr[0] = last;
        return arr;
    }

    public static int[] rev(int[] arr){
        int count = 0;
        for (int i = arr.length-1; i > arr.length/2; i--){
            int temp = arr[i];
            arr[i] = arr[count];
            arr[count] = temp;
            count++;
        }

        return arr;
    }
}
