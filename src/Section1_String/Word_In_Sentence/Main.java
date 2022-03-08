package Section1_String.Word_In_Sentence;

import java.util.*;

public class Main {

    public String Solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE;
        String[] arr = str.split(" ");

        for (String s : arr) {
            int len = s.length();
            if (len > m) {
                m = len;
                answer = s;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.Solution(str));
    }

}
