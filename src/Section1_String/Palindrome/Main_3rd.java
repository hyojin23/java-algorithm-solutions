package Section1_String.Palindrome;

import java.util.Scanner;

public class Main_3rd {

    public String solution(String str) {

        int n = str.length();

        for (int i = 0; i < n / 2; i++) {

            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        String str = sc.next().toLowerCase();

        System.out.println(T.solution(str));
    }
}
