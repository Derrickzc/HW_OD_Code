package UnionSet;

import java.util.*;
@SuppressWarnings("all")
public class HappyWeekend {
    /*
         欢乐的周末（Java & JS & Python）
      输入描述
            第一行输入m和n，m代表地图的长度，n代表地图的宽度。
            第二行开始具体输入地图信息，地图信息包含：
            0 为通畅的道路
            1 为障碍物（且仅1为障碍物）
            2 为小华或者小为，地图中必定有且仅有2个 （非障碍物）
            3 为被选中的聚餐地点（非障碍物）
        输出描述
            可以被两方都到达的聚餐地点数量，行末无空格。
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] temp = Arrays.stream(in.nextLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
        int n = temp[0], m = temp[1];
        int[][] mn = new int[m][n];
        int[][] offset = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        UnionFindSet unionFindSet = new UnionFindSet(m * n);
        List<int[]> location = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int[] ints = Arrays.stream(in.nextLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                mn[i][j] = ints[j];
            }
        }
        //构建mn图

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mn[i][j] == 1) continue;
                    //遇到障碍跳过
                else if (mn[i][j] == 2) {
                    location.add(new int[]{2, i, j});
                    //遇到 hua Or wei 记录
                } else if (mn[i][j] == 3) {
                    location.add(new int[]{3, i, j});
                    //遇到 餐厅地点记录
                }
                for (int[] ints : offset) {
                    int new_X = i + ints[0];
                    int new_Y = j + ints[1];
                    if (new_X >= 0 && new_Y >= 0
                            && new_X < m && new_Y < n
                            && mn[new_X][new_Y] != 1) {
                           unionFindSet.union(i * n + j, new_X * n + new_Y);
                           //将除了障碍以外的，所有能够连通的点进行连通
                    }
                }
            }
        }
        int[] Hua = null;
        int[] Wei = null;

        Iterator<int[]> iterator = location.iterator();
        while (iterator.hasNext()) {
            int[] next = iterator.next();
            if (next[0] == 2) {
                if (Hua == null) {
                    Hua = next;
                } else {
                    Wei = next;
                }
                iterator.remove();
            }
        }
        //筛选两个人的坐标位置

        if (unionFindSet.find(Hua[1] * n + Hua[2]) == unionFindSet.find(Wei[1] * n + Wei[2])) {
            //如果两个人不能连通 直接返回0 ；
            for (int i = 0; i < location.size(); i++) {
                if (unionFindSet.find(Hua[1] * n + Hua[2])
                        == unionFindSet.find(location.get(i)[1] * n + location.get(i)[2]) ) {
                    ans++;
                }
                //如果能够两个人连通，统计所有餐厅的坐标的fa[]相同；数量
            }
        }
        System.out.println(ans);
    }

    static class UnionFindSet {
        int[] fa;
        public UnionFindSet(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        public int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
                return fa[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int fa_X = find(x);
            int fa_Y = find(y);

            if (fa_X != fa_Y) {
                fa[fa_Y] = fa_X;
            }
        }

    }

}
