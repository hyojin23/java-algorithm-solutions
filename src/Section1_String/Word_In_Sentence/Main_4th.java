package Section1_String.Word_In_Sentence;

import java.util.Scanner;

public class Main_4th {

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

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(T.solution(str));
    }
}
