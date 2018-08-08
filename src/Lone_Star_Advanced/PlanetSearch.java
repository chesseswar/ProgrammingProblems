package Lone_Star_Advanced;

import java.util.*;
import java.io.*;

public class PlanetSearch {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        Direction[] directions = new Direction[8];
        directions[0] = new Direction("N",-1,0);
        directions[1] = new Direction("NE",-1,1);
        directions[2] = new Direction("E",0,1);
        directions[3] = new Direction("SE",1,1);
        directions[4] = new Direction("S",1,0);
        directions[5] = new Direction("SW",1,-1);
        directions[6] = new Direction("W",0,-1);
        directions[7] = new Direction("NW",-1,-1);

        String[] planets = new String[in.nextInt()];
        Cord[][] map = new Cord[in.nextInt()][in.nextInt()];
        for (int i = 0; i < planets.length; i++){
            planets[i] = in.next();
        }

        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[0].length; j++){
                map[i][j] = new Cord(i,j,in.next().charAt(0));
            }
        }

        HashMap<String,Vector<Integer>> output = new HashMap<>();
        for (String str : planets){
            boolean done = false;
            for (int i = 0; i < map.length; i++){
                for (int j = 0; j < map[0].length; j++){
                    if (map[i][j].c == str.charAt(0)){
                        for (Direction d : directions){
                            int index = 1;
                            Cord c = map[i][j];
                            while (c.y+d.y > -1 && c.y+d.y < map.length && c.x+d.x > -1 && c.x+d.x < map[0].length && index < str.length()){
                                Cord temp = map[c.y+d.y][c.x+d.x];
                                char temp2 = str.charAt(index);
                                if (map[c.y+d.y][c.x+d.x].c == str.toUpperCase().charAt(index)){
                                    c = map[c.y+d.y][c.x+d.x];
                                    index++;
                                } else {
                                    break;
                                }
                            }

                            if (index >= str.length()){
                                done = true;
                                map[i][j].d = d;
                                Vector<Integer> v = new Vector<>();
                                v.add(i+1); v.add(j+1);
                                output.put(str,v);
                                break;
                            }
                        }
                    }

                    if (done){
                        break;
                    }
                }

                if (done){
                    break;
                }
            }
        }

        for (String str : planets){
            System.out.println(str + " " + output.get(str).get(0) + " " + output.get(str).get(1) + " " + map[output.get(str).get(0)-1][output.get(str).get(1)-1].d);
        }
    }
}

class Direction {
    String name;
    int x, y;
    public Direction(String n, int i, int j){
        name = n;
        y = i;
        x = j;
    }

    public String toString(){
        return name;
    }
}

class Cord {
    int x, y;
    char c;
    Direction d;
    public Cord(int i, int j, char c){
        y = i;
        x = j;
        this.c = c;
        d = null;
    }

    public String toString(){
        return "<" + c + "," + y + "," + x + ">";
    }
}