/*
ID: chesses1
LANG: JAVA
TASK: test
 */

import java.util.*;
import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("test.in"));
        PrintWriter out = new PrintWriter(new FileWriter("test.out"));
        StringTokenizer s = new StringTokenizer(f.readLine());
        int answer = Integer.parseInt(s.nextToken()) + Integer.parseInt(s.nextToken());
        out.println(answer);
        out.close();
    }
}
