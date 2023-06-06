package UnionSet;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/*
经典并查集题目
题目描述
    某地有N个广播站，站点之间有些有连接，有些没有。有连接的站点在接受到广播后会互相发送。
    给定一个N*N的二维数组matrix,数组的元素都是字符’0’或者’1’。
    matrix[i][j] = ‘1’, 代表i和j站点之间有连接，
    matrix[i][j] = ‘0’, 代表没连接，
    现在要发一条广播，问初始最少给几个广播站发送，才能保证所有的广播站都收到消息。
输入描述
    从stdin输入，共一行数据，表示二维数组的各行，用逗号分隔行。保证每行字符串所含的字符数一样的。
    比如：110,110,001。
输出描述
    返回初始最少需要发送广播站个数
 */
public class BroadCast {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        String[] split = reader.readLine().split(",");
        List<List<Integer>> list = new ArrayList<>();
        int N = split.length;
        Arrays.stream(split).forEach(p -> {
            List<Integer> collect = Arrays.stream(p.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
            list.add(collect);
        });
        UnionSet unionSet = new UnionSet(N);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if (i != j && list.get(i).get(j) == 1) {
                    unionSet.union(i, j);
                }
            }
        }
        writer.write(String.valueOf(unionSet.count));
        writer.flush();
    }

    static class UnionSet {
        int count;
        int []fa;

        public UnionSet(int n) {
            count = n;
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        public void union(int x, int y) {
            int fax = find(x);
            int fay = find(y);
            if (fax != fay) {
                fa[fax] = fay;
                count--;
            }
        }

        public int find(int x) {
            if (fa[x] != x) {
                fa[x] = find(fa[x]);
                return fa[x];
            }
            return x;
        }
        public UnionSet() {

        }
    }

}

