package Section1_String.Valid_Palindrome;

import java.util.Scanner;

public class Main {

    public String solution(String str) {

        String newStr = str.replaceAll("[^a-z]", "");
        String reverseStr = new StringBuilder(newStr).reverse().toString();

        if (newStr.equals(reverseStr)) {
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
