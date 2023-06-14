package Brute_Force;

import java.io.*;
/*
    考勤信息
    题目描述
        公司用一个字符串来表示员工的出勤信息
        absent：缺勤
        late：迟到
        leaveearly：早退
        present：正常上班
        现需根据员工出勤信息，判断本次是否能获得出勤奖，能获得出勤奖的条件如下：
            缺勤不超过一次；
            没有连续的迟到/早退；
            任意连续7次考勤，缺勤/迟到/早退不超过3次。
      输入描述
        用户的考勤数据字符串
        记录条数 >= 1；
        输入字符串长度 < 10000；
        不存在非法输入；
        如：
            2
            present
            present absent present present leaveearly present absent
    输出描述
        根据考勤数据字符串，如果能得到考勤奖，输出”true”；否则输出”false”，
        对于输入示例的结果应为：
            true false
 */
public class Attendance_Information {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(reader.readLine());
        while (N-- > 0) {
            String[] Source = reader.readLine().split("\\s+");

            if (getResult(Source)) {
                writer.write(String.valueOf(Boolean.TRUE));
            } else {
                writer.write(String.valueOf(Boolean.FALSE));
            }
            writer.newLine();
        }
        writer.flush();
    }

    public static boolean getResult(String[] Source) {
        int absent = 0, present = 0;
        String pre_State = "";
        for (int i = 0; i < Source.length; i++) {
            if (i >= 1) {
                pre_State = Source[i - 1];
            }

            switch (Source[i]) {
                case "present" :
                    present++;
                    break;
                case "absent" :
                    absent++;
                    if (absent > 1) {
                        return false;
                    }
                    break;
                case "late":
                case "leaveearly":
                    if (pre_State.equals("late") || pre_State.equals("leaveearly")) {
                        return false;
                    }
                    //continue status
            }

            if (i >= 6) {
                if (present < 4) return false;
                if (Source[i - 6].equals("present")) present--;
                // reverse logic; instead of count absent/late/leave early, just count present.
            }
        }
        return true;
    }

}
