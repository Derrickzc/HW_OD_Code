package LogicalAnalysis;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PortMerging {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int M_CONSTANT = 10;

    static final int N_CONSTANT = 100;

    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(reader.readLine());
        if (M > M_CONSTANT) {
            writer.write("[[]]");
            writer.flush();
            return;
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while (M-- > 0) {
            List<Integer> collect = Arrays.stream(reader.readLine().split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
            if (collect.size() > N_CONSTANT) {
                writer.write("[[]]");
                writer.flush();
                return;
            }
            list.add(new ArrayList<>(collect));
        }


        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {

            }
        }


        writer.flush();
    }




}
