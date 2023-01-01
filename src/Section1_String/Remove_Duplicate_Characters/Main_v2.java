package Section1_String.Remove_Duplicate_Characters;

import java.util.Scanner;

public class Main_v2 {

    public String solution(String str) {

        String answer;
        boolean isSameAlphabet;
        StringBuilder sb = new StringBuilder();
        for (char inputChar : str.toCharArray()) {
            isSameAlphabet = false;
            if (sb.length() == 0) {
                sb.append(inputChar);
                continue;
            }
            for (char sbChar : sb.toString().toCharArray()) {
                if (sbChar == inputChar) {
                    isSameAlphabet = true;
                    break;
                }
            }
            if (!isSameAlphabet) {
                sb.append(inputChar);
            }
        }

        answer = sb.toString();

        return answer;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);
        System.out.println(T.solution(sc.next()));
    }
}
