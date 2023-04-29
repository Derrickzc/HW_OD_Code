package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Interval_Overlap {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int ans = 0;
        int N = Integer.parseInt(reader.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            int[] array = Arrays.stream(reader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
            arr[i][0] = array[0];
            arr[i][1] = array[1];
        }
        Arrays.sort(arr, (a, b) -> {return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];});
        LinkedList<int[]> stack = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else {
                int[] peek = stack.peek();
                int s0 = peek[0], e0 = peek[1];
                int s1 = arr[i][0], e1 = arr[i][1];

                if (s1 <= s0) {
                    if (e1 <= s0) {
                        continue;
                    } else if (e1 < e0){
                        // 被包容了 【8,11】最终会停留在这； 不会add进去了
                        continue;
                    } else {
                        //新来的区间很强
                        stack.poll();
                        stack.addLast(arr[i]);
                    }
                } else if (s1 < e0) {
                    //不用等号， 是因为题目已说 最短长度为>=1，如果s1==e0 直接跳转到else即可
                    if (e1 <= e0) {
                        continue;
                    } else {
                        stack.push(new int[]{e0, e1});
                        //单独添加 => []新的小区间： 但是这个小区间可能会出现 一些“问题”
                    }
                } else {
                    stack.addLast(arr[i]);
                }
            }
        }
        writer.write(String.valueOf(stack.size()));
        writer.flush();
    }
}
/*
    给定坐标轴上的一组线段，线段的起点和终点均为整数并且长度不小于1，请你从中找到最少数量的线段，这些线段可以覆盖柱所有线段。
    输入描述
        第一行输入为所有线段的数量，不超过10000，后面每行表示一条线段，格式为"x,y"，x和y分别表示起点和终点，取值范围是[-10^5，10^5]。
    输出描述
        最少线段数量，为正整数
        3
        1,10
        5,12
        8,11

        2
 */