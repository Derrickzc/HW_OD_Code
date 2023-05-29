package Brute_Force;

import java.io.*;
import java.util.Arrays;
import java.util.TreeSet;

public class Charade {
    /*
        注意TreeSet的使用； 使用Stream；删除掉最后一个，逗号
     */
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] charade = reader.readLine().split(",");
        String[] charadeLib = reader.readLine().split(",");
        StringBuilder ans = new StringBuilder();

        for (String t : charade) {
            String sortedString = getSortedString(t);
            boolean find = false;

            for (String t2 : charadeLib) {
                String sortedString1 = getSortedString(t2);
                if (sortedString.equals(sortedString1)) {
                    find = true;
                    ans.append(t2);
                    ans.append(",");
                }
            }

            if (!find) {
                ans.append("not found,");
            }
        }
        writer.write(ans.toString().substring(0, ans.toString().length() - 1));
        writer.flush();
    }

    public static String getSortedString(String arr) {
        StringBuilder ans = new StringBuilder();
        TreeSet<Character> set = new TreeSet<>();
        for (Character t : arr.toCharArray()) {
            set.add(t);
        }
        set.forEach(ans::append);
        return ans.toString();
    }
}
/*
题目描述
小王设计了一个简单的猜字谜游戏，游戏的谜面是一个错误的单词，比如nesw，玩家需要猜出谜底库中正确的单词。猜中的要求如下：
对于某个谜面和谜底单词，满足下面任一条件都表示猜中：

变换顺序以后一样的，比如通过变换w和e的顺序，“nwes”跟“news”是可以完全对应的；
字母去重以后是一样的，比如“woood”和“wood”是一样的，它们去重后都是“wod”
请你写一个程序帮忙在谜底库中找到正确的谜底。谜面是多个单词，都需要找到对应的谜底，如果找不到的话，返回”not found”

输入描述
    谜面单词列表，以“,”分隔
    谜底库单词列表，以","分隔
输出描述
    匹配到的正确单词列表，以","分隔
    如果找不到，返回"not found"
备注
    单词的数量N的范围：0 < N < 1000
    词汇表的数量M的范围：0 < M < 1000
    单词的长度P的范围：0 < P < 20
    输入的字符只有小写英文字母，没有其他字符
用例
    输入	conection
    connection,today
    输出	connection
    说明	无
    输入	bdni,wooood
    bind,wrong,wood
    输出	bind,wood
    说明	无

 */
