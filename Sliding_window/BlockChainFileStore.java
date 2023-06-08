package Sliding_window;

import java.io.*;
import java.util.Arrays;

/*
 区块链文件转储系统

题目描述
    区块链底层存储是一个链式文件系统，由顺序的N个文件组成，每个文件的大小不一，依次为F1,F2,...,Fn。随着时间的推移，所占存储会越来越大。
    云平台考虑将区块链按文件转储到廉价的SATA盘，只有连续的区块链文件才能转储到SATA盘上，且转储的文件之和不能超过SATA盘的容量。
    假设每块SATA盘容量为M，求能转储的最大连续文件之和。
输入描述
    第一行为SATA盘容量M，1000 ≤ M ≤ 1000000
    第二行为区块链文件大小序列F1,F2,...,Fn。其中 1 ≤ n ≤ 100000，1 ≤ Fi ≤ 500
输出描述
    求能转储的最大连续文件大小之和
 */

public class BlockChainFileStore {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int totalStore = Integer.parseInt(reader.readLine());
        int[] blokcChainFile = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int l = 0, r = 0, curStore = 0;
        int ans = Integer.MIN_VALUE;
        while (r < blokcChainFile.length) {
            curStore += blokcChainFile[r++];
            while (curStore > totalStore) {
                curStore -= blokcChainFile[l++];
            }
            ans = Math.max(ans, curStore);
        }
        writer.write(String.valueOf(ans));
        writer.flush();
    }
}
