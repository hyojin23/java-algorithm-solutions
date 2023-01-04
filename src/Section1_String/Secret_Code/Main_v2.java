package Section1_String.Secret_Code;

import java.util.Scanner;

public class Main_v2 {

    public String solution(int n, String str) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String binary = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int decimal = Integer.parseInt(binary, 2);
            char c = (char) decimal;
            sb.append(c);
            str = str.substring(7);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(n, str));
    }
}
