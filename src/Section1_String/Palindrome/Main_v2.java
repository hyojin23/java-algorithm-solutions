package Section1_String.Palindrome;

import java.util.Scanner;

public class Main_v2 {

    public String solution(String str) {

        String reverseStr = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(reverseStr))
            return "YES";
        return "NO";
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);
        System.out.println(T.solution(sc.next()));
    }
}
