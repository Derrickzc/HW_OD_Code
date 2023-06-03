package Greedy;

import java.io.*;
import java.util.Arrays;
/*
    部门组织绿岛骑行团建活动。租用公共双人自行车，每辆自行车最多坐两人，最大载重M。
    给出部门每个人的体重，请问最多需要租用多少双人自行车。

    输入描述
    第一行两个数字m、n，分别代表自行车限重，部门总人数。
    第二行，n个数字，代表每个人的体重，体重都小于等于自行车限重m。

        0<m<=200
        0<n<=1000000
    输出描述
        最小需要的双人自行车数量。
        输入	3 4
            3 2 2 1
        输出	3
        说明	无
 */
public class BicycleGreedIsland {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] MN = Arrays.stream(reader.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
        int M = MN[0], N = MN[1];
        int ans = 0;
        int[] peopleWeight = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(peopleWeight);
        int l = 0, r = peopleWeight.length - 1;
        while (l <= r) {
            //必须取相等；
            //当最后只剩下一个人的时候，此时默认肯定是超重的，所有自己一个人一个自行车
            //又因为 题目提及 体重都小于等于自行车限重M；所以比如成立
            int curWeight = peopleWeight[r] + peopleWeight[l];
            if (curWeight <= M) {
                l++; r --;
                //如果当前是满足乘坐两个人的， 那么自动跳转到下个可能
            } else {
                r--;
                //如果超重了，那么自己一个人一个位置
            }
            ans++;
        }
        writer.write(String.valueOf(ans));
        writer.flush();
    }
}
