/*
ID: chesses1
LANG: JAVA
TASK: crypt1
*/

//package USACO_Training;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class crypt1 {
    public static void main(String[] args) throws IOException {

        FastReader f = new FastReader("crypt1.in");
        PrintWriter out = new PrintWriter(new FileWriter("crypt1.out"));
        int numNums = f.nextInt();
        HashSet<Integer> numbers =  new HashSet<>();
        for (int i = 0; i < numNums; i++) {
            numbers.add(f.nextInt());
        }

        int count = 0;
        for (int a : numbers) {
            for (int b : numbers) {
                for (int c : numbers) {
                    for (int d : numbers) {
                        for (int e : numbers) {
                            int topNumber = a * 100 + b * 10 + c;
                            int bottomNumber = d * 10  + e;
                            if (validate(topNumber,bottomNumber,numbers)) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        out.println(count);
        out.close();
    }

    public static boolean validate(int top, int bot, HashSet<Integer> set) {
        int firstPartialProduct = top * (bot % 10);
        int secondPartialProduct = top * (bot - bot % 10) / 10;
        int product = top * bot;
        if (Integer.toString(firstPartialProduct).length() == 3 && Integer.toString(secondPartialProduct).length() == 3 && Integer.toString(product).length() == 4) {
            if (digsInSet(set,firstPartialProduct) && digsInSet(set, secondPartialProduct) && digsInSet(set, product)) {
                return true;
            }
        }

        return false;
    }

    public static boolean digsInSet(HashSet<Integer> set, int num) {
        for (char c : Integer.toString(num).toCharArray()) {
            if (!set.contains((c - 48))) {
                return false;
            }
        }

        return true;
    }

}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader(String file)
    {
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {e.printStackTrace();}
    }

    String next()
    {
        while (st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException  e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt()
    {
        return Integer.parseInt(next());
    }

    long nextLong()
    {
        return Long.parseLong(next());
    }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}


