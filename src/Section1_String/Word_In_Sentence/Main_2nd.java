package Section1_String.Word_In_Sentence;

import java.util.Scanner;

public class Main_2nd {

    public String solution(String str) {

        int max = Integer.MIN_VALUE;
        int pos;
        String answer = "";

        while((pos = str.indexOf(" ")) != -1) {
            String  s = str.substring(0, pos);
            if (s.length() > max) {
                answer = s;
                max = s.length();
            }
            str = str.substring(pos + 1);
        }
        if (str.length() > max) {
            answer = str;
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(T.solution(str));
    }
}
