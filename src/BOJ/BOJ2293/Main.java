package BOJ.BOJ2293;

import java.util.Scanner;

public class Main {

    public int solution(int n, int k, int[] coins) {

        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[k];
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, k, coins));
    }
}
