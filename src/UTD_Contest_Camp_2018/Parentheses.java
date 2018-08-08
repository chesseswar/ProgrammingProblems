package UTD_Contest_Camp_2018;

import java.io.IOException;
import java.util.*;

public class Parentheses {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int input = in.nextInt();
            Answer a = new Answer(input);
        }
    }

    public static List<String> generateParenthesis(int n){
        Answer a = new Answer(n);
        String[] answer = a.answer.split(" ");
        List<String> list = new ArrayList<>();
        for (String str : answer){
            list.add(str);
        }

        return list;

    }
}

class Answer {
    int input;
    String answer;
    public Answer(int i){
        input = i;
        answer = "[\n";
        answer(input,"(",1,0);
    }

    public void answer(int input, String soFar, int numOpen, int numClose){
        if (soFar.length() == input * 2){
            answer += (soFar + " ");
            return;
        }

        if (numOpen == input){
            for (int i = soFar.length(); i < input*2; i++){
                soFar += ")";
            }
            answer += (soFar + " ");
            return;
        }
        if (numOpen > numClose){
            answer(input,soFar + ")",numOpen,numClose+1);
        }

        answer(input,soFar+"(",numOpen+1,numClose);
    }
}
