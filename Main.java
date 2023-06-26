import java.io.*;
import java.util.Scanner;

/*
    Specifically for writing repetitive tests
*/
public class Main {
    final static int MAX_INDEX = 1000000 + 10;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long ans = 0;
        int n = in.nextInt();
        int[] a = new int[MAX_INDEX];
        long sum = 0;
        long[] cnt = new long[MAX_INDEX];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            sum += a[i];
        }
        if (sum % 3 != 0) {
            System.out.println("0");
            return;
        }
        sum /= 3;
        long ss = 0;
        /* start from i = n is not always right, when sum == 0 (is wrong)
           But int i = n - 1 is always right
         */
        for (int i = n - 1; i >= 0; i--) {
            ss += a[i];
            if (ss == sum) {
                cnt[i] = 1;
            }
        }
        /*cnt[i] += cnt[i + 1]
            Must Ensure n - 2 + 1 = n - 1 is inside the cnt[] scope!!
         */
        for (int i = n - 2; i >= 0; i--) {
            cnt[i] += cnt[i + 1];
        }
        ss = 0;
        for (int i = 0; i <= n; i++) {
            ss += a[i];
            if (ss == sum) {
                ans += cnt[i + 2];
            }
        }

        System.out.println(ans);
    }
}

/*
    456C - Boredom / 455A - Boredom
    C. Kefa and Park
    Important: isLeafNode !!

    C. Number of Way1
    Codeforces Round 266 (Div. dd)

 */