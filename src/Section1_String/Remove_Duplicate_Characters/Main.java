package Section1_String.Remove_Duplicate_Characters;

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        String answer = "";
        for (int i=0; i<str.length(); i++) {
            if (i == str.indexOf(str.charAt(i))) {
                answer += str.charAt(i);
            }
        }

        return answer;
    }

    public static void main(String[] arge) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
