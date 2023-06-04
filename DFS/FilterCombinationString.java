package DFS;

import java.io.*;
import java.util.*;

/*
    过滤组合字符串:
    输入描述
        第一行输入为一串数字字符串，数字字符串中的数字不允许重复，数字字符串的长度大于0，小于等于5；
        第二行输入是"屏蔽字符串"，屏蔽字符串的长度一定小于数字字符串的长度，屏蔽字符串中字符不会重复；

    输出描述
        输出可能的字符串组合
    注：字符串之间使用逗号隔开，最后一个字符串后携带逗号
 */
public class FilterCombinationString {
    static String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqr", "st", "uv", "wx", "yz"};
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        //Integer[] array = Arrays.stream(reader.readLine().split("")).map(Integer::parseInt).toArray(Integer[]::new);
        int[] array1 = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        String[] qqq= Arrays.stream(array1).mapToObj(v -> map[v]).toArray(String[]::new);
        //转成Integer[]就可以直接用 map操作？ why？
//        String[] newArr = Arrays.stream(array).map(val -> map[val]).toArray(String[]::new);
        char[] charArray = reader.readLine().toCharArray();
        Arrays.sort(charArray);
        //强制排序; 为后续isContain做铺垫
        String filter = new String(charArray);
        LinkedList<Character> track = new LinkedList<>();
        LinkedList<String> ans = new LinkedList<>();
        //dfs(newArr, 0, track, ans, filter);
        dfs(qqq, 0, track, ans, filter);
        writer.write(String.join(",", ans)+",");
        writer.flush();
    }

    public static void dfs(String[] newArr, int index, LinkedList<Character> track, LinkedList<String> ans, String filter) {
        if (index == newArr.length) {
            if (!isContain(track, filter)) {
                StringBuilder sb = new StringBuilder();
                track.forEach(sb::append);
                ans.add(sb.toString());
            }
            return;
        }
        char[] charArray = newArr[index].toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            track.add(charArray[i]);
            dfs(newArr, index + 1, track, ans, filter);
            track.removeLast();
        }
    }

    public static boolean isContain(List<Character> track, String filter) {
        StringBuilder sb = new StringBuilder();
        track.stream().sorted().forEach(sb::append);
        return sb.toString().contains(filter);
    }
}
