package Section1_String.String_Compression;

import java.util.Scanner;

public class Main_v2 {

    public String solution(String str) {

        str = str + " ";
        int cnt = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
            } else {
                sb.append(str.charAt(i));
                if (cnt > 1) {
                    sb.append(cnt);
                    cnt = 1;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);
        System.out.println(T.solution(sc.next()));
    }
}
