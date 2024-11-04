package Section1_String.String_Compression;

import java.util.Scanner;

public class Main_5th {

    public String solution(String str) {

        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        int len = str.length();
        str = str + " ";
        char[] arr = str.toCharArray();

        for (int i = 0; i < len; i++) {
            if (arr[i] == arr[i + 1]) {
                cnt++;
            }
            else {
                sb.append(arr[i]);
                if (cnt != 1) {
                    sb.append(cnt);
                }
                cnt = 1;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
