package Section1_String.The_Shortest_Character_Path;

import java.util.Scanner;

public class Main {

    public int[] solution(String s, char t) {

        int len = s.length();
        int[] dis = new int[len];
        int pos = 100;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == t) {
                pos = 0;
                dis[i] = pos;
            }
            else {
                dis[i] = ++pos;
            }
        }

        pos = 100;

        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == t) {
                pos = 0;
            }
            else {
                dis[i] = Math.min(dis[i], ++pos);
            }
        }
        return dis;
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
