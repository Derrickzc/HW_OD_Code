package DynamicProgramming;

import java.io.*;
import java.util.Arrays;
/*
题目描述
求区间[1,n] 范围内包含多少带49的数。

一个数是带49的数，当且仅当它的十进制表示中存在连续的两位，其中较高位为4，较低位为9。

比如：49, 149, 1234987 都是带49的数；

而4, 12345, 94, 999444 都不是。
 */
public class NumberWith49 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        int len = arr.length;
        int[][] dp = new int[len][10];
        writer.write(String.valueOf(num + 1 - dfs(dp, arr, 0, true, 0)));
        writer.flush();
    }

    public static int dfs(int[][] dp, int[] arr, int level, boolean limit, int prev_num) {
        //boolean limit表示 当前是否收到影响
        if (level == arr.length) {
            return 1;
        }
        if (!limit && dp[level][prev_num] > 0) return dp[level][prev_num];

        int max = limit ? arr[level] : 9;
        int cnt = 0;
        for (int i = 0; i <= max; i++) {
            if (i == 9 && prev_num == 4) continue;
            //这里的 i == max 是用于限制取值 不超过 预先给定值的上限
            cnt += dfs(dp, arr, level + 1, limit && i == max, i);
        }
        /// 如果当前数位取值不受限，则统计的不含49的数就具有复用性
        if (!limit) dp[level][prev_num] = cnt;
        return cnt;
    }
}
