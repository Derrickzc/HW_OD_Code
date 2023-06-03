package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    等和子数组最小和
    与Lc 698相似
 */
public class MinimumSumSubarrays {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        Integer.parseInt(reader.readLine().trim());
        int[] array = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        //首先需要确定分组k数量; k最大可以取多少？
        int sum = Arrays.stream(array).sum();
        List<Integer> list = new ArrayList<>();
        Arrays.stream(array).forEach(list::add); list.sort((a, b) -> b.compareTo(a));
        int k = array.length + 1;
        //故意+1 这样使得 --k 符合遍历要求
        while (--k > 0) {
            if (sum % k != 0) {
                continue;
            }
            int subSum = sum / k;
            if (subSum < list.get(0)) {
                continue;
            }

            int[] barrel = new int[k];

            if (dfs(0, list, barrel, subSum)) {
                ans = Math.min(ans, subSum);
            }
        }
        writer.write(String.valueOf(ans));
        writer.flush();
    }

    public static boolean dfs(int index, List<Integer> array, int[] barrel, int subSum) {
        if (index == array.size()) {
            return true;
        }

        for (int i = 0; i < barrel.length; i++) {
            if (i > 0 && barrel[i] == barrel[i - 1]) continue;
            if (barrel[i] + array.get(index) <= subSum) {
                barrel[i] += array.get(index);
                if (dfs(index + 1, array, barrel, subSum)) {
                    return true;
                }
                barrel[i] -= array.get(index);
            }
        }
        return false;
    }
}
