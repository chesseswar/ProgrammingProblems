package Brute_Force_2017;

import java.util.*;
import java.io.*;

public class Decryption {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        int numCase = in.nextInt();
        while (numCase-- > 0){
            int cypher = in.nextInt(); in.nextLine();
            char[] input = in.nextLine().toCharArray();
            char[][] output = new char[input.length/cypher+1][cypher];
            for (int i = 0; i < output.length-1; i++){
                output[i] = reverse(input,i*cypher,i*cypher+cypher-1);
            }
            output[output.length-1] = reverse(input,(input.length/cypher)*cypher,input.length-1);
            print(output);
        }
    }

    public static char[] reverse (char[] arr, int start, int end){
        char[] output = new char[end - start + 1];
        int index = 0;
        for (int i = end; i >= start; i--){
            output[index] = arr[i];
            index++;
        }
        return output;
    }

    public static void print(char[][] arr){
        for (char[] a : arr){
            for (char b : a){
                System.out.print(b);
            }
        }
        System.out.println();
    }

}
