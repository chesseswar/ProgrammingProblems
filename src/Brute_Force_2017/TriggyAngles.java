package Brute_Force_2017;

import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

public class TriggyAngles {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        int numCase = in.nextInt();
        while (numCase-- > 0){
            Triangle t = new Triangle(in.next().charAt(0),in.nextDouble(),in.next().charAt(0),in.nextDouble());
            String angle = in.next();
            if (angle.equals("A")){
                System.out.printf("%.2f\n",t.A);
            } else if (angle.equals("B")){
                System.out.printf("%.2f\n",t.B);
            } else {
                System.out.println("90.00");
            }
        }
    }
}

class Triangle {
    double a, b, c, A, B; //AB are angles, abc are side lengths

    public Triangle(char first, double x, char second, double y){
        switch (first){
            case 'a': a = x; break;
            case 'b': b = x; break;
            case 'c': c = x; break;
        }

        switch (second){
            case 'a': a = y; break;
            case 'b': b = y; break;
            case 'c': c = y; break;
        }

        if (c == 0) {
            c = Math.sqrt(a * a + b * b);
        } else if (a == 0){
            a = Math.sqrt(c * c - b * b);
        } else {
            b = Math.sqrt(c * c - a * a);
        }

        A = Math.atan(a/b);
        B = Math.atan(b/a);

        A *= 180 / Math.PI;
        B *= 180 / Math.PI;
    }

    public String toString(){
        return "A = " + A + " B = " + B;
    }
}