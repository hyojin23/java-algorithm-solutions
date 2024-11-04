package Section1_String.Word_In_Sentence;

import java.util.Scanner;

public class Main_5th {

    public String solution(String str) {

        str = str + " ";
        int max = Integer.MIN_VALUE;
        String answer = "";

        while (str.contains(" ")) {

            int endIdx = str.indexOf(" ");
            int beginIdx = str.indexOf(" ") + 1;

            String word = str.substring(0, endIdx);
            str = str.substring(beginIdx);

            if (word.length() > max) {
                answer = word;
                max = word.length();
            }
        }

        return answer;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(T.solution(str));
    }
}
