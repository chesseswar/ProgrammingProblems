/*
ID: chesses1
LANG: JAVA
TASK: friday
 */
//package USACO_Training;
import java.util.*;
import java.io.*;

public class friday {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new FileWriter("friday.out"));
        HashMap<Integer,Integer> months = new HashMap<>();
        months.put(1,31);
        months.put(2,28);
        months.put(3,31);
        months.put(4,30);
        months.put(5,31);
        months.put(6,30);
        months.put(7,31);
        months.put(8,31);
        months.put(9,30);
        months.put(10,31);
        months.put(11,30);
        months.put(12,31);
        HashMap<Integer,Integer> output = new HashMap<>();
        int day = -1;
        int input = Integer.parseInt(f.readLine());
        for (int year = 1900; year < input+1900; year++) {
            for (int month = 1; month <= 12; month++) {
                int daysInMonth;
                daysInMonth = months.get(month);
                if (month == 2) {
                    if (year % 4 == 0) {
                        if (year % 100 == 0) {
                            if (year % 400 == 0) {
                                daysInMonth++;
                            }
                        } else {
                            daysInMonth++;
                        }
                    }
                }

                for (int i = 1; i <= daysInMonth; i++) {
                    day = (day + 1) % 7;
                    if (i == 13) {
                        if (!output.containsKey(day)) {
                            output.put(day, 1);
                        } else {
                            output.put(day, output.get(day) + 1);
                        }
                    }
                }
            }
        }

        int index = 0;
        int outputDay = 5;
        while (index < 6) {
            out.print(output.get(outputDay) + " ");
            outputDay = (outputDay+1)%7;
            index++;
        }
        out.println(output.get(4));
        out.close();
    }
}
