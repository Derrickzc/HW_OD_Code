package CodeForces;

import java.io.*;
import java.util.Arrays;
/*
Alex doesn't like boredom. That's why whenever he gets bored, he comes up with games. One long winter evening he came up with a game and decided to play it.
Given a sequence a consisting of n integers. The player can make several steps.
In a single step he can choose an element of the sequence (let's denote it ak) and delete it, at that all elements equal to ak + 1 and ak - 1 also must be deleted from the sequence.
That step brings ak points to the player.
Alex is a perfectionist, so he decided to get as many points as possible. Help him.

Input
The first line contains integer n (1≤n≤105) that shows how many numbers are in Alex's sequence.
The second line contains n integers a1, a2, ..., an (1≤ai≤105).
Output
Print a single integer — the maximum number of points that Alex can earn.

选数组中分数最大值，选中分数的同时删除与分数相近的其他分数值；
 */

public class Round260A {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int MAX_COUNT = 100000 + 10;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(reader.readLine());
        int[] array = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] cnt = new int[MAX_COUNT];
        int max_index = 0;
        for (int i = 0; i < N; i++) {
            cnt[array[i]] ++;
            max_index = Math.max(max_index, array[i]);
        }
        long[] dp = new long[max_index + 10];
        dp[0] = cnt[0];
        //注意dp下标的定义； 这里是dp[1] = cnt[1];而不是 cnt[array[0]];
        //原因在于dp[i] 的定义中i 其实就是 表示 array数组中的数字； dp[1] == cnt[1]== 0 就算数组中没有1，也应该写成这样
        dp[1] = (long)cnt[1];
        //注意使用(long)来扩充！！！！！！！！！
        for (int i = 2; i <= max_index; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + (long)(cnt[i]) * (long)(i)) ;
        }
        writer.write(dp[max_index] + "");
        writer.flush();
    }
}
