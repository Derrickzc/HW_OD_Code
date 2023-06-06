package LogicalAnalysis;

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestPassword {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] split = reader.readLine().split("\\s+");
        Arrays.sort(split, (a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());
        Set<String> collect = Arrays.stream(split).collect(Collectors.toSet());
        for (int i = split.length - 1; i >= 0; i--) {
            String t= split[i];
            while (!t.equals("")) {
                if (!collect.contains(t)) break;
                t= split[i].substring(0, t.length() - 1);
            }
            if (t.equals("")) {
                writer.write(split[i]);
                writer.flush();
                return;
            }
        }
        writer.write("");
        writer.flush();
    }
}
