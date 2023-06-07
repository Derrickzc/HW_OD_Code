package LogicalAnalysis;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BoxesZigzagPattern {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] split = reader.readLine().split("\\s+");
        int N = Integer.parseInt(split[1]);
        char[] charArray = split[0].toCharArray();
        int len = charArray.length;
        char[][] boxed = new char[N][1000];
        for (int i = 0; i < boxed.length; i++) {
            Arrays.fill(boxed[i], '-');
        }
        int x = 0, y = 0, index = 0;
        while (x < N && index < len) {
            while (x < N && index < len) {
                boxed[x][y] = charArray[index++];
                x++;
            }
            y++; x--;
            while (x >= 0 && index < len) {
                boxed[x][y] = charArray[index++];
                x--;
            }
            x = 0; y++;
        }
        StringBuilder ans = new StringBuilder();
        for (char[] chars : boxed) {
            for (char aChar : chars) {
                if (aChar != '-') {
                    ans.append(aChar);
                }
            }
            ans.append("\n");
        }
        ans.deleteCharAt(ans.toString().length() - 1);
        writer.write(ans.toString());
        writer.flush();
    }
}


class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int n = sc.nextInt();

        getResult(str, n);
    }

    public static void getResult(String str, int n) {
        ArrayList<ArrayList<Character>> matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) matrix.add(new ArrayList<>());

        boolean reverse = true;
        for (int i = 0; i < str.length(); i++) {
            int k = i % n;
            if (k == 0) reverse = !reverse;
            if (reverse) k = n - 1 - k;
            matrix.get(k).add(str.charAt(i));
        }

        for (ArrayList<Character> list : matrix) {
            StringBuilder sb = new StringBuilder();
            for (Character character : list) {
                sb.append(character);
            }
            System.out.println(sb);
        }
    }
}