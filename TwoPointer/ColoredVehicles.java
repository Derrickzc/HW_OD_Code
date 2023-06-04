package TwoPointer;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
/*
简单题
    简单的滑动窗口应用
    最多颜色的车辆（Java & JS & Python）
    题目描述
        在一个狭小的路口，每秒只能通过一辆车，假设车辆的颜色只有 3 种，找出 N 秒内经过的最多颜色的车辆数量。

        三种颜色编号为0 ，1 ，2

    输入描述
        第一行输入的是通过的车辆颜色信息

        [0,1,1,2] 代表4 秒钟通过的车辆颜色分别是 0 , 1 , 1 , 2

        第二行输入的是统计时间窗，整型，单位为秒

    输出描述
        输出指定时间窗内经过的最多颜色的车辆数量。
 */
public class ColoredVehicles {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int N = Integer.parseInt(reader.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int ansVehicles = Integer.MIN_VALUE;
        int l = 0, r = l + N;
        //注意此时r是不包含 在边界内的
        for (int i = 0; i < Math.min(r, arr.length); i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            ansVehicles = Math.max(ansVehicles, map.get(arr[i]));
        }

        while (r < arr.length) {
            int removeColor = arr[l++];
            int addColor = arr[r++];
            map.put(removeColor, map.getOrDefault(removeColor, 0) - 1);
            map.put(addColor, map.getOrDefault(addColor, 0) + 1);
            ansVehicles = Math.max(ansVehicles, map.get(addColor));
        }
        writer.write(String.valueOf(ansVehicles));
        writer.flush();
    }
}
