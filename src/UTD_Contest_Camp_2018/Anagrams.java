package UTD_Contest_Camp_2018;

import java.io.*;
import java.util.*;

public class Anagrams {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        String first = in.next();
        String second = in.next();
        HashMap<Character,Integer> chars1 = new HashMap<>();
        HashMap<Character,Integer> chars2 = new HashMap<>();
        for (char c : first.toCharArray()){
            if (chars1.containsKey(c)){
                chars1.put(c,chars1.get(c)+1);
            } else {
                chars1.put(c,1);
            }
        }

        for (char c : second.toCharArray()){
            if (chars2.containsKey(c)){
                chars2.put(c,chars1.get(c)+1);
            } else {
                chars2.put(c,1);
            }
        }

        int deletions = 0;
        HashSet<Character> done = new HashSet<>();
        for (char c : chars1.keySet()){
            done.add(c);
            if (chars2.containsKey(c)){
                deletions += Math.abs(chars2.get(c) - chars1.get(c));
            } else {
                deletions += chars1.get(c);
            }
        }

        for (char c : chars2.keySet()){
            if (!done.contains(c)){
                deletions += chars2.get(c);
            }
        }

        System.out.println(deletions);
    }
}
