package Hydr;

import java.io.*;

/*
有一个字符串，需要做一些修改。具体的，字符串里的任意位置的字符修改为任意的数字字符。问题是需要多少次修改，可以使得修改后的字符串不包含两个连续相同的字符？

例如，对于字符串"111222333", 可以进行3次修改变为"121212313"

输入描述：

一行，一个字符串s，保证s只包含数字字符。

1<=|s|<=100000

输出描述：

一行，一个整数，表示修改的最少次数。

示例1：

输入 字符串 111222333

输出 整数 3

示例2：

输入 字符串 11551111

输出 整数 4


 */

public class P1077 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        String s = reader.readLine();
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ans++;
                i++;
            }
        }
        writer.write(String.valueOf(ans));
        writer.flush();
    }

//    public static void main(String[] args) throws IOException {
//        String s = reader.readLine();
//        int[][] dp = new int[s.length()][10];
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < 10; j++) {
//                dp[i][j] = Integer.MAX_VALUE;
//            }
//        }
//        for (int i = 0; i < 10; i++) {
//            dp[0][i] = 1;
//        }
//        dp[0][s.charAt(0) - '0'] = 0;
//
//        for (int i = 1; i < s.length(); i++) {
//            for (int j = 0; j < 10; j++) {
//                // 假设当前字符 i 有10种可能，每种可能都要进行更新
//                for (int k = 0; k < 10; k++) {
//                    if (j != k) {
//                        // 不能从 k==j 过来转移； 必须从[0,k] [k+1, 9]的区间 中，找到 dp[i - 1][k]
//                        if ( (char)('0' + j) == s.charAt(i)) {
//                            //这个才是题目说的情况
//                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][k]);
//                        } else{
//                            // 这个是其他辅助情况
//                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + 1);
//                        }
//                    }
//                }
//            }
//        }
//        int ans = Integer.MAX_VALUE;
//        for (int i = 0; i < 10; i++) {
//            ans = Math.min(ans, dp[s.length() - 1][i]);
//        }
//        writer.write(String.valueOf(ans));
//        writer.flush();
//    }
}
