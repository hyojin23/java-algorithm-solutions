package Section10_Dynamic_Programming.Climbing_The_Stairs;

import java.util.Scanner;

public class Main_4th {

    public int solution(int n) {

        int[] dy = new int[n + 1];

        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }

        return dy[n];
    }


    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(T.solution(n));
    }
}
