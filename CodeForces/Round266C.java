package CodeForces;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/*
Input
The first line contains integer n (1 ≤ n ≤ 5·105), showing how many numbers are in the array. The second line contains n integers a[1], a[2], ..., a[n] (|a[i]| ≤  109) — the elements of array a.

Output
Print a single integer — the number of ways to split the array into three parts with the same sum.

前缀和分三段 或者采用 倒着进行后序和
 */
public class Round266C {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(reader.readLine());
        long[] longs = Arrays.stream(reader.readLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
        long[] preSum = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            preSum[i] = preSum[i - 1] + longs[i - 1];
        }
        long ans = 0;
        if (preSum[N] % 3 == 0) {
            long x = preSum[N] / 3, y = 2 * preSum[N] / 3;
            long t = 0;
            for (int i = 1; i < N; i++) {
                if (y == preSum[i]) {
                    ans += t;
                }

                if (x == preSum[i]) {
                    t++;
                }
            }
        }
        writer.write(String.valueOf(ans));
        writer.flush();
    }
}
/*
import java.io.*;
import java.util.Scanner;
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
        start from i = n is not always right, when sum == 0 (is wrong)
           But int i = n - 1 is always right
        for (int i = n - 1; i >= 0; i--) {
            ss += a[i];
            if (ss == sum) {
                cnt[i] = 1;
            }
        }
        /*cnt[i] += cnt[i + 1]
            Must Ensure n - 2 + 1 = n - 1 is inside the cnt[] scope!!
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
*/
/*
    456C - Boredom / 455A - Boredom
    C. Kefa and Park
    Important: isLeafNode !!

    C. Number of Way1
    Codeforces Round 266 (Div. dd)

 */