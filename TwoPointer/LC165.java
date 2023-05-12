package TwoPointer;

public class LC165 {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.00.1", "1.0.2"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int l = 0, r = 0;
        while (l < v1.length && r < v2.length) {
            if (Integer.parseInt(v1[l]) == Integer.parseInt(v2[r])) {
                l++; r++;
            } else {
                return Integer.parseInt(v1[l]) > Integer.parseInt(v2[r]) ? 1 : -1;
            }
        }
        if (l == v1.length) {
             while (r < v2.length) {
                 if (Integer.parseInt(v2[r]) > 0) return -1;
                 else {
                     r++;
                 }
             }
        }

        if (r == v2.length) {
            while (l < v1.length) {
                if (Integer.parseInt(v1[l]) > 0) return 1;
                else {
                    l++;
                }
            }
        }
        return 0;
    }
}
