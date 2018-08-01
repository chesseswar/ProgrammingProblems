package UTD_HS_November_2014;

import java.util.*;
import java.io.*;

public class FourD {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
    }
}

class Dim implements Comparable<Dim>{
    int[] dims;
    int[] sorted;
    public Dim(int w, int x, int y, int z){
        sorted = new int[]{w, x, y, z};
        dims = sorted;
        Arrays.sort(sorted);
    }

    public int compareTo(Dim other){
        for (int i = 0; i < 4; i++){
            if (!(sorted[i] > other.sorted[i])){

            }
        }
        return 1;
    }
}
