package LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    和FromSmallestNumber、FromLargestNumber和CombinationLegalSmallNumber 三者原理相似
 */
public class JZ45 {

}
class JZ45Solution {
    public String minNumber(int[] nums) {
        StringBuilder ans = new StringBuilder();
        List<String> collect = Arrays.stream(nums).mapToObj(String::valueOf).sorted((a, b) -> (a + b).compareTo(b + a)).collect(Collectors.toList());
        collect.forEach(ans::append);
        return ans.toString();
    }
}
