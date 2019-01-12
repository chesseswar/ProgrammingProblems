/*
ID: chesses1
LANG: JAVA
TASK: namenum
 */

//package USACO_Training;

import java.io.*;
import java.util.*;

public class namenum {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
        BufferedReader dictionaryReader = new BufferedReader(new FileReader("dict.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("namenum.out"));

        HashMap<String,HashSet<Character>> key = new HashMap<>();
        int characterVal = 65;
        for (int i = 2; i < 10; i++) {
            HashSet<Character> threeLetters = new HashSet<>();
            for (int j = characterVal; j < characterVal+3; j++) {
                if (j > 80) {
                    threeLetters.add((char)(j+1));
                } else {
                    threeLetters.add((char)j);
                }
            }
            characterVal += 3;
            key.put("" + i,threeLetters);
        }

        String brand = f.readLine();
        PriorityQueue<String> output = new PriorityQueue<>();
        String name = dictionaryReader.readLine();
        while (name != null) {
            if (fitsRule(brand,name,key)) {
                output.add(name);
            }
            name = dictionaryReader.readLine();
        }

        for (String str : output) {
            out.println(str);
        }

        if (output.size() == 0){
            out.println("NONE");
        }

        out.close();

    }

    public static boolean fitsRule(String brand, String name, HashMap<String,HashSet<Character>> key) {
        if (brand.length() != name.length()) {
            return false;
        }

        for (int i = 0; i < brand.length(); i++) {
            if (!key.get(brand.substring(i,i+1)).contains(name.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}