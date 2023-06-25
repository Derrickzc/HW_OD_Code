import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    }


}

/*
    456C - Boredom / 455A - Boredom
    C. Kefa and Park



 */