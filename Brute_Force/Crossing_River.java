package Brute_Force;

import java.io.*;
import java.util.Arrays;

public class Crossing_River {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//    static int cross_M = 0, cross_N =0;
    static int M = 0, N = 0, X = 0;

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int[] data = Arrays.stream(reader.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
        M = data[0]; N = data[1]; X = data[2];
        dfs(0, 0, 0, M, N);
        writer.write(String.valueOf(ans));
        writer.flush();
    }

    public static void dfs(int count, int cross_M, int cross_N, int M, int N) {
        if (M < 0 || N < 0) return;
        if (M == 0 && N == 0) {
            ans = Math.min(ans, count);
            return;
        }
        for (int i = 0; i <= X; i++) {
            int save_Cross_M = cross_M, save_Cross_N = cross_N;
            int save_M = M, save_N = N;
            save_Cross_M += i;
            save_Cross_N += X - i;

            save_M -= i;
            save_N -= X - i;
            if (save_M < 0 || save_N < 0)  continue;
            if (save_Cross_M <= save_Cross_N) continue;
            dfs(count + 1, save_Cross_M, save_Cross_N, save_M, save_N);

        }
    }

}
