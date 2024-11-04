package Section1_String.The_Shortest_Character_Path;

import java.util.Scanner;

public class Main {

    public int[] solution(String str, char c) {

        int len = str.length();
        int[] disArr = new int[len];

        int dis = 100;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == c) {
                dis = 0;
            }
            else {
                dis++;
            }
            disArr[i] = dis;
        }

        dis = 100;
        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) == c) {
                dis = 0;
            }
            else {
                dis++;
            }
            disArr[i] = Math.min(dis, disArr[i]);
        }
        return disArr;
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
