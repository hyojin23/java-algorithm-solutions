package Section1_String.Secret_Code;

import java.util.Scanner;

public class Main {

    public String solution(int n, String str) {

        str = str.replace('#', '1').replace('*', '0');
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String code = str.substring(0, 7);
            answer.append((char) Integer.parseInt(code, 2));
            str = str.substring(7);
        }
        return answer.toString();
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        System.out.println(T.solution(n, str));
    }
}
