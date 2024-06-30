package Section1_String.Palindrome;

import java.util.Scanner;

public class Main_2nd {

    public String solution(String str) {

        int len = str.length() / 2;
        str = str.toLowerCase();

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
