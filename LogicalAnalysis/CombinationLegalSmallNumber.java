package LogicalAnalysis;

import java.io.*;
import java.util.Arrays;

public class CombinationLegalSmallNumber {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] split = reader.readLine().split("\\s+");
        Arrays.sort(split, (a, b) -> (a + b).compareTo(b + a));
        if (split[0].charAt(0) == '0') {
            for (int i = 1; i < split.length; i++) {
                if (split[i].charAt(0) != '0') {
                    split[0] = split[i] + split[0];
                    split[i] = "";
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(s);
        }
        String s = sb.toString().replaceAll("^0+", "");

        writer.write("".equals(s) ? "0" : s );
        writer.flush();
    }
}
