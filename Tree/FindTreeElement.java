package Tree;

import java.util.*;

public class FindTreeElement {
    //https://blog.csdn.net/caibiyuge/article/details/129178928
}
class Main {
    // dfs写法；
    static ArrayList<Integer[]> nodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer[] node =
                    Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            nodes.add(node);
        }

        int tx = sc.nextInt();
        int ty = sc.nextInt();

        System.out.println(getResult(nodes, tx, ty));
    }

    public static String getResult(ArrayList<Integer[]> nodes, int tx, int ty) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        dfs(matrix, nodes.get(0), 0);

        if (tx < matrix.size() && ty < matrix.get(tx).size()) {
            return "{" + matrix.get(tx).get(ty) + "}";
        } else {
            return "{}";
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> matrix, Integer[] node, Integer level) {
        if (node == null) return;

        int val = node[0];

        if (level < matrix.size()) {
            matrix.get(level).add(val);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(val);
            matrix.add(list);
        }

        // 将二叉树处理逻辑，改成多叉树
        //    if (node.length > 1) {
        //      int left = node[1];
        //      dfs(matrix, nodes.get(left), level + 1);
        //    }
        //
        //    if (node.length > 2) {
        //      int right = node[2];
        //      dfs(matrix, nodes.get(right), level + 1);
        //    }

        for (int i = 1; i < node.length; i++) {
            int child = node[i];
            dfs(matrix, nodes.get(child), level + 1);
        }
    }
}


/**
 * @author guts
 * @Date 2023/2/23 9:38
 * @Version 1.0
 *查找树中元素
 */
 class HW057 {
     //这道题的preQue和curQue只起到了计数的作用，也可以用两个变量代替
     //preQue表示上一层有多少个节点， curQue表示当前有多少个节点， 随着level++， preQueue也会越来越多；同时preQueue也和curQueue一直在交换； 老哥思路挺巧妙的，是咋想到的！！
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            int[][] arr=new int[n][];
            for (int i = 0; i < arr.length; i++) {
                arr[i]= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int row=nums[0];
            int col=nums[1];
            //保存每一层的节点，key是层数，value是该层所有节点，例如2，2对应的值可以map.get(2).get(2)获得
            HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
            //保存上一层的节点
            LinkedList<Integer> preQue=new LinkedList<>();
            //保存本层节点
            LinkedList<Integer> curQue=new LinkedList<>();
            //层数，0层的时候对preQue进行填数特殊处理了，所以从1开始，level在进行preQue和curQue新老交替时level数加1
            int level=1;
            for (int i = 0; i < n; i++) {
                //i=0对应着第0层，填数特殊处理
                if(i==0){
                    for (int j = 0; j < arr[i].length; j++) {
                        if(j==0){
                            map.putIfAbsent(0,new ArrayList<>());
                            map.get(0).add(arr[i][j]);
                        }else preQue.addFirst(arr[i][j]);
                    }
                }else {
                    //preQue。size为0,表示这一层已经结束，进行新老交替，同时层数加一
                    if(preQue.size()==0){
                        preQue=curQue;
                        curQue=new LinkedList<>();
                        level++;
                    }
                    //preQue不是空的，就继续遍历，每次移除一个元素
                    if(!preQue.isEmpty()){
                        preQue.removeLast();
                        for (int j = 0; j < arr[i].length; j++) {
                            if(j==0){
                                map.putIfAbsent(level,new ArrayList<>());
                                map.get(level).add(arr[i][j]);
                                //j==0是值，后面的是要加入queue中的索引，其实有用的只是索引的个数，而不是对应值
                            }else curQue.addFirst(arr[i][j]);
                        }
                    }
                }
            }
            //打印结果
            ArrayList<Integer> list = map.get(row);
            if(list==null) System.out.println("{}");
            else {
                if(col<list.size()){
                    System.out.println("{"+list.get(col)+"}");
                }else System.out.println("{}");
            }
        }
    }
}
