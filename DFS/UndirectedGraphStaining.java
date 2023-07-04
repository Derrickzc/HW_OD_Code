package DFS;

import java.util.*;
/*
     无向图染色
     题目描述
        给一个无向图染色，可以填红黑两种颜色，必须保证相邻两个节点不能同时为红色，输出有多少种不同的染色方案？

     输入描述
        第一行输入M(图中节点数) N(边数)
        后续N行格式为：V1 V2表示一个V1到V2的边。
数据范围：1 <= M <= 15,0 <= N <= M * 3，不能保证所有节点都是连通的。
     输出描述
         输出一个数字表示染色方案的个数。
 */

public class UndirectedGraphStaining {
    static HashMap<Integer, HashSet<Integer>> connect;

    static int nodeCount, edgeCount;

    static LinkedList<HashSet<Integer>> path;

    static int count = 1;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        nodeCount = in.nextInt();
        edgeCount = in.nextInt();
        path = new LinkedList<>();
        connect = new HashMap<>();
        for (int i = 0; i < edgeCount; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            connect.computeIfAbsent(a, (c) -> new HashSet<>()).add(b);
            connect.computeIfAbsent(b, (c) -> new HashSet<>()).add(a);
        }
        //本质上就是 dfs遍历所有节点可能性。 比如【1,2,3】、【4】
        // 首先一个大的for循环 遍历【1,2,3,4】； 遍历从1开始，选定【1、4】作为红色，此时count==3。因为默认count==1全黑也可以
        System.out.println(dfs(1));
    }

    public static int dfs(int index) {
        if (path.size() == nodeCount) {
            return count;
        }

        outer: for (int i = index; i <= nodeCount; i++) {
            for(HashSet<Integer> p : path) {
                //如果新加入节点i和已有节点j相邻，则说明新加入节点不能染成红色，需要进行剪枝
                if (p.contains(i)) {
                    continue outer;
                }
            }
            count++;
            if (connect.containsKey(i)) {
                path.addLast(connect.get(i));
                count = dfs(i + 1);
                path.removeLast();
            } else {
                //针对单独一个点【4】，没有任何点与其连接情况，单独进行判断。也就是connect.containsKey(i)==null
                count = dfs(i + 1);
            }
        }
        return count;
    }

}
