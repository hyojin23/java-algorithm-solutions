package Section1_String.Remove_Duplicate_Characters;

import java.util.Scanner;

public class Main_7th {

    public String solution(String str) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == str.indexOf(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
