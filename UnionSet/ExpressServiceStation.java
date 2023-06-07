package UnionSet;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressServiceStation {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(reader.readLine());
        UnionSet unionSet = new UnionSet(N);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Integer> collect = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
            list.add(collect);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
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
         int[] fa;

         public UnionSet(int N) {
             count = N;
             fa = new int[N];
//             for (int i = 0; i < N; i++) {
//                 fa[i] = i;
//             }
             Arrays.setAll(fa, p -> p);
         }

         public void union(int x, int y) {
             int fa_x = find(x);
             int fa_y = find(y);
             if (fa_x != fa_y) {
                 count--;
                 fa[fa_x] = fa_y;
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
