package Sliding_window;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
/*
题目描述
    公元2919年，人类终于发现了一颗宜居星球——X星。
    现想在X星一片连绵起伏的山脉间建一个天热蓄水库，如何选取水库边界，使蓄水量最大？

要求：
    山脉用正整数数组s表示，每个元素代表山脉的高度。
    选取山脉上两个点作为蓄水库的边界，则边界内的区域可以蓄水，蓄水量需排除山脉占用的空间
    蓄水量的高度为两边界的最小值。
    如果出现多个满足条件的边界，应选取距离最近的一组边界。
    输出边界下标（从0开始）和最大蓄水量；如果无法蓄水，则返回0，此时不返回边界。
    例如，当山脉为s=[3,1,2]时，则选取s[0]和s[2]作为水库边界，则蓄水量为1，此时输出：0 2:1
    当山脉s=[3,2,1]时，不存在合理的边界，此时输出：0。
输入描述
    一行正整数，用空格隔开，例如输入
    1 2 3
    表示s=[1,2,3]
输出描述
    当存在合理的水库边界时，输出左边界、空格、右边界、英文冒号、蓄水量；例如
    0 2:1
当不存在合理的书库边界时，输出0；例如
    0
 */
public class NaturalStorageReservoir {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] height = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int N = height.length;
        //左右数组计算存水量
        int[] left = new int[N];
        int[] right = new int[N];
        for (int l = 1; l < N; l++) {
            left[l] = Math.max(left[l - 1], height[l - 1]);
        }

        for (int r = N - 2; r >= 0; r--) {
            right[r] = Math.max(right[r + 1], height[r + 1]);
        }
        
        int[] waterLine = new int[N];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            //waterLine[i] = Math.max(0, Math.min(left[i], right[i]) - height[i]);
            //set.add(waterLine[i]);
            int water = Math.max(0, Math.min(left[i], right[i]) - height[i]);
            if (water != 0) {
                waterLine[i] = water + height[i];
                set.add(waterLine[i]);
            }
        }
        int[] ans = new int[3];
        //如何确定[l,r]很关键； 找到能够构成水线的【最远的l,r】即可； 注意柱子高度==curWaterLine水线高度不能算
        for (Integer curWaterLine : set) {
            int l = 0;
            while (curWaterLine > waterLine[l] || height[l] >= curWaterLine) {
                //目的是找到和curWaterLine目标水线 相同高度的的水线的 [L,R]；
                // 如果waterLine[l]过低 Or 当前柱子高度 >= 目标水线 l++
                l++;
            }

            int r = N - 1;
            while (curWaterLine > waterLine[r] || height[r] >= curWaterLine) {
                r--;
            }

            //计算区间内存水量 [l, r] 并不是[l - 1, r + 1]
            int sum = 0;
            for (int i = l; i <= r; i++) {
                sum += Math.max(0, curWaterLine - height[i]);
            }

            if (sum > ans[2]) {
                ans[2] = sum;
                ans[0] = l - 1;
                ans[1] = r + 1;
            } else if (sum == ans[2]) {
                int curDis = r - l + 1;
                int minDis = ans[1] - 1  - (ans[0] + 1) + 1;
                if (curDis < minDis) {
                    ans[0] = l - 1;
                    ans[1] = r + 1;
                }
            }
        }
        if (ans[2] == 0) {
            writer.write("0");
        } else{
            writer.write(String.join(" ", String.valueOf(ans[0]), String.valueOf(ans[1])) + ":" + ans[2] );
        }
        writer.flush();
    }
}
