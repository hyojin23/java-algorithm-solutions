package Section1_String.Case_Change;

import java.util.Scanner;

public class Main_5th {

    public String solution(String str) {

        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            }
            else {
                sb.append(Character.toLowerCase(c));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
