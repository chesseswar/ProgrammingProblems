package UTD_Contest_Camp_2018;

import java.io.IOException;
import java.util.*;

public class Parentheses {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int input = in.nextInt();
            answer(input, "(", 1, 0);
        }
    }

    public static void answer(int input, String soFar, int numOpen, int numClose){
        if (soFar.length() == input * 2){
            System.out.println(soFar + " " + check(soFar));
            return;
        }

        if (numOpen == input){
            for (int i = soFar.length(); i < input*2; i++){
                soFar += ")";
            }
            System.out.println(soFar + " " + check(soFar));
            return;
        }
        if (numOpen > numClose){
            answer(input,soFar + ")",numOpen,numClose+1);
        }

        answer(input,soFar+"(",numOpen+1,numClose);
    }

    public static boolean check(String par){
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : par.toCharArray()){
            if (stack.size() == 0 && c == ')'){
                return false;
            }

            if (c == '('){
                stack.push(' ');
            } else {
                stack.pop();
            }
        }

        return stack.size() == 0;
    }
}
