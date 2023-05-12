package Sliding_window;

import java.util.HashMap;

public class Lc76 {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t)  {
        // containsCharacter 一次成功； 则丧失用途
        return "";
    }

}

class Lc76_Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        int start = 0, strLen = Integer.MAX_VALUE;

        int countStardard = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char temp : t.toCharArray()) {
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        while (right < s.length()) {
            char sChar= s.charAt(right);
            if (map.containsKey(sChar)) {
                if (map.get(sChar) > 0) countStardard++;
                // > 0 表示当前还不能够算是完美的子串; countStardard 还需要继续增加
                map.put(sChar, map.getOrDefault(sChar, 0) - 1);
            }

            while (left < right && (!map.containsKey(s.charAt(left)) || map.get(s.charAt(left)) < 0  ) ) {
                // 进入while循环两种条件;
                // 1/ s.charAt(left) 并不是目标字符串; 所以可以 left++
                // 2/ s.charAt(left) 属于 目标字符串里面的目标字符 且数量<0 表示个数已经够了, 后续也可以 left++
                if (!map.containsKey(s.charAt(left))) {
                    left++;
                }

                if (left < right && map.containsKey(s.charAt(left)) && map.get(s.charAt(left)) < 0) {
                    // map.get() < 0 表示 字符数量已经够了.
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    left ++;
                }
            }

            if (countStardard == t.length() && right - left + 1 < strLen) {
                //能够进入此if, 表示 [left, right] 肯定是 满足题意的 子串
                strLen = right - left + 1;
                start = left;
            }
            right ++;
        }

        return strLen == Integer.MAX_VALUE ? "" : s.substring(start, start + strLen);
    }
}
