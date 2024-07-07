package Section1_String.Secret_Code;

import java.util.Scanner;

public class Main_3rd {

    public String solution(int n, String str) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {

            String bStr = str.substring(0, 7).replace('#', '1').replace('*', '0');
            str = str.substring(7);

            sb.append((char) Integer.parseInt(bStr, 2));
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        System.out.println(T.solution(n, str));

    }
}
