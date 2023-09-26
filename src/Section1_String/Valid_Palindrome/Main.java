package Section1_String.Valid_Palindrome;

import java.util.Scanner;

public class Main {

    public String solution(String str) {

        String original = str.toUpperCase().replaceAll("[^A-Z]", "");

        String reverseString = new StringBuilder(original).reverse().toString();

        if (original.equals(reverseString)) {
            return "YES";
        }
        else {
            return "NO";
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(T.solution(str));
    }
}
