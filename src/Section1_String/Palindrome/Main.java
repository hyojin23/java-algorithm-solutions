package Section1_String.Palindrome;

import java.util.Scanner;

public class Main {

    public String solution(String str) {

        int lt = 0;
        int rt = str.length() - 1;
        String answer = "YES";

        while (lt < rt) {

            if (str.charAt(lt) != str.charAt(rt)) {
                answer = "NO";
                break;
            }
            lt++;
            rt--;
        }
        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next().toLowerCase();

        System.out.println(T.solution(str));
    }
}
