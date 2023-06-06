package LogicalAnalysis;

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
      真正的密码（Java & JS & Python） 比较简单
    题目描述
        在一行中输入一个字符串数组，如果其中一个字符串的所有以索引0开头的子串在数组中都有，那么这个字符串就是潜在密码，
        在所有潜在密码中最长的是真正的密码，如果有多个长度相同的真正的密码，那么取字典序最大的为唯一的真正的密码，求唯一的真正的密码。
    输入描述
    输出描述
 */
public class RealPassword {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] split = reader.readLine().split("\\s+");
        Arrays.sort(split, (a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());
        Set<String> collect = Arrays.stream(split).collect(Collectors.toSet());
        for (int i = split.length - 1; i >= 0; i--) {
            String t= split[i];
            while (!t.equals("")) {
                if (!collect.contains(t)) break;
                t= split[i].substring(0, t.length() - 1);
            }
            if (t.equals("")) {
                writer.write(split[i]);
                writer.flush();
                return;
            }
        }
        writer.write("");
        writer.flush();
    }
}
