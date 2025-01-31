package Section1_String.String_Compression;

import java.util.Scanner;

public class Main {

    public String solution(String str) {

        str = str + " ";
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
            }
            else {
                sb.append(str.charAt(i));
                if (cnt != 1) {
                    sb.append(cnt);
                    cnt = 1;
                }
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
