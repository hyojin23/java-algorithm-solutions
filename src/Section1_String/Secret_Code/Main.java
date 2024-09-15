package Section1_String.Secret_Code;

import java.util.Scanner;

public class Main {

    public String solution(int n, String str) {

        int len = 7;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String signal = str.substring(0, len);
            str = str.substring(len);

            int answer = 0;
            int base = 1;

            for (int j = len - 1; j >= 0; j--) {
                if (signal.charAt(j) == '#') {
                    answer += base;
                }
                base = base * 2;
            }
            sb.append((char) answer);
        }

        return sb.toString();
    }


    public static void main(String[] argss) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        System.out.println(T.solution(n, str));
    }
}
