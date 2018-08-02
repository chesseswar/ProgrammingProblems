package Centennial_Minicontest_2016;

import java.util.*;
import java.io.*;

public class BlackOp {

    public static void main(String[] args) throws IOException {
        //Scanner in = new Scanner(new File("input.txt"));
        Scanner in = new Scanner(System.in);
        int numCase = in.nextInt();
        in.nextLine();
        while (numCase-- > 0) {
            char[][] map = new char[in.nextInt()][in.nextInt()];
            Coord[][] coords = new Coord[map.length][map[0].length];
            in.nextLine();

            HashMap<Integer, Coord> keys = new HashMap<>();
            ArrayDeque<Coord> queue = new ArrayDeque<>();

            for (int i = 0; i < map.length; i++) {
                String line = in.nextLine();
                for (int j = 0; j < map[0].length; j++) {
                    char c = line.charAt(j);
                    if (c == '#') {
                        coords[i][j] = null;
                    } else if (c == '@') {
                        coords[i][j] = new Coord(j, i, true, false);
                        keys.put(0, coords[i][j]);
                    } else if (c == 'X') {
                        coords[i][j] = new Coord(j, i, false, true);
                        keys.put(1, coords[i][j]);
                    } else {
                        coords[i][j] = new Coord(j, i, false, false);
                    }
                    map[i][j] = line.charAt(j);
                }
            }

            queue.add(keys.get(0));
            HashMap<Coord, Coord> path = new HashMap<>();
            HashSet<Coord> visited = new HashSet<>();
            while (queue.size() > 0) {
                Coord current = queue.poll();
                visited.add(current);
                if (current.end) {
                    break;
                }
                for (Coord c : adjacent(coords,current)) {
                    if (!visited.contains(c)) {
                        queue.add(c);
                        path.put(c, current);
                    }
                }
            }

            Coord coord = keys.get(1);
            while (!coord.equals(keys.get(0))){
                if (map[coord.y][coord.x] != 'X') {
                    map[coord.y][coord.x] = '.';
                }
                coord = path.get(coord);
            }
            print(map);
        }

    }

    public static ArrayList<Coord> adjacent(Coord[][] map, Coord start) {
        int adjCount = 0;
        ArrayList<Coord> output = new ArrayList<>();
        if (map[start.y + 1][start.x] != null) {
            output.add(map[start.y+1][start.x]);
        }
        if (map[start.y - 1][start.x] != null) {
            output.add(map[start.y-1][start.x]);
        }
        if (map[start.y][start.x+1] != null) {
            output.add(map[start.y][start.x+1]);
        }
        if (map[start.y][start.x-1] != null) {
            output.add(map[start.y][start.x-1]);
        }

        return output;

    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }

            System.out.println();
        }
    }
}

class Coord {
    int x, y;
    boolean start, end;
    ArrayList<Coord> connections;

    public Coord(int x, int y, boolean start, boolean end) {
        this.x = x;
        this.y = y;
        this.start = start;
        this.end = end;
        connections = new ArrayList<>();
    }

    public boolean equals(Coord other) {
        return this.x == other.x && this.y == other.y;
    }

    public String toString() {
        return x + " " + y;
    }
}