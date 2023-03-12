    package Hydr;

    import java.io.*;
    import java.util.Arrays;

    public class P1032 {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        public static void main(String[] args) throws IOException {
            int t = Integer.parseInt(reader.readLine());
            while (t-- > 0) {
                int[] arr = Arrays.stream(reader.readLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
                int a = arr[0], b = arr[1], c = arr[2], d = arr[3];
                writer.write(String.valueOf(dealWith(a, b, c ,d)));
                writer.newLine();
            }
            writer.flush();
        }

        public static int dealWith(int a, int b, int c, int d) {
            if (a < c) {
                return b;
            } else if (a == c) {
                if (b >= d) {
                    return b;
                } else {
                    return -1;
                }
            } else {
                // 针对 a > c的情况
                //此时 d > b 那么套餐一没有任何优势
                if (d > b) return -1;
                // 如果 b > d， 则要分类讨论；
                //由于假设购买数量为b， 那么 floor(b/d) 个数 * c > a 成立，则表示 套餐一肯定便宜。
                else if ( ((b + d -1) / d) * c > a ) return b;
                else return -1;
            }
        }
    }
/*
    桃子礼包

            （阿里—校招—10.28）题目内容
            小红准备买一些桃子。商家有两种桃子礼包：1．价格a元，b个桃子。  2．价格c元，d个桃子。
            每个礼包可以买任意次。但只能选择一种礼包，即购买礼包1后不能购买礼包2，购买礼包2后不能购买礼包1。小红打算买至少k个桃子，小红希望只买礼包1的花费比只买礼包2的花费小。
            你能帮小红求出这个k吗？输入描述
            第一行输入一个正整数t，代表询问的次数。
            接下来的t行，每行输入四个正整数a，b，c，d，用空格隔开。1≤t≤103
            1≤a,b,c,d≤10^9 输出描述
            对于每行询问，输出一个合法的正整数k（0＜k＜231），代表买桃子的数量。有多解时输出任意即可。如果无解则直接输出—1。
            样例 输入 2 2153 10231 输出 1 -1
 */