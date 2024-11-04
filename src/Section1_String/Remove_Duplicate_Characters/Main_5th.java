package Section1_String.Remove_Duplicate_Characters;

import java.util.Scanner;

public class Main_5th {

    public String solution(String str) {

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (i == str.indexOf(str.charAt(i))) {
                answer.append(str.charAt(i));
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
