package Section1_String.Secret_Code;

import java.util.Scanner;

public class Main_4th {

    public String solution(int n, String str) {

        StringBuilder sb = new StringBuilder();
        String answer = "";

        for (int i = 0; i < n; i++) {
            String s = str.substring(0, 7).replace("#", "1").replace("*", "0");
            str = str.substring(7);

            int res = 0;
            int b = 1;

            for (int j = 6; j >= 0; j--) {

                if (j == 6) {
                    b = b * 1;
                }
                else {
                    b = b * 2;
                }

                res = res + (s.charAt(j) - 48) * b;
            }

            sb.append((char) res);
        }

        answer = sb.toString();

        return answer;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        System.out.println(T.solution(n, str));
    }
}

