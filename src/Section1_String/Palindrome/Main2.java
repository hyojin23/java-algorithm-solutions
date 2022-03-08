package Section1_String.Palindrome;

import java.util.Scanner;

// My solution
public class Main2 {

    public String solution(String str) {
        String answer = "";
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        if (str.equalsIgnoreCase(sb.toString())) {
            answer = "YES";
        } else {
            answer = "NO";
        }
        return answer;
    }

    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }

}
