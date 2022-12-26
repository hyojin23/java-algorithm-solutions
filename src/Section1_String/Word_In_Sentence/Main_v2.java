package Section1_String.Word_In_Sentence;

import java.util.Scanner;

public class Main_v2 {

    public String solution(String str) {

        int max = Integer.MIN_VALUE, pos;
        String answer = null;
        while((pos = str.indexOf(" ")) != -1) {
            int len = str.substring(0, pos).length();
            if (len > max) {
                max = len;
                answer = str.substring(0, pos);
            }
            str = str.substring(pos + 1);
        }
        if (str.length() > max)
            answer = str;
        return answer;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
