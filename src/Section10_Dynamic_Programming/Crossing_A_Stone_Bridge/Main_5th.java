package Section10_Dynamic_Programming.Crossing_A_Stone_Bridge;

import java.util.Scanner;

public class Main_5th {

    public int solution(int n, int[] dy) {

        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n + 1; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }

        return dy[n + 1];
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dy = new int[n + 2];

        System.out.println(T.solution(n, dy));
    }
}
