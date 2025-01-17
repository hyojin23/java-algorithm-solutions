package Section1_String.Palindrome;

import java.util.Scanner;

public class Main {

    public String solution(String str) {

        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return "NO";
            }
        }
        return "YES";
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next().toUpperCase();
        System.out.println(T.solution(str));
    }
}
