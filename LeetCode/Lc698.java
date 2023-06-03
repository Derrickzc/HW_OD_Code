package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lc698 {
    public static void main(String[] args) {

    }

}

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        int subSum = sum / k;
        if (sum % k != 0) return false;
        int[] barrel = new int[k];
        List<Integer> list = new ArrayList<>();
        Arrays.stream(nums).forEach(list::add); list.sort((a, b) -> b.compareTo(a));
        //这里使用的是倒序， 先从大的开始比较容易dfs判断；先让一个桶放慢再说
        if (subSum < list.get(0)) return false;
        return dfs(barrel, subSum, list, 0);

    }
    public static boolean dfs(int[] barrel, int subSum, List<Integer> nums, int index) {
        if (index == nums.size()) return true;
        int selected = nums.get(index);
        for (int i = 0; i < barrel.length; i++) {
            if (i > 0 && barrel[i] == barrel[i - 1]) continue;
            if (selected + barrel[i] <= subSum) {
                barrel[i] += selected;
                if (dfs(barrel, subSum, nums, index + 1)) return true;
                barrel[i] -= selected;
            }
        }
        return false;
    }
}