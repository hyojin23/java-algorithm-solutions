package Section1_String.Palindrome;

import java.util.Scanner;

public class Main {

    public String solution(String str) {

        String rvsStr = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(rvsStr)) {
            return "YES";
        }
        else {
            return "NO";
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
