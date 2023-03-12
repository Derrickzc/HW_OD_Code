package Hydr;


import java.io.*;
import java.util.Arrays;
//出现git无法 push的问题
//参考文献1 https://www.cnblogs.com/liuyangjun/p/16615552.html 【主要是配置 IdentityFile 这个属性】
//参考文献2 https://blog.csdn.net/qq_51738873/article/details/128193393
public class P1001 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] count = new int[10000 + 5];

        int l = 0, ans = 0;
        for (int r = 0; r < arr.length; r++) {
            int num = arr[r];
            count[num]++;
            while (count[num] >= k) {
                //如果有数出现次数大于等于k,那么一定是a[j]
                //以i为起点的合法区间一定是:[i , j],[i , j + 1],...,[i,n]
                ans += n - r;
                count[arr[l]]--;
                l++;
            }
        }
        writer.write(String.valueOf(ans));
        writer.flush();
    }
}

//k优雅阈值

/*题目描述
        如果一个数组Q中出现次数最多的元素出现大于等于K次,被称为k-优雅数组，k也可以被称为优雅阈值只。
        例如：
        数组1，2, 3, 1、2, 3, 1,它是一个3-优雅数组，因为元素1出现次数大于等于3次,
        数组[1,2, 3, 1, 2]就不是一一个3-优雅数组，因为其中出现次数最多的元素是1和2，只出现了2次。

        给定一个数组A和k,请求出A有多少子数组是k-优雅子数组。
        注意：子数组是数组中一个或多个连续元素组成的数组。
        例如，数组[1,2,3,4]包含10个子数组，分别是:
        [1], [1,2], [1,2,3], [1,2,3,4], [2], [2,3], [2,3,4], [3], [3, 4], [4]
*/
