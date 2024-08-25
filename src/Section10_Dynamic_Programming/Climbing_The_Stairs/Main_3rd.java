package Section10_Dynamic_Programming.Climbing_The_Stairs;

import java.util.Scanner;

public class Main_3rd {

    public int solution(int n) {

        int[] dy = new int[n + 1];

        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }

        return dy[n];
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(T.solution(n));
    }
}
