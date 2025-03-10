package Section10_Dynamic_Programming.Climbing_The_Stairs;

import java.util.Scanner;

public class Main {

    static int[] dy;

    public int solution(int n) {

        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i -1] + dy[i - 2];
        }
        return dy[n];
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        dy = new int[n + 1];
        System.out.println(T.solution(n));
    }
}
