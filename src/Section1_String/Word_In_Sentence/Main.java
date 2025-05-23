package Section1_String.Word_In_Sentence;

import java.util.Scanner;

public class Main {

    public String solution(String str) {

        str += " ";
        String answer = "";
        int max = Integer.MIN_VALUE;
        while (str.contains(" ")) {
            String word = str.substring(0, str.indexOf(" "));
            if (word.length() > max) {
                answer = word;
                max = word.length();
            }
            str = str.substring(str.indexOf(" ") + 1);
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
