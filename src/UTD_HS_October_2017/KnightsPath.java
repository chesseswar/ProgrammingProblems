package UTD_HS_October_2017;

import java.util.*;
import java.io.*;

public class KnightsPath {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);

        int numCase = in.nextInt();
        while (numCase-- > 0) {
            int y = in.nextInt();
            int x = in.nextInt();
            in.nextLine();
            Cord[][] map = new Cord[y][x];
            HashMap<Integer,Cord> start = new HashMap<>();
            for (int i = 0; i < y; i++){
                String line = in.nextLine();
                for (int j = 0; j < x; j++){
                    char c = line.charAt(j);
                    map[i][j] = new Cord(i,j,c);
                    if (c == 'K'){
                        start.put(0,map[i][j]);
                        map[i][j].cost = 0;
                    }

                    if (c == 'P'){
                        start.put(1,map[i][j]);
                    }
                }
            }

            HashSet<Cord> visited = new HashSet<>();
            PriorityQueue<Cord> queue = new PriorityQueue<>();
            queue.add(start.get(0));
            while (queue.size() > 0){
                Cord current = queue.poll();
                visited.add(current);
                if (current.c == 'P'){
                    System.out.println(current.cost);
                    break;
                }

                for (Cord c : adj(map,current)){
                    if (!visited.contains(c)){
                        c.cost = current.cost+1;
                        queue.add(c);
                    }
                }
            }

            if (start.get(1).cost == Integer.MAX_VALUE){
                System.out.println("The Princess cannot be reached.");
            }
        }
    }

    public static ArrayList<Cord> adj(Cord[][] map, Cord current){
        int[] x = new int[]{-2,-1,1,2,-2,-1,1,2};
        int[] y = new int[]{1,2,2,1,-1,-2,-2,-1};
        ArrayList<Cord> output = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            if (current.x + x[i] >= 0 && current.x + x[i] < map[0].length && current.y + y[i] >= 0 && current.y + y[i] < map.length && map[current.y+y[i]][current.x+x[i]].c != '*'){
                output.add(map[current.y+y[i]][current.x+x[i]]);
            }
        }
        return output;
    }
}

class Cord implements Comparable<Cord>{
    int x, y;
    char c;
    int cost;
    public Cord(int y, int x, char c){
        this.x = x;
        this.y = y;
        this.c = c;
        cost = Integer.MAX_VALUE;
    }

    public String toString(){
        return "<" + y + "," + x + "," + c + ">";
    }

    public int compareTo(Cord other){
        return this.cost - other.cost;
    }


}