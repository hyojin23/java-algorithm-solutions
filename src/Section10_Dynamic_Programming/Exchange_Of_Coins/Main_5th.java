package Section10_Dynamic_Programming.Exchange_Of_Coins;

import java.util.Scanner;
import java.util.Arrays;

public class Main_5th {

    public int solution(int n, int m, int[] coins) {

        int[] dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= m; i++) {
                dy[i] = Math.min(dy[i], dy[i - coin] + 1);
            }
        }
        return dy[m];
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
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
