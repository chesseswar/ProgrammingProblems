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
            for (int i = 0; i < input.length; i += cypher){
                if (i + cypher >= input.length){
                    break;
                }
                int temp = cypher-1;
                int j = i;
                while (j < cypher/2 + i && j < input.length){
                    char swap = input[j];
                    input[j] = input[j+temp];
                    input[j+temp] = swap;
                    temp--;
                    j++;
                }
            }
            System.out.println(Arrays.toString(input));
        }
    }

}
