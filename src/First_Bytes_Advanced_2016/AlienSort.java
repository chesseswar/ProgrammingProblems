package First_Bytes_Advanced_2016;

import java.util.*;
import java.io.*;

public class AlienSort {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);

        int words = in.nextInt(); //number of words in test case
        int count = 1; //for output "year 1", "year 2", etc
        while (words != 0){
            String input = in.next(); //inputted word
            HashMap<Character,Character> cypher = new HashMap<>(); //map new alphabet to old alphabet in this hashmap
            for (int j = 0; j < input.length(); j++){
                cypher.put(input.charAt(j),(char)(j+65));
            }

            HashMap<String,String> translations = new HashMap<>(); //map altered strings to original strings in this
            String[] translated = new String[words];
            for (int i = 0; i < words; i++){ //for each word, swap each char using cypher hashmap
                String word = in.next();
                char[] letters = word.toCharArray();
                for (int j = 0; j < letters.length; j++){
                    letters[j] = cypher.get(letters[j]);
                }
                translated[i] = concat(letters);
                translations.put(translated[i],word);
            }

            Arrays.sort(translated); //sort the array of altered strings
            System.out.println("year " + count);
            for (int i = 0; i < translated.length; i++){ //print out the original strings in the order of the altered ones
                System.out.println(translations.get(translated[i]));
            }

            words = in.nextInt(); //get next set of words
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
