package Greedy;

import java.io.*;

public class RoomLayout {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int ans = 0;
        char[] Layout = reader.readLine().toCharArray();
        for (int i = 0; i < Layout.length; i++) {
            //只有遇到机箱才需要放置
            if (Layout[i] == 'M') {
                if (i + 1 < Layout.length && Layout[i+1] == 'I') {
                    ans++;
                    i += 2;
                } else if (i - 1 >= 0 && Layout[i-1] == 'I') {
                    ans++;
                } else {
                    ans = -1;
                    break;
                }
            }
        }
        writer.write(String.valueOf(ans));
        writer.flush();
    }
}
