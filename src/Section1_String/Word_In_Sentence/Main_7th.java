package Section1_String.Word_In_Sentence;

import java.util.Scanner;

public class Main_7th {

    public String solution(String str) {

        int max = Integer.MIN_VALUE;
        String answer = "";
        str = str + " ";
        while (str.contains(" ")) {
            String word = str.substring(0, str.indexOf(" "));
            if (word.length() > max) {
                max = word.length();
                answer = word;
            }
            str = str.substring(str.indexOf(" ") + 1);
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(T.solution(str));
    }
}
