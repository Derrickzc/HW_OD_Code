package LogicalAnalysis;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/*
    与组成最小数字的逻辑相比正好是相反的 - 1
        组成最大数
     题目描述
        小组中每位都有一张卡片，卡片上是6位内的正整数，将卡片连起来可以组成多种数字，计算组成的最大数字。

    输入描述
        “,”号分割的多个正整数字符串，不需要考虑非数字异常情况，小组最多25个人。
    输出描述
        最大的数字字符串

        与力扣题目： 【剑指 Offer 45. 把数组排成最小的数】相似；
        这个题可能会难一些，因为涉及到前缀0问题
        https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class FromLargestNumber {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] str = reader.readLine().split(",");
//        List<String> collect = Arrays.stream(str).sorted((a, b) -> {
//            return -1 * justifyLarger(a, b);
//        }).collect(Collectors.toList());
        //想要的是倒序
        List<String> collect = Arrays.stream(str).sorted((a, b) -> -1 * (a + b).compareTo(b + a)).collect(Collectors.toList());
        StringBuilder ans = new StringBuilder();
        collect.forEach(ans::append);
        writer.write(ans.toString());
        writer.flush();
    }

    //错误的解法
    public static int justifyLarger(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        for (int i = 0; i < Math.min(charA.length, charB.length); i++) {
            if (charA[i] < charB[i]) {
                return -1;
            } else if (charA[i] > charB[i]) {
                return 1;
            } else {
                continue;
            }
        }
        //如果前面的都相等，那么就是看谁短谁排前面
        if (charA.length < charB.length) return 1;
        else return -1;
    }
}
