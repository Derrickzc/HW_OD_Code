package DFS;

import java.io.*;
import java.util.Arrays;
/*
        对称美学（Java & JS & Python）


 */
public class AestheticsOfSymmetry {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(reader.readLine());
        while (N -- > 0) {
            double[] array = Arrays.stream(reader.readLine().split("\\s++")).mapToDouble(Double::parseDouble).toArray();
            double n = array[0], k = array[1];
            writer.write(dfs(n, k));
            writer.newLine();
        }
        writer.flush();
    }

    public static String dfs(double n, double k) {
        if (n == 1) {
            return "red";
        }

        if (n ==2) {
            if (k == 0) return "blue";
            else return "red";
        }

        double half = Math.pow(2, n - 2);

        if (k >= half) {
            return dfs(n - 1, k - half);
        } else {
            //需要将 上一阶结果 取反
            return "red".equals(dfs(n - 1, k)) ? "blue" : "red";
        }
    }
}
