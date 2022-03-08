package Section1_String.Valid_Palindrome;

import java.util.Scanner;
// My solution
public class Main2 {

    public String solution(String str) {
        String answer = "";
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char x : arr) {
            if (Character.isAlphabetic(x)) {
                sb.append(x);
            }
        }
        if (sb.toString().equalsIgnoreCase(sb.reverse().toString())) {
            answer = "YES";
        } else {
            answer = "NO";
        }
        return answer;
    }
    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));

    }
}
