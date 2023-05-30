package DynamicProgramming;

import java.io.*;
import java.util.Arrays;

public class WindyNumber {
    //统计[L,R]满足条件部分的个数 => 等价于
    //Ans[L,R] = Ans[1,R] - Ans[1,L]
    //【补充到一个维度】将数字大小 => 转换成 数位字典序
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] split = reader.readLine().split("\\s+");
        String A = split[0];
        String B = split[1];
        int[] arrayB = Arrays.stream(B.split("")).mapToInt(Integer::parseInt).toArray();
        int[][] dp = new int[B.length()][10];

        writer.flush();
    }

    public static int dfs(int[] arrB, int pos, int pre_num, boolean flag) {
        if (pos == arrB.length) {
            return 1;
        }

        return 0;
    }
}
