package LeetCode;

/*
解释一下吧： 易证：Sn的长度Ln是2的n次方 - 1（利用数学知识已知递推公式求通项） 该串中间字符的下标为mid = 2的n-1次方 S1 = '0' 递归截止条件(n == 1) 如果是k == mid，则返回'1' 如果是k < mid， 左子串即为Sn-1，故相当于求Sn-1的第k个字符（递归） 如果是k > mid， Sn的第k位相当于右子串的k - mid位，由于右子串翻转了的，故相当于左子串的Ln-1 - (k - mid) + 1处[取反]  +1 是因为Si中间有个 固定的1存在！！
    注意此处是求2的n次方 可以不用pow或者自己写快速幂，直接用<<移位符号（二进制）
*/
public class Lc1545 {
    public static void main(String[] args) {

    }
    class Solution {
        public char findKthBit(int n, int k) {
            if (n == 1) {
                return '0';
            }

            //double half = Math.pow(2, n - 2);
            int half = 1 << (n - 1);
            if (k > half) {
                return '0' == findKthBit(n - 1 , 2 * half - k) ? '1' : '0';
            } else if (k ==half) {
                return '1';
            } else {
                return findKthBit(n - 1, k);
            }

        }
    }
}
