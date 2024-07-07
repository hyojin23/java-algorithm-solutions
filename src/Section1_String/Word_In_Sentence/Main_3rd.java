package Section1_String.Word_In_Sentence;

import java.util.Scanner;

public class Main_3rd {

    public String solution(String str) {

        String answer = "";
        int max = Integer.MIN_VALUE, pos;

        while ((pos = str.indexOf(' ')) != -1) {
            String word = str.substring(0, pos);

            if (word.length() > max) {
                max = word.length();
                answer = word;
            }
            str = str.substring(pos + 1);
        }

        if (str.length() > max) {
            answer = str;
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(T.solution(str));
    }
}
