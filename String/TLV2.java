package String;

import java.util.HashMap;
import java.util.Scanner;

public class TLV2 {

}
  class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String msg = sc.next();

        int n = sc.nextInt();

        int[] tags = new int[n];
        for (int i = 0; i < n; i++) {
            tags[i] = sc.nextInt();
        }

        getResult(msg, tags);
    }

    public static void getResult(String msg, int[] tags) {
        HashMap<Integer, Integer[]> tagMap = new HashMap<>();

        // 这里i+3的目的是确保tag，len的截取不会越界
        for (int i = 0; i + 3 < msg.length(); i++) {
            int tag = Integer.parseInt(msg.substring(i, i + 2), 16);
            int len = Integer.parseInt(msg.substring(i + 2, i + 4), 16);
            int valueOffset = (i + 4) / 2;

            // 本TLV格式报文段结束位置i
            i += 3 + len * 2;

            // 如果结束位置i越界，则当前TLV报文段是一个不完整的，需要丢弃
            if (i >= msg.length()) break;

            // 题目已经保证tag不会重复
            tagMap.put(tag, new Integer[] {len, valueOffset});
        }

        for (int tag : tags) {
            if (tagMap.containsKey(tag)) {
                Integer[] tmp = tagMap.get(tag);
                int len = tmp[0];
                int valueOffset = tmp[1];
                System.out.println(len + " " + valueOffset);
            } else {
                System.out.println("0 0");
            }
        }
    }
}
