package Section1_String.The_Shortest_Character_Path;

import java.util.Scanner;

public class Main {

    public int[] solution(String s, char t) {

        int n = s.length();
        int[] answer = new int[n];
        int dis = 100;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == t) {
                dis = 0;
            }
            else {
                dis++;
            }
            answer[i] = dis;
        }

        dis = 100;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == t) {
                dis = 0;
            }
            else {
                dis++;
            }
            answer[i] = Math.min(answer[i], dis);
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
