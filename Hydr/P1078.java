package Hydr;

import java.io.*;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class P1078 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[][] liuXing = new int[n][2];
        int[] ints = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < ints.length; i++) {
            liuXing[ints[0]][1] = ints[i];
        }

        writer.flush();
    }
}
