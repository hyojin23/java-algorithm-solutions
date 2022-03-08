package Section1_String.Case_Change;

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        String answer = "";

        for (char s : str.toCharArray()) {
            if (Character.isLowerCase(s)) {
                answer += Character.toUpperCase(s);
            } else {
                answer += Character.toLowerCase(s);
            }
        }
        return answer;
    }

        // sing ASCII code

//        for (char s : str.toCharArray()) {
//            if (s >= 97 && s <= 122) {
//                answer += (char)(s - 32);
//            } else {
//                answer += (char)(s + 32);
//            }
//        }
//        return answer;
//    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));

    }

}
