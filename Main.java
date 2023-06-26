import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
    Specifically for writing repetitive tests
*/
public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer>[] store;
    static boolean[] vis;
    static int ans, m, hasCats[];
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        m = in.nextInt(); hasCats = new int[n + 1]; vis = new boolean[n + 1];
        store = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            hasCats[i] = in.nextInt();
            store[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            store[a].add(b);
            store[b].add(a);
        }
        vis[1] = true;
        dfs(1, hasCats[1]);
        System.out.println(ans);
    }

/*    public static void dfs(int index, int catCount) {
        ArrayList<Integer> integers = store[index];
        boolean isLeaf = true;
        for (Integer cur : integers) {
            if (vis[cur]) continue;
            int x = (catCount + 1) * hasCats[cur];
            vis[cur] = true;
            if (x <= m) {
                dfs(cur, x);
            }
            isLeaf = false;
        }
        if (isLeaf) {
            ans++;
        }
    }*/

    public static void dfs(int curNode, int tolerateCat) {
        boolean isLeaf = store[curNode].size() == 1;
        for (Integer integer : store[curNode]) {
            if (vis[integer]) continue;
            // leaf Node cannot go to their parents Node.
            int x = (tolerateCat + 1) * hasCats[integer];
            vis[integer] = true;
            if (x <= m) {
                dfs(integer, x);
            }
            isLeaf = false;
        }
        if (isLeaf) {
            ans++;
        }
/*        boolean isLeafNode = store[curNode].isEmpty();
        Wrong: Because leaf Node must have parents; But parents will not arrive (from their son node)
*/
    }
}

/*
    456C - Boredom / 455A - Boredom
    C. Kefa and Park
    Important: isLeafNode !!



 */