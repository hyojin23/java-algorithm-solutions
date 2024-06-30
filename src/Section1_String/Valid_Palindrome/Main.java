package Section1_String.Valid_Palindrome;

import java.util.Scanner;

public class Main {

    public String solution(String str) {

        str = str.replaceAll("[^a-z]", "");

        StringBuilder sb = new StringBuilder(str);

        if (str.equals(sb.reverse().toString())) {
            return "YES";
        }
        else {
            return "NO";
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().toLowerCase();

        System.out.println(T.solution(str));
    }
}
