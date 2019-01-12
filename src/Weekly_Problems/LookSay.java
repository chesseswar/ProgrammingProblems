package Weekly_Problems;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class LookSay {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        int numCase = in.nextInt();
        for (int i = 0; i < numCase; i++) {
            String original = in.next();
            int version = in.nextInt();
            if (version > 0) {
                for (int j = 0; j < version; j++) {
                    original = next(original);
                }
                System.out.println(original);
            } else {
                for (int j = 0; j > version; j--) {
                    original = previous(original);
                }
                System.out.println(original);
            }
        }

    }

    public static String next(String previous) {
        int count = 1;
        String output = "";
        for (int i = 0; i < previous.length()-1; i++) {
            if (previous.charAt(i) != previous.charAt(i+1)) {
                output += count + "" + previous.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        output += count + "" + previous.charAt(previous.length()-1);
        return output;
    }

    public static String previous(String next) {
        String output = "";
        for (int i = 0; i < next.length(); i+=2) {
            for (int j = 0; j < Integer.parseInt(next.substring(i,i+1)); j++) {
                output += next.charAt(i+1);
            }
        }

        return output;
    }
}
