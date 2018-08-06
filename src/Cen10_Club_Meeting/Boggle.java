package Cen10_Club_Meeting;

import java.util.*;
import java.io.*;

public class  Boggle {
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
                boolean found = false;
                for (int i = 0; i < 4; i++){
                    for (int j = 0; j < 4; j++){
                        if (map[i][j].c == input.charAt(0)){
                            HashSet<Letter> used = new HashSet<>();
                            used.add(map[i][j]);
                            found = find(map[i][j],map,input,1,used,Character.toString(map[i][j].c));
                        }
                        if (found){
                            break;
                        }
                    }
                    if (found){
                        break;
                    }
                }
                int hash = 2;
                if (found){
                    if (input.length() < 2){
                        hash = 2;
                    } else if (input.length() > 8){
                        hash = 8;
                    } else {
                        hash = input.length();
                    }
                }


                points += pointVals.get(hash);
            }

            System.out.println("PUZZLE #" + puzzle + ": " + points);

            if (in.hasNext()){
                in.nextLine();
            }
        }
    }

    public static boolean find(Letter start, Letter[][] map, String word, int index, HashSet<Letter> used, String output){
        String smh = used.toString();
        for (Letter l : adj(start,word,index,map,used)){
            if ((output + l.c).equals(word)){
                return true;
            }

            used.add(l);
            if(find(l,map,word,index+1,used,output + l.c)){
                return true;
            }
        }
        used.remove(start);
        return false;
    }

    public static ArrayList<Letter> adj(Letter start, String word, int index, Letter[][] map, HashSet<Letter> used){
        int[] x = new int[]{-1,0,1,-1,1,-1,0,1};
        int[] y = new int[]{1,1,1,0,0,-1,-1,-1};
        ArrayList<Letter> output = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            if (start.x + x[i] > -1 && start.x + x[i] < 4 && start.y + y[i] > -1 && start.y + y[i] < 4 && map[start.y + y[i]][start.x + x[i]].c == word.charAt(index)){
                if (!used.contains(map[start.y+y[i]][start.x+x[i]])){
                    output.add(map[start.y+y[i]][start.x+x[i]]);
                }
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
        return c + " <" + x + "," + y + ">";
    }
}
