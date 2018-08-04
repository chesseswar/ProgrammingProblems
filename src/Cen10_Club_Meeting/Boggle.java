package Cen10_Club_Meeting;

import java.util.*;
import java.io.*;

public class Boggle {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        int numCase = in.nextInt();
        in.nextLine();
        HashMap<Integer,Integer> pointVals = new HashMap<>();
        pointVals.put(2,0);
        pointVals.put(3,1);
        pointVals.put(4,1);
        pointVals.put(5,2);
        pointVals.put(6,3);
        pointVals.put(7,5);
        pointVals.put(8,11);
        for (int puzzle = 1; puzzle <= numCase; puzzle++){
            Letter[][] map = new Letter[4][4];
            for (int i = 0; i < 4; i++){
                String input = in.nextLine();
                for (int j = 0; j < 4; j++){
                    map[i][j] = new Letter(input.charAt(j),i,j);
                }
            }
            int numWords = in.nextInt();
            int points = 0;
            for (int word = 0; word < numWords; word++) {
                String input = in.next();
                boolean done = false;
                int i = 0;
                while (i < map.length){
                    int j = 0;
                    while (j < map[0].length){
                        if (map[i][j].c == input.charAt(0)) {
                            ArrayDeque<Letter> queue = new ArrayDeque<>();
                            HashSet<Letter> visited = new HashSet<>();
                            map[i][j].index = 0;
                            map[i][j].str = Character.toString(map[i][j].c);
                            queue.add(map[i][j]);
                            while (queue.size() > 0) {
                                Letter current = queue.poll();
                                visited.add(current);
                                if (current.str.equals(input)) {
                                    int hash;
                                    if (input.length() > 8) {
                                        hash = 8;
                                    } else if (input.length() < 2) {
                                        hash = 2;
                                    } else {
                                        hash = input.length();
                                    }
                                    done = true;
                                    points += pointVals.get(hash);
                                    break;
                                }
                                for (Letter l : adj(current, input, current.index+1, map)) {

                                    if (((!visited.contains(l)) && (current.str + l.c).equals(input)) || (!visited.contains(l) && adj(l,input,current.index+2,map).size() != 0)) {
                                        l.index = current.index+1;
                                        l.str = current.str + l.c;
                                        queue.add(l);
                                    }
                                }
                            }
                        }

                        if (done){
                            break;
                        }
                        j++;
                    }
                    if (done){
                        break;
                    }
                    i++;
                }

            }

            System.out.println("PUZZLE #" + puzzle + ": " + points);

            if (in.hasNext()){
                in.nextLine();
            }
        }
    }

    public static String concat(ArrayList<Letter> letters){
        String output = "";
        for (Letter l : letters){
            output += l.c;
        }
        return output;
    }

    public static ArrayList<Letter> adj(Letter start, String word, int index, Letter[][] map){
        int[] x = new int[]{-1,0,1,-1,1,-1,0,1};
        int[] y = new int[]{1,1,1,0,0,-1,-1,-1};
        ArrayList<Letter> output = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            if (start.x + x[i] > -1 && start.x + x[i] < 4 && start.y + y[i] > -1 && start.y + y[i] < 4 && map[start.y + y[i]][start.x + x[i]].c == word.charAt(index)){
                output.add(map[start.y+y[i]][start.x+x[i]]);
            }
        }

        return output;
    }
}

class Letter {
    char c;
    int x, y, index;
    String str;
    public Letter(char data, int i, int j){
        c = data;
        y = i;
        x = j;
        str = "";
        index = 0;
    }

    public String toString(){
        return str + " <" + x + "," + y + ">";
    }
}
