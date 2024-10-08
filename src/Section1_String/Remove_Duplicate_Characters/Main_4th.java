package Section1_String.Remove_Duplicate_Characters;

import java.util.Scanner;

public class Main_4th {

    public String solution(String str) {

        StringBuilder answer = new StringBuilder();
        int[] ch = new int[26];

        for (char c : str.toCharArray()) {
            if (ch[c - 97] == 0) {
                answer.append(Character.toString(c));
                ch[c - 97] = 1;
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}

