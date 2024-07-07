package Section1_String.Word_In_Sentence;

import java.util.Scanner;

public class Main {

    public String solution(String str) {

        String[] strArr = str.split(" ");
        int maxLength = 0;
        String answer = "";

        for (String s : strArr) {
            if (s.length() > maxLength) {
                answer = s;
                maxLength = s.length();
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(T.solution(str));
    }
}
