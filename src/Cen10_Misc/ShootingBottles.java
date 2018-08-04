package Cen10_Misc;

import java.util.*;
import java.io.*;

public class ShootingBottles {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        int first = in.nextInt();
        int second = in.nextInt();
        int firstAnswer = first + second - 1 - first;
        int secondAnswer = first + second - 1 - second;
        System.out.println(firstAnswer + " " + secondAnswer);
    }
}
