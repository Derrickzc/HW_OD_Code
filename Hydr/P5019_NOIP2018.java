package Hydr;

import java.io.*;
import java.util.Arrays;

/*
    道路铺设
春春是一名道路工程师，负责铺设一条长度为 n 的道路。
铺设道路的主要工作是填平下陷的地表。整段道路可以看作是 n 块首尾相连的区 域，一开始，第 i 块区域下陷的深度为 di 。
春春每天可以选择一段连续区间 [L, R] ，填充这段区间中的每块区域，让其下陷深 度减少 1。在选择区间时，需要保证，区间内的每块区域在填充前下陷深度均不为 0 。
春春希望你能帮他设计一种方案，可以在最短的时间内将整段道路的下陷深度都变 为0。
 */
public class P5019_NOIP2018 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 0) {
                //需要花时间铺路；因为当前的i高度 > 之前铺垫过的高度；
                //同时注意： 在某点铺垫完工后，会形成一个断裂层， 需要以这个断裂层重新计算 工作天数 ans
                ans += arr[i] - arr[i - 1];
            }
        }
        writer.write(String.valueOf(ans));
        writer.flush();
    }
}
