package Section1_String.String_Compression;

import java.util.Scanner;

public class Main_2nd {

    public String solution(String str) {

        StringBuilder sb = new StringBuilder();
        str = str + " ";
        int cnt = 1;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
            }
            else {
                if (cnt == 1) {
                    sb.append(str.charAt(i));
                }
                else {
                    sb.append(str.charAt(i)).append(cnt);
                }
                cnt = 1;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
