package UnionSet;

import java.util.*;
import java.util.stream.Collectors;
@SuppressWarnings("all")
public class FindBestValuePile {
    /*
        题目描述
        给你一个由 '0' (空地)、'1' (银矿)、'2'(金矿) 组成的的地图，矿堆只能由上下左右相邻的金矿或银矿连接形成。超出地图范围可以认为是空地。
        假设银矿价值1，金矿价值2 ，请你找出地图中最大价值的矿堆并输出该矿堆的价值。

        输入描述
            地图元素信息如：
            22220
            00000
            00000
            11111
        地图范围最大 300*300
            0 ≤ 地图元素 ≤ 2
        输出描述
            矿堆的最大价值
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        while (in.hasNextLine()) {
            String t = in.nextLine();
            if ("".equals(t)) {
                System.out.println(getResult(matrix));
                break;
            } else {
                List<Integer> collect = Arrays.stream(t.split("")).map(Integer::parseInt).collect(Collectors.toList());
                matrix.add(new ArrayList<>(collect));
            }
        }
    }

    public static int getResult (ArrayList<ArrayList<Integer>> matrix) {
        int row = matrix.size();
        if (0 == row) return 0;
        int col = matrix.get(0).size();
        int[][] offset = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        UnionSet unionSet = new UnionSet(row * col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix.get(i).get(j) > 0) {
                    for (int[] ints : offset) {
                        int newX = ints[0] + i;
                        int newY = ints[1] + j;
                        if (newX >= 0 && newY >= 0
                                && newX < row && newY < col
                                && matrix.get(newX).get(newY) > 0) {
                            unionSet.union(i * col + j, newX * col + newY);
                            //注意这里是 col！ 也就是列
                            //连通所有能够连通的点【只有当当前点>0才可以进行连通】
                        }
                    }
                }
            }
        }
        // worth的key就是每个连通分量的根，value就是该根的矿堆价值
        HashMap<Integer, Integer> worth = new HashMap<>();
        for (int pos = 0; pos < row * col; pos++) {
            int i = pos / col;
            int j = pos % col;
            //int fa = unionSet.find(pos);
            int fa = unionSet.find(unionSet.fa[pos]);
            //这才是真正的 fa节点！全部汇聚到一点fa！！！
            //注意这里是 连通分量的【根】！！
            worth.put(fa, worth.getOrDefault(fa, 0) + matrix.get(i).get(j));
        }
        return worth.values().stream().max(Integer::compare).orElse(0);
    }

    static class UnionSet {
        int[] fa;

        public UnionSet(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        public void union(int x, int y) {
            //合并的时候，只需要合并父节点即可
            int fa_X = find(x);
            int fa_Y = find(y);
            if (fa_Y != fa_X) {
                fa[fa_X] = fa_Y;
            }
        }

        public int find(int x) {
            if (fa[x] != x) {
                //说明他自己不是自己的父节点， 需要继续向上找真正的父节点
                fa[x] = find(fa[x]);
                return fa[x];
            }
            return x;
        }
    }

}





