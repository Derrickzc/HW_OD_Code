package Tree;

import java.util.*;

public class FindTreeElement {

}


/**
 * @author guts
 * @Date 2023/2/23 9:38
 * @Version 1.0
 *查找树中元素
 */
 class HW057 {
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
