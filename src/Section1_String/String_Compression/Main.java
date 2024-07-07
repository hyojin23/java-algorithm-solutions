package Section1_String.String_Compression;

import java.util.Scanner;

public class Main {

    public String solution(String str) {

        StringBuilder answer = new StringBuilder();
        int len = str.length();
        int cnt = 1;
        str = str + " ";

        for (int i = 0; i < len; i++) {

            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
            }
            else {
                answer.append(str.charAt(i));
                if (cnt != 1) {
                    answer.append(cnt);
                }
                cnt = 1;
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
