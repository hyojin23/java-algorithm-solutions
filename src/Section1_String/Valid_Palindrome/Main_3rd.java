package Section1_String.Valid_Palindrome;

import java.util.Scanner;

public class Main_3rd {

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

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().toLowerCase();

        System.out.println(T.solution(str));
    }
}
