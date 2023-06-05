package LogicalAnalysis;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    这个题和选最大的区别在于
    首先需要保证总长度最短【本质上就是 数字的位数最小】，即保证组合数的位数最少，其值才能最小，
    数组组成的最小数字

     题目描述
        给定一个整型数组，请从该数组中选择3个元素组成最小数字并输出
        （如果数组长度小于3，则选择数组中所有元素来组成最小数字）。

     输入描述
        一行用半角逗号分割的字符串记录的整型数组，0 < 数组长度 <= 100，0 < 整数的取值范围 <= 10000。

     输出描述
        由3个元素组成的最小数字，如果数组长度小于3，则选择数组中所有元素来组成最小数字。
 */
public class FromSmallestNumber {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] split = reader.readLine().split(",");
        Arrays.sort(split, (a, b) -> (Integer.parseInt(a) - Integer.parseInt(b)));
        List<String> collect = Arrays.stream(split).limit(Math.min(3, split.length)).collect(Collectors.toList());
        collect.sort((a, b) -> (a + b).compareTo(b + a));
        //String[] tmp = Arrays.copyOfRange(split, 0, Math.min(3, split.length));
        //Arrays.sort(tmp, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder ans = new StringBuilder();
        collect.forEach(ans::append);
//        Arrays.stream(tmp).forEach(ans::append);
        writer.write(ans.toString());
        writer.flush();
    }
}
