package CodeForces;

import java.io.*;
import java.util.Arrays;

public class Round266C {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(reader.readLine());
        long[] longs = Arrays.stream(reader.readLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
        long[] preSum = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            preSum[i] = preSum[i - 1] + longs[i - 1];
        }
        long ans = 0;
        if (preSum[N] % 3 == 0) {
            long x = preSum[N] / 3, y = 2 * preSum[N] / 3;
            long t = 0;
            for (int i = 1; i < N; i++) {
                if (y == preSum[i]) {
                    ans += t;
                }

                if (x == preSum[i]) {
                    t++;
                }
            }
        }
        writer.write(String.valueOf(ans));
        writer.flush();
    }
}
