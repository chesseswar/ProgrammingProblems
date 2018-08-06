package Codecember_2017;

import java.util.*;
import java.io.*;

public class Biologist {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        int numCase = in.nextInt();
        while (numCase-- > 0){
            Cord[][] map = new Cord[in.nextInt()][in.nextInt()]; in.nextLine();
            for (int i = 0; i < map.length; i++){
                String input = in.nextLine();
                for (int j = 0; j < input.length(); j++){
                    map[i][j] = new Cord(i,j,input.charAt(j));
                }
            }

            HashMap<Character,Integer> colonies = new HashMap<>();
            HashMap<Character,Integer> pixels = new HashMap<>();

            for (int i = 0; i < map.length; i++){
                for (int j = 0; j < map[0].length; j++){
                    if (pixels.containsKey(map[i][j].c)){
                        pixels.put(map[i][j].c,pixels.get(map[i][j].c)+1);
                    } else {
                        pixels.put(map[i][j].c,1);
                    }
                    if (!map[i][j].visited){
                        if (colonies.containsKey(map[i][j].c)){
                            colonies.put(map[i][j].c,colonies.get(map[i][j].c)+1);
                        } else {
                            colonies.put(map[i][j].c,1);
                        }

                        ArrayDeque<Cord> queue = new ArrayDeque<>();
                        queue.add(map[i][j]);
                        while (queue.size() > 0){
                            Cord current = queue.poll();
                            current.visited = true;
                            for (Cord c : adj(map,current)){
                                if (!c.visited){
                                    queue.add(c);
                                }
                            }
                        }
                        //System.out.println(colonies);
                    }
                }
            }

            ArrayList<Output> output = new ArrayList<>();
            for (char c : colonies.keySet()){
                output.add(new Output(c,colonies.get(c),pixels.get(c)));
            }

            Collections.sort(output);
            for (Output o : output){
                System.out.println(o);
            }

            System.out.println();
        }
    }

    public static ArrayList<Cord> adj(Cord[][] map, Cord start){
        int[] x = new int[]{-1,0,1,0};
        int[] y = new int[]{0,1,0,-1};
        ArrayList<Cord> output = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            if (start.y + y[i] > -1 && start.y + y[i] < map.length && start.x + x[i] > -1 && start.x + x[i] < map[0].length && map[start.y+y[i]][start.x+x[i]].c == start.c){
                output.add(map[start.y+y[i]][start.x+x[i]]);
            }
        }
        return output;
    }
}

class Output implements Comparable<Output>{
    char c;
    int col, pix;
    public Output(char c, int col, int pix){
        this.c = c;
        this.col = col;
        this.pix = pix;
    }

    public int compareTo(Output other){
        if (pix - other.pix != 0){
            return -(pix - other.pix);
        } else if (col - other.col != 0){
            return -(col - other.col);
        } else {
            return (c - other.c);
        }
    }

    public String toString(){
        return c + " " + col + " " + pix;
    }
}

class Cord {
    int x, y;
    char c;
    boolean visited;
    public Cord(int i, int j, char data){
        y = i;
        x = j;
        c = data;
        visited = false;
    }

    public String toString(){
        return "<" + c + "," + y + "," + x + ">";
    }
}
