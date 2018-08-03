package Centennial_Minicontest_2016;

import java.util.*;
import java.io.*;

public class David {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        int numFiles = in.nextInt();
        //Name[] files =
        while (numFiles-- > 0){

        }
    }
}

class Name implements Comparable<Name>{
    String data;
    String extension;
    public Name(String input){
        data = input;
        extension = data.substring(data.length()-3);
    }

    public int compareTo(Name other){
        if (extension.equals(other.extension)){
            return -data.compareTo(other.data);
        } else {
            return extension.compareTo(other.extension);
        }
    }
}

