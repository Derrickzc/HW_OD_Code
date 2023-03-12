package Hydr;

import java.io.*;

public class P1024 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String s = reader.readLine().toString();
        if (dealWith(s, '1') || dealWith(s, '0')) {
            writer.write("yes");
        } else {
            writer.write("no");
        }
        writer.flush();
    }

    public static boolean dealWith(String t, char zeroOrOne) {
        char[] chars = t.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == zeroOrOne) continue;
            if (chars[i] == '1') chars[i] = '0';
            else chars[i] = '1';
            if (chars[i + 1] == '1') chars[i + 1] = '0';
            else chars[i + 1] = '1';
        }
        if (chars[t.length() - 1] == zeroOrOne) return true;
        else return false;
    }
}

/*
给一个01串，每次可以选择两个连续的下标，并对该下标的元素取反（0变1，1变0），问是否可以将串转换为只包含0或只包含1

输入描述
输入一个只包含字符0或者1的字符串s（1<=字符串长度<=1000000)

输出描述
如果满足题意输出"yes",否则输出"no"(不含引号)

1010010 : yes
10100100 : no

这道题使用的是贪心，即贪心使得每一位为0或者每一位为1，如果都无法完成，则输出“no”,需要注意的是，我们不能仅仅判断一个字符串能否变为全1
或全0.比如“001”字符串只能变为全1而无法变为全0.
具体做法是从前往后将每一位变为1/0.若需要修改，则需同时修改两位
 */
