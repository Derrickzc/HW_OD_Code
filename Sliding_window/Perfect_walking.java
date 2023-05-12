package Sliding_window;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Perfect_walking {
}
// 本质是求最小覆盖子串
class Perfect_walking_Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String source = sc.next();

        Map<Character, Integer> map = new HashMap<>();
        int avg = source.length() / 4;
        for (char t : source.toCharArray()) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        boolean flag = true;
        StringBuilder target = new StringBuilder();
        for (Character c : map.keySet()) {
            if (map.get(c) > avg) {
                flag = false;
                map.put(c, map.get(c) - avg);
                // map 由此 只记录 "超过" 预算的 字符串
                for (int i = 0; i < map.get(c); i++) {
                    target.append(c);
                }
            }
        }
        if (flag) System.out.println(0);
        System.out.println(minWindow(source, target.toString()));
    }

    public static String minWindow(String s, String t) {
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

/*
题目；完美走位
在第一人称射击游戏中，玩家通过键盘的A、S、D、W四个按键控制游戏人物分别向左、向后、向右、向前进行移动，从而完成走位。
假设玩家每按动一次键盘，游戏任务会向某个方向移动一步，如果玩家在操作一定次数的键盘并且各个方向的步数相同时，此时游戏任务必定会回到原点，则称此次走位为完美走位。
现给定玩家的走位（例如：ASDA），请通过更换其中一段连续走位的方式使得原走位能够变成一个完美走位。其中待更换的连续走位可以是相同长度的任何走位。
请返回待更换的连续走位的最小可能长度。
如果原走位本身是一个完美走位，则返回0。

输入描述
输入为由键盘字母表示的走位s，例如：ASDA

输出描述
输出为待更换的连续走位的最小可能长度。


输入	WASDAASD
输出	1
说明	将第二个A替换为W，即可得到完美走位
输入	AAAA
输出	3
说明	将其中三个连续的A替换为WSD，即可得到完美走位
 */