package Brute_Force_2017;

import java.util.*;
import java.io.*;

public class Digsite {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        Cord[][] map = new Cord[in.nextInt()][in.nextInt()]; in.nextLine();
        for (int i = 0; i < map.length; i++){
            String input = in.nextLine();
            for (int j = 0; j < map[0].length; j++){
                map[i][j] = new Cord(i,j,input.charAt(j));
            }
        }

        HashMap<String,Integer> fossils = new HashMap<>();
        fossils.put("X Fossils",0); //2 #s
        fossils.put("Y Fossils",0); //3 #s
        fossils.put("Z Fossils",0); //5 #s
        fossils.put("Q Fossils",0); //1 #s
        fossils.put("Unidentified Fossils",0); //none of the above

        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[0].length; j++){
                if (!map[i][j].visited && map[i][j].c == '#'){
                    map[i][j].visited = true;
                    HashSet<Cord> visited = new HashSet<>();
                    ArrayDeque<Cord> queue = new ArrayDeque<>();
                    queue.add(map[i][j]);
                    while (queue.size() > 0){
                        Cord current = queue.poll();
                        visited.add(current);
                        for (Cord c : adj(map,current,map[0].length,map.length)){
                            if (!visited.contains(c)){
                                queue.add(c);
                                c.visited = true;
                            }
                        }
                    }

                    switch(visited.size()){
                        case 2: fossils.put("X Fossils", fossils.get("X Fossils") + 1); break;
                        case 3: fossils.put("Y Fossils", fossils.get("Y Fossils") + 1); break;
                        case 5: fossils.put("Z Fossils", fossils.get("Z Fossils") + 1); break;
                        case 1: fossils.put("Q Fossils", fossils.get("Q Fossils") + 1); break;
                        default: fossils.put("Unidentified Fossils", fossils.get("Unidentified Fossils") + 1);
                    }
                }
            }
        }

        String[] names = new String[]{"X Fossils", "Y Fossils", "Z Fossils", "Q Fossils", "Unidentified Fossils"};
        for (String s : names){
            System.out.println(s + ": " + fossils.get(s));
        }
    }

    public static ArrayList<Cord> adj(Cord[][] map, Cord current, int x, int y){
        ArrayList<Cord> output = new ArrayList<>();
        int[] delX = new int[]{-1,0,1,0};
        int[] delY = new int[]{0,1,0,-1};
        for (int i = 0; i < 4; i++){
            if (current.x + delX[i] >= 0 && current.x + delX[i] < x && current.y + delY[i] >= 0 && current.y + delY[i] < y){
                if (map[current.y+delY[i]][current.x+delX[i]].c == '#'){
                    output.add(map[current.y+delY[i]][current.x+delX[i]]);
                }
            }
        }
        return output;
    }
}

class Cord {
    int x, y;
    char c;
    boolean visited;
    public Cord(int i, int j, char c){
        y = i;
        x = j;
        this.c = c;
        visited = false;
    }
}
