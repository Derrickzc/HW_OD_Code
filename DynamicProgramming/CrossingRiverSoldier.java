package DynamicProgramming;

import java.io.*;
import java.util.Arrays;

public class CrossingRiverSoldier {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(reader.readLine());
        int T = Integer.parseInt(reader.readLine());
        int[] time = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).sorted().toArray();
        int[] dp = new int[N];
//        dp[0] = time[0];
//        dp[1] = time[1];
//        dp[2] = time[1] + time[0] + time[2];
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                dp[0] = time[0];
                if (dp[0] > T)
                {
                    writer.write("0 0");
                    writer.flush();
                    return;
                }
            } else if (i == 1) {
                dp[1] = time[1];
            } else {
                dp[i] = Math.min(dp[i - 1] + time[0] + time[i], dp[i - 2] + time[0] + 2*time[1] + time[i]);
            }
            if (dp[i] > T) {
                writer.write(i + " " + dp[i - 1]);
                writer.flush();
                return;
            }
        }

        writer.write(N + " " + dp[N - 1]);
        writer.flush();
//        if (dp[N - 1] <= T) {
//            writer.write(String.join(" ", String.valueOf(N) , String.valueOf(dp[N - 1])));
//        } else {
//            for (int i = 0; i < N; i++) {
//                if (dp[i] > T) {
//                    if (i == 0) {
//                        writer.write(String.join(" ", String.valueOf(1) , String.valueOf(dp[i])));
//                    } else {
//                        writer.write(String.join(" ", String.valueOf(i) , String.valueOf(dp[i - 1])));
//                    }
//                    break;
//                }
//            }
//        }

    }
}
