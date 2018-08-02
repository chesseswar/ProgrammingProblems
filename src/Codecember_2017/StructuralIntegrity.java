package Codecember_2017;

import java.util.*;
import java.io.*;

public class StructuralIntegrity {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        int numCase = in.nextInt();
        while (numCase-- > 0){
            int dim = in.nextInt();
            int ops = in.nextInt();
            in.nextLine();

            int[][][] fort = new int[dim][dim][dim];

            while (ops-- > 0){
                if (in.next().equals("UPDATE")) {

                } else {

                }
            }
        }
    }
}
