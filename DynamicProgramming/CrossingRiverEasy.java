package DynamicProgramming;

import java.io.*;
import java.util.Arrays;
/*
题目来源
1700 -- Crossing River (poj.org)

题目描述
    有N个人想要过河，但是只有一艘船，并且这艘船最多只能搭载两个人。
    现在需要你制定某种策略，花费最少的时间，让所有人渡河。
    注：每个人的划船速度不同，当两个人划船时，过河时间取决于耗时最长的那个人。

输入描述
    第一行输入一个整数T（1 ≤ T ≤ 20），表示有T组测试用例。
    接下来输入T组用例，每组用例有两行：
    第一行输入一个整数N（N <= 1000），表示有N个人需要过河。
    第二行输入N个整数，以空格隔开，每个整数代表一个人的过河时间。注：每个人的过河时间都不会超过100秒。
输出描述
    针对每组测试用例，输出一行，输出内容为：该组用例中所有人过河所需的最短时间。
 */
public class CrossingRiverEasy {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(reader.readLine());
        int N = Integer.parseInt(reader.readLine());
        while (count -- > 0) {
            int[] array = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).sorted().toArray();
            int[] dp = new int[N];
            if (N == 1) {
                writer.write(String.valueOf(array[0]));
            } else if (N == 2) {
                writer.write(String.valueOf(array[1]));
            } else if (N == 3) {
                writer.write(String.valueOf(array[1] + array[2]));
            } else {
                dp[0] = array[0];
                dp[1] = array[1];
                dp[2] = array[1] + array[2] + array[0];

                for (int i = 3; i < N; i++) {
                    dp[i] = Math.min(dp[i - 1] + array[0] + array[i], dp[i - 2] + array[0] + 2 * array[1] + array[i]);
                }
                writer.write(String.valueOf(dp[N - 1]));
                writer.newLine();
            }
        }
        writer.flush();
    }
}
