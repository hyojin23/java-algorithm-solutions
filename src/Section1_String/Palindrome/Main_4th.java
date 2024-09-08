package Section1_String.Palindrome;

import java.util.Scanner;

public class Main_4th {

    public String solution(String str) {

        StringBuilder rvsStr = new StringBuilder();
        String answer = "NO";

        for (int i = str.length() - 1; i >= 0; i--) {

            rvsStr.append(str.charAt(i));
        }

        if (str.equals(rvsStr.toString())) {
            answer = "YES";
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next().toLowerCase();

        System.out.println(T.solution(str));
    }
}
