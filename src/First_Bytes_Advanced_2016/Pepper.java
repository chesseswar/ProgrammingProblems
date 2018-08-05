package First_Bytes_Advanced_2016;

import java.util.*;
import java.io.*;

public class Pepper {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input,txt"));
        //Scanner in = new Scanner(System.in);
        int numCase = in.nextInt();
        while (numCase-- > 0){
            int candy = in.nextInt();
            if (in.next().equals("Joe")){
                if (candy % 4 == 0){
                    System.out.println("Jane wins");
                } else {
                    System.out.println("Joe wins");
                }
            } else {
                if (candy % 4 == 0){
                    System.out.println("Joe wins");
                } else {
                    System.out.println("Jane wins");
                }
            }
        }
    }
}
