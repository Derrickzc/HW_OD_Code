package CodeForces;

import java.util.Scanner;

/*
    C. Divisibility by Eight
    依据数学原理，如果一个数想被8整除，那么其中任意三个尾部数字需要能够被8整除
    The first one is based on the "school" property of the divisibility by eight — number can be divided by eight if and only if its last three digits form a number that can be divided by eight.
    Thus, it is enough to test only numbers that can be obtained from the original one by crossing out and that contain at most three digits (so we check only all one-digit, two-digit and three-digit numbers).
    This can be done in O(len3) with three nested loops (here len is the length of the original number).
 */
public class Round306C{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String target = in.next();
        for (int i = 0; i <= 1000; i += 8) {
            String cur = String.valueOf(i);
            int idx = 0;
            // 已经限制了cur【1000以内】
            for (int j = 0; j < target.length(); j++) {
                if (target.charAt(j) == cur.charAt(idx)) {
                    idx++;
                }
            //所以当总idx长度满足当前， 即表明 target中存在 能够被8整除所需的所有数字
                if (idx == cur.length()) {
                    System.out.println("YES");
                    System.out.println(cur);
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}
