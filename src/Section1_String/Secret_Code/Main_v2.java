package Section1_String.Secret_Code;

import java.util.Scanner;

public class Main_v2 {

    public String solution(int n, String str) {

        String[] arr = new String[n];
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            arr[i] = str.substring(i * 7, (i + 1) * 7);

            int num = 0;
            int digit;
            for (char c : arr[i].toCharArray()) {
                if (c == '#') {
                    digit = 1;
                } else {
                    digit = 0;
                }
                num = num * 2 + digit;
            }
            answer.append((char) num);
        }
        return answer.toString();
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(n, str));
    }
}
