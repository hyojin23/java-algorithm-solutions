package Section10_Dynamic_Programming.Exchange_Of_Coins;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public int solution(int n, int m, int[] coins) {

        int[] dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int c : coins) {
            for (int i = c; i <= m; i++) {
                dy[i] = Math.min(dy[i - c] + 1, dy[i]);
            }
        }
        return dy[m];
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        System.out.println(T.solution(n, m, coins));
    }
}
