package Section1_String.Case_Change;

import java.util.Scanner;

public class Main {

    public String solution(String str) {

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 65 && c <= 90) {
                sb.append((char) (c + 32));
            }
            else if (c >= 97 && c <= 122) {
                sb.append((char) (c - 32));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
