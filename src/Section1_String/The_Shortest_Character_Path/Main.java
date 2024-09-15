package Section1_String.The_Shortest_Character_Path;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public int[] solution(String s, char t) {

        int len = s.length();
        int[] answer = new int[len];
        Arrays.fill(answer, Integer.MAX_VALUE);
        char[] arr = s.toCharArray();

        int dis = -1;
        for (int i = 0; i < len; i++) {
            if (arr[i] == t) {
                dis = 0;
                answer[i] = dis;
            }
            else {
                if (dis != -1) {
                    answer[i] = Math.min(++dis, answer[i]);
                }
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] == t) {
                dis = 0;
                answer[i] = dis;
            }
            else {
                if (dis != -1) {
                    answer[i] = Math.min(++dis, answer[i]);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        char t = sc.next().charAt(0);

        for (int x : T.solution(s, t)) {
            System.out.print(x + " ");
        }
    }
}
