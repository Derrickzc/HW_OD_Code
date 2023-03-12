package Hydr;

import java.io.*;
import java.util.Arrays;

public class P1035 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int sum1 = 0, sum2 = 0;
        int N = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[1], arr[0]);
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        writer.write(String.valueOf(dp[N - 1]));
        writer.flush();
    }
}

/*
跳跳棋
        （荣耀—校招—10.13）题目内容
        现在有一种跳跳棋，跳棋路线有N 格排列为一条直线， 起始位置和结束位置都在棋盘之外，跳到每一格上都可以获取一定的积分，但是不可以从一格跳到相邻的格，也不可以回跳，请问如何获取最高的积分？
        输入描述
        第一行为整数 N，表示跳棋格数（1≤N≤100000）第二行为每一格代表的分数M（1≤M≤1000）输出描述
        能获得的最高积分 样例
        输入
        3
        1 5 2
        输出
        5
 */