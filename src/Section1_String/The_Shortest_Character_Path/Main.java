package Section1_String.The_Shortest_Character_Path;

import java.util.Scanner;

public class Main {

    public int[] solution(String str, char c) {
        int[] answer = new int[str.length()];
        int p = 1000;
        // from left
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == c) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }
        // from right
        p = 1000;
        for (int i=str.length()-1; i>-1; i--) {
            if (str.charAt(i) == c) {
                p = 0;
            } else {
                p++;
                if (p<answer[i]) {
                    answer[i] = p;
                }
            }
        }
            return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        for (int x : T.solution(str, c)) {
            System.out.print(x + " ");
        }

    }
}
