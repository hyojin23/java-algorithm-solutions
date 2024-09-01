package Section1_String.Case_Change;

import java.util.Scanner;

public class Main_4th {

    public String solution(String str) {

        StringBuilder answer = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                answer.append(Character.toUpperCase(c));
            }
            else {
                answer.append(Character.toLowerCase(c));
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
