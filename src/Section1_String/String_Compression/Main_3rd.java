package Section1_String.String_Compression;

import java.util.Scanner;

public class Main_3rd {

    public String solution(String str) {

        int n = str.length();
        StringBuilder sb = new StringBuilder();

        int cnt = 1;
        str = str + "#";

        for (int i = 0; i < n; i++) {

            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
            }
            else {
                sb.append(str.charAt(i));

                if (cnt > 1) {
                    sb.append(cnt);
                }
                cnt = 1;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
