package Brute_Force;

import com.sun.corba.se.spi.ior.iiop.IIOPFactories;

import java.io.*;

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
                        return  false;
                    }
            }

            if (i >= 6) {
                if (present < 4) return false;
                if (Source[i - 6].equals("present")) present--;
            }
        }
        return true;
    }

}
