package Section1_String.Word_In_Sentence;

import java.util.Scanner;

public class Main_6th {

    public String solution(String str) {

        str = str + " ";
        String answer = "";
        int max = Integer.MIN_VALUE;

        while (str.indexOf(" ") != -1) {
            int idx = str.indexOf(" ");
            String word = str.substring(0, idx);
            if (word.length() > max) {
                answer = word;
                max = word.length();
            }
            str = str.substring(idx + 1);
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(T.solution(str));
    }
}
