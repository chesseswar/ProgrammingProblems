package First_Bytes_Advanced_2016;

import java.util.*;
import java.io.*;

public class PostalDelivery {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        int numCase = in.nextInt();
        while (numCase-- > 0){
            int vertices = in.nextInt();
            int edges = in.nextInt();
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 1; i <= vertices; i++){
                map.put(i,0);
            }

            for (int i = 0; i < edges; i++){
                int a = in.nextInt();
                map.put(a,map.get(a)+1);
                int b = in.nextInt();
                map.put(b,map.get(b)+1);
            }
            System.out.println(even(map) ? "yes" : "no");
        }
    }

    public static boolean even(HashMap<Integer,Integer> map){
        for (int i : map.keySet()){
            if (map.get(i) % 2 != 0){
                return false;
            }
        }

        return true;
    }
}