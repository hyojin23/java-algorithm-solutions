package Section1_String.The_Shortest_Character_Path;

import java.util.Scanner;

public class Main_v2 {

    public int[] solution(String s, char t) {
        int[] answer = new int[s.length()];
        int p = 1000;

        // Distance to target alphabet on the left
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }

        p = 1000;
        // Distance to target alphabet on the right
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                if (p < answer[i])
                    answer[i] = p;
            }
        }

        return answer;
    }


    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char t = sc.next().charAt(0);
        for (int i : T.solution(s, t))
            System.out.print(i + " ");
    }
}
