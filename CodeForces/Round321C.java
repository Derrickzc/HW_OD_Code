package CodeForces;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
    注意题目要求的是： 1、连续叶子的cat数量； 2、如何准确判断叶子节点
    C. Kefa and Park
 */
public class Round321C {
    static ArrayList<Integer>[] arr;
    static boolean[] used;
    static int m, cats[], ans;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        m = in.nextInt(); cats = new int[n + 1]; used = new boolean[n + 1]; arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
             cats[i] = in.nextInt();
             arr[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }
        used[1] = true;
        dfs(1, cats[1]);
        System.out.print(ans);
    }
    public static void dfs(int index, int catCount) {
        ArrayList<Integer> integers = arr[index];
        boolean isLeaf = true;
        for (Integer cur : integers) {
            if (used[cur]) continue;
            int x = (catCount + 1) * cats[cur];
            used[cur] = true;
            if (x <= m) {
                dfs(cur, x);
            }
            isLeaf = false;
        }
        if (isLeaf) {
            ans++;
        }
    }
}
