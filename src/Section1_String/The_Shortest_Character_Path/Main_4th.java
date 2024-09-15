package Section1_String.The_Shortest_Character_Path;

import java.util.Arrays;
import java.util.Scanner;

public class Main_4th {

    public int[] solution(String str, char c) {

        int len = str.length();
        int[] answer = new int[len];
        int dis = 100;
        Arrays.fill(answer, 100);

        for (int i = 0; i < len; i++) {
            if (c == str.charAt(i)) {
                dis = 0;
            }
            else {
                dis++;
            }
            if (dis < answer[i]) {
                answer[i] = dis;
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if (c == str.charAt(i)) {
                dis = 0;
            }
            else {
                dis++;
            }
            if (dis < answer[i]) {
                answer[i] = dis;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char c = sc.next().charAt(0);

        for (int i : T.solution(str, c)) {
            System.out.print(i + " ");
        }
    }
}