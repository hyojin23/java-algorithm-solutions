package Section1_String.Case_Change;

import java.util.Scanner;

public class Main_v2 {

    public String solution(String str) {

        String answer;
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
            } else {
                c = Character.toUpperCase(c);
            }
            sb.append(c);
        }
        answer = sb.toString();

        return answer;
    }


    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
