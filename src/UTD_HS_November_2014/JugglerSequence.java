package UTD_HS_November_2014;

import java.util.*;
import java.io.*;

public class JugglerSequence {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        int numCase = in.nextInt();
        while(numCase-- > 0){
            int input = in.nextInt();
            long[] output = sequence(input, input, 1);
            System.out.println(output[0] + " " + output[1]);
        }
    }

    public static long[] sequence(double start, double largest, long length){
        start = (long)start;

        if ((long)start == 1) {
            long[] output = new long[2];
            output[0] = length;
            output[1] = (long)largest;
            return output;
        }

        if (start % 2 == 0) {
            return sequence(Math.sqrt(start), largest, length+1);
        } else {
            if (start * Math.sqrt(start) > largest){
                return sequence(start * Math.sqrt(start), start * Math.sqrt(start), length+1);
            } else {
                return sequence(start * Math.sqrt(start), largest, length+1);
            }
        }
    }
}
