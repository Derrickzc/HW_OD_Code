package DynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;

public class NumberWithThree {
    public static void main(String[] args) {
        digitSearch(234);
    }

    public static void digitSearch(int num) {
        int[] arr = Arrays.stream(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        //dfs(0, true, arr); 统计带3的个数
        System.out.println(num + 1 - dfs(0, true, arr));
    }

    public static int dfs(int pos, boolean limit, int[]arr) {
        //统计所有不带3的个数
        if (pos == arr.length) {
            return 1;
        }

        int max = limit ? arr[pos] : 9;
        int count = 0;

        for (int i = 0; i <= max; i++) {
            if (i != 3) {
                count += dfs(pos + 1, limit && i == max, arr);
            }
        }

        return count;
    }

/*    public static int dfs(int pos, boolean limit, int[] arr ) {
        if (pos == arr.length) {
            return 0;
        }
        int max = limit ? arr[pos] : 9;
        int count = 0;
        for (int i = 0; i <= max; i++) {
            if (i == 3) {
                //开始剪枝
                if (limit && i == max) {
                    int[] tmp = Arrays.copyOfRange(arr, pos + 1, arr.length);
                    //截取关键的一部分长度，将其转化为数字后 + 1
                    StringBuilder sb = new StringBuilder();
                    Arrays.stream(tmp).forEach(sb::append);
                    count += Integer.parseInt(sb.toString()) + 1;
                    // 从0计数，因此要加1； 已经有了个3； 后续就是统计所有个数了
                } else {
                    count += Math.pow(10, arr.length - pos - 1);
                }
            } else {
                count += dfs(pos + 1, limit && i == max, arr);
            }
        }
        return count;
    }
 */
}
