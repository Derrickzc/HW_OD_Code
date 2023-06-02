package Brute_Force;

import java.io.*;
import java.util.Arrays;

public class Crossing_River {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    static int ans = Integer.MAX_VALUE / 4;

    public static void main(String[] args) throws IOException {
        int[] data = Arrays.stream(reader.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
        int m_Sheep = 0, n_Wolf = 0, x_Ship = 0;
        m_Sheep = data[0]; n_Wolf = data[1]; x_Ship = data[2];
        dfs(m_Sheep, n_Wolf, x_Ship, 0, 0, 0);
        if (ans == Integer.MAX_VALUE / 4) {
            writer.write(String.valueOf(0));
        } else {
            writer.write(String.valueOf(ans));
        }
        writer.flush();
    }

    static void dfs(int m_Sheep, int n_Wolf, int x_Ship, int cross_Sheep, int cross_Wolf, int count) {
        if (m_Sheep < 0 || n_Wolf < 0 || x_Ship <= 0) return ;
        if (m_Sheep == 0 && n_Wolf == 0) {
            ans = Math.min(ans, count);
            return ;
        }

        //根据当前羊+狼的个数，直接最后一次性运完；   如果缺少这个条件会报错！！
        if (m_Sheep + n_Wolf <= x_Ship) {
            ans = Math.min(ans, count + 1);
            return;
        }

        for (int i = 0; i <= m_Sheep; i++) {
            for (int j = 0; j <= n_Wolf; j++) {
                if (i == 0 && j == 0) continue;
                if (i + j > x_Ship) continue;

                if (m_Sheep - i <= n_Wolf - j && m_Sheep - i != 0) continue;
                // 此岸有羊（运输后此岸仍然存在羊， 如果此岸运完后没有羊的话，不需要满足此if条件   ），才要进行此判断； 这就是为什么要&& 一个新判断
                if (cross_Sheep + i <= cross_Wolf + j && cross_Sheep + i != 0) break;
                // 对岸有羊（运输后的羊数量必须存在！），才需要进行此判断  ； 这就是为什么要 &&一个新判断
                if (cross_Sheep + i == 0 && cross_Wolf + j >= x_Ship) break;
                //为了加快运算速度。 对岸没羊，但是对岸狼已经超过船载量，即下次即使整船都运羊，也无法保证对岸羊 > 对岸狼
                dfs(m_Sheep - i, n_Wolf - j, x_Ship, cross_Sheep + i, cross_Wolf + j, count + 1);
            }
        }
    }
}
/*
题目：羊、狼、农夫过河

羊、狼、农夫都在岸边，当羊的数量小于狼的数量时，狼会攻击羊，农夫则会损失羊。农夫有一艘容量固定的船，能够承载固定数量的动物。
要求求出不损失羊情况下将全部羊和狼运到对岸需要的最小次数。
只计算农夫去对岸的次数，回程时农夫不会运送羊和狼。
备注：农夫在或农夫离开后羊的数量大于狼的数量时狼不会攻击羊。

输入描述:
第一行输入为M，N，X， 分别代表羊的数量，狼的数量，小船的容量。

输出描述：
输出不损失羊情况下将全部羊和狼运到对岸需要的最小次数（若无法满足条件则输出0）。

用例：
输入	5 3 3
输出	3
说明
第一次运2只狼
第二次运3只羊
第三次运2只羊和1只狼

输入	5 4 1
输出	0
说明	如果找不到不损失羊的运送方案，输出0



本题没有什么好的解题思路，只能通过暴力枚举所有羊、狼数量情况，只需要满足下面三个条件：

农夫离开后，本岸羊 > 本岸狼
农夫离开后，对岸羊 > 对岸狼
船上由于农夫始终在，因此羊、狼什么数量都可以，只要不超过船载量
 */
