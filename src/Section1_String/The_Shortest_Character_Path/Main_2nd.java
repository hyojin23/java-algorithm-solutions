package Section1_String.The_Shortest_Character_Path;

import java.util.Scanner;

public class Main_2nd {

    public int[] solution(String str, char t) {

        int p = 1000;
        int len = str.length();
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            if (t == str.charAt(i)) {
                p = 0;
                answer[i] = p;
            }
            else {
                answer[i] = ++p;
            }
        }

        p = 1000;

        for (int i = len - 1; i >= 0; i--) {
            if (t == str.charAt(i)) {
                p = 0;
            }
            else {
                answer[i] = Math.min(answer[i], ++p);
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char t = sc.next().charAt(0);

        for (int i : T.solution(str, t)) {
            System.out.print(i + " ");
        }
    }
}
