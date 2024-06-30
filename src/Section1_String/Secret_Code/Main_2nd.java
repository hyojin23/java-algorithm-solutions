package Section1_String.Secret_Code;

import java.util.Scanner;

public class Main_2nd {

    public String solution(String str, int n) {

        String answer = "";

        for (int i = 0; i < n; i++) {
            String s = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(s, 2);
            answer += (char) num;
            str = str.substring(7);
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        System.out.println(T.solution(str, n));
    }
}
