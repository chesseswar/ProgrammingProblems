package Centennial_Minicontest_2016;

import java.util.*;
import java.io.*;

public class David {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        int numFiles = in.nextInt();
        in.nextLine();
        ArrayList<Name> files = new ArrayList<>();
        for(int i = 0; i < numFiles; i++){
            files.add(new Name(in.nextLine()));
        }
        Collections.sort(files);
        for (Name n : files){
            System.out.println(n.str);
        }
    }
}

class Name implements Comparable<Name>{
    String str;
    String data;
    String extension;
    public Name(String input){
        str = input;
        if (str.substring(0,3).toLowerCase().equals("the")){
            data = str.substring(3);
        } else {
            data = str;
        }
        extension = data.substring(data.length()-3,data.length());
    }

    public int compareTo(Name other){
        if (extension.equals(other.extension)){
            return -data.compareTo(other.data);
        } else {
            return extension.compareTo(other.extension);
        }
    }
}

