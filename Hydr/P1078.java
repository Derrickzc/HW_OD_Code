package Hydr;

import java.io.*;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1078 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[][] liuXing = new int[n][2];
        int[] ints = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < n; i++) {
            liuXing[i][0] = ints[i];
        }
        ints = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            liuXing[i][1] = ints[i];
            maxTime = Math.max(maxTime, ints[i]);
        }
        int[] count = new int[maxTime + 1];
        for (int i = 0; i < n; i++) {
            int start = liuXing[i][0] - 1;
            int end = liuXing[i][1] - 1;
            //注意时刻的区间是从0开始的， ；由于题目并不要求输出确定时刻，只是要求输出数量即可。
            count[start] += 1;
            count[end + 1] -= 1;
        }
        int[] ans = new int[maxTime];
        ans[0] = count[0];
        for (int i = 1; i < maxTime; i++) {
            ans[i] = ans[i - 1] + count[i];
        }
        //数组 ans作为记录每个时刻 “一共” 有多少颗彗星
        int maxCount = Integer.MIN_VALUE;
        List<Integer> time = new ArrayList<>();
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] > maxCount) {
                maxCount = ans[i];
                time.clear();
                time.add(i);
            } else if (ans[i] == maxCount) {
                time.add(i);
            }
        }

        writer.write(String.valueOf(maxCount)+ " " + String.valueOf(time.size()));
        writer.flush();
    }
}
