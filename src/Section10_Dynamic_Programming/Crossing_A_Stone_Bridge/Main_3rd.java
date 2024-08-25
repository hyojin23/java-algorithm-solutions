package Section10_Dynamic_Programming.Crossing_A_Stone_Bridge;

import java.util.Scanner;

public class Main_3rd {

    public int solution(int n) {

        int[] dy = new int[n + 2];

        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= n + 1; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }

        return dy[n + 1];
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(T.solution(n));
    }
}