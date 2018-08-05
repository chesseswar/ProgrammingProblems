package First_Bytes_Advanced_2016;

import java.util.*;
import java.io.*;

public class AlienSort {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);

        int words = in.nextInt();
        int count = 1;
        while (words != 0){
            String input = in.next();
            HashMap<Character,Character> cypher = new HashMap<>();
            for (int j = 0; j < input.length(); j++){
                cypher.put(input.charAt(j),(char)(j+65));
            }

            HashMap<String,String> translations = new HashMap<>();
            String[] translated = new String[words];
            for (int i = 0; i < words; i++){
                String word = in.next();
                char[] letters = word.toCharArray();
                for (int j = 0; j < letters.length; j++){
                    letters[j] = cypher.get(letters[j]);
                }
                translated[i] = concat(letters);
                translations.put(translated[i],word);
            }

            Arrays.sort(translated);
            System.out.println("year " + count);
            for (int i = 0; i < translated.length; i++){
                System.out.println(translations.get(translated[i]));
            }

            words = in.nextInt();
            count++;
        }
    }

    public static String concat(char[] chars){
        String output = "";
        for (char c : chars){
            output += c;
        }
        return output;
    }
}
