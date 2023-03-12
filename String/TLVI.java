package String;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TLVI {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String Tag = reader.readLine();
        String[] arr = reader.readLine().split(" ");

        int left = 0, right = 0;
        while (right < arr.length) {
            String findTag = arr[left];
            int len = bytes2IntLittle((arr[left + 1] + arr[left + 2]).getBytes());
            System.out.println(len);
            left += 2 + len;
        }
    }

    public static int bytes2IntLittle(byte[] bytes) {
        int int1=bytes[0]&0xff;
        int int2=(bytes[1]&0xff)<<8;
        int int3=(bytes[2]&0xff)<<16;
        int int4=(bytes[3]&0xff)<<24;
        return int1|int2|int3|int4;
    }

}

class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int[] Arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ans = 100000+1;
        int[] pre_Negative = new int[Arr.length+1];
        int[] post_Positive = new int[Arr.length+1];
        for(int i=0;i<Arr.length;i++){
            if(Arr[i]>=0) {
                pre_Negative[i + 1] = pre_Negative[i] + 1;
            }else{
                pre_Negative[i+1]=pre_Negative[i];
            }
        }

        for(int i=n-1; i>=0 ;i--){
            if(Arr[i]<=0){
                post_Positive[i] = post_Positive[i+1]+1;
            }else{
                post_Positive[i] = post_Positive[i+1];
            }
        }

        for(int i=0; i<=n;i++){
            ans=Math.min(ans, pre_Negative[i]+post_Positive[i]);
        }
        writer.write(String.valueOf(ans));
        writer.flush();
    }
}