package UnionSet;

/*
    并查集
 */

public class Lc547_Copy {
    public static void main(String[] args) {

    }
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            UnionFindSet unionFindSet = new UnionFindSet(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j && isConnected[i][j] == 1) {
                        unionFindSet.union(i, j);
                    }
                }
            }
            return unionFindSet.count;
        }
    }

    class UnionFindSet {
        int count;
        int [] fa;

        public UnionFindSet(int count) {
            this.count = count;
            //count用于统计并查集 总数
            fa = new int[count];
            for (int i = 0; i < fa.length; i++) {
                fa[i] = i;
            }
        }

        public void union(int x, int y) {
            int x_fa = findParent(x);
            int y_fa = findParent(y);
            if (y_fa != x_fa) {
                fa[x_fa] = y_fa;
                count--;
            }
        }

        public int findParent(int x) {
            if (x != fa[x]) {
                fa[x] = findParent(fa[x]);
                return fa[x];
            }
            return x;
        }
        public UnionFindSet() {

        }
    }

}
