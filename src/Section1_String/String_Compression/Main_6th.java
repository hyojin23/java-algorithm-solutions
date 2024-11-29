package Section1_String.String_Compression;

import java.util.Scanner;

public class Main_6th {

    public String solution(String str) {

        int cnt = 1;
        str = str + " ";
        char[] cArr = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cArr.length - 1; i++) {
            if (cArr[i] == cArr[i + 1]) {
                cnt++;
            }
            else {
                sb.append(cArr[i]);
                if (cnt != 1) {
                    sb.append(cnt);
                }
                cnt = 1;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
