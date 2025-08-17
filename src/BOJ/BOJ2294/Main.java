package BOJ.BOJ2294;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public int solution(int k, int[] coins) {

        int[] dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        if (dp[k] == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return dp[k];
        }
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
        System.out.println(T.solution(k, coins));
    }
}
