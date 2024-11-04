package Section1_String.Remove_Duplicate_Characters;

import java.util.Scanner;

public class Main {

    public String solution(String str) {

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == str.indexOf(c)) {
                answer.append(c);
            }
        }
        return answer.toString();
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
