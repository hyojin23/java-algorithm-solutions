package Section1_String.The_Shortest_Character_Path;

import java.util.Scanner;

public class Main_3rd {

    public int[] solution(String s, char t) {

        int n = s.length();
        int[] answer = new int[n];

        int d = 100;
        char[] cArr = s.toCharArray();

        for (int i = 0; i < n; i++) {

            if (cArr[i] == t) {
                d = 0;
            }
            else {
                d++;
            }
            answer[i] = d;
        }

        d = 100;
        for (int i = n - 1; i >= 0; i--) {

            if (cArr[i] == t) {
                d = 0;
            }
            else {
                d++;
            }
            answer[i] = Math.min(answer[i], d);
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        char t = sc.next().charAt(0);

        for (int i : T.solution(s, t)) {
            System.out.print(i + " ");
        }
    }
}
