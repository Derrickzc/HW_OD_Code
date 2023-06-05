package LogicalAnalysis;

import java.io.*;
import java.util.Arrays;
/*
    模拟商场优惠打折
题目描述
    模拟商场优惠打折，有三种优惠券可以用，满减券、打折券和无门槛券。
    满减券：满100减10，满200减20，满300减30，满400减40，以此类推不限制使用；
    打折券：固定折扣92折，且打折之后向下取整，每次购物只能用1次；
    无门槛券：一张券减5元，没有使用限制。

    每个人结账使用优惠券时有以下限制：
        每人每次只能用两种优惠券，并且同一种优惠券必须一次用完，不能跟别的穿插使用（比如用一张满减，再用一张打折，再用一张满减，这种顺序不行）。
        求不同使用顺序下每个人用完券之后得到的最低价格和对应使用优惠券的总数；如果两种顺序得到的价格一样低，就取使用优惠券数量较少的那个。
 */
public class SimulatedStoreDiscount {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int m = array[0], n = array[1], k = array[2];
        int countPeople = Integer.parseInt(reader.readLine());

        while (countPeople-- > 0) {
            int totalCost = Integer.parseInt(reader.readLine());
            Integer[][] ans = new Integer[4][2];
            //钱，剩余的券个数
            int[] resM = M(totalCost, m);
            int[] resN = N(totalCost, n);


            //先满减后打折
            int[] resMN_N = N(resM[0], n);
            ans[0] = new Integer[] {
                resMN_N[0], m + n - resM[1] - resMN_N[1]
            };

            //先打折后满减
            int[] resNM_M= M(resN[0], m);
            ans[1] = new Integer[] {resNM_M[0], n + m - resN[1] - resNM_M[1] };

            //MK
            int[] resMK_K = K(resM[0], k);
            ans[2] = new Integer[] {resMK_K[0], k + m - resMK_K[1] - resM[1]};

            //NK
            int[] resNK_K = K(resN[0], k);
            ans[3] = new Integer[] {resNK_K[0], n + k - resN[1] - resNK_K[1]};

            Arrays.sort(ans, (a, b) -> a[0].equals(b[0]) ? a[1] - b[1] : a[0] - b[0]  );

            writer.write(String.valueOf(ans[0][0] + " " + ans[0][1]));
            writer.newLine();
        }
        writer.flush();
    }

    //满减 每100减10; 也就是钱其实并不是100、100减少的
    public static int[] M(int price, int m) {
        while (price >= 100 && m > 0) {
            price -= price / 100 * 10;
            m--;
        }
        return new int[] {price, m};
    }

    public static int[] N(int price, int n) {
        if (n >= 1) {
            price = (int) Math.floor(price * 0.92);
            n--;
        }
        return new int[] {price, n};
    }

    public static int[] K (int price, int k) {
        while (price > 0 && k > 0) {
            price -= 5;
            // 当无门槛券过多时，是有可能导致优惠后总价低于0的情况的，此时我们应该避免总价小于0的情况
            price = Math.max(price, 0);
            k--;
        }
        return new int[] {price, k};
    }
}
