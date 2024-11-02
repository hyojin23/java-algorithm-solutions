package Section10_Dynamic_Programming.Exchange_Of_Coins;

import java.util.Scanner;
import java.util.Arrays;

public class Main_4th {

    static int n, m;

    public int solution(int[] coins) {

        int[] dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    dy[i] = Math.min(dy[i], dy[i - coins[j]] + 1);
                }

                if (dy[i] == Integer.MAX_VALUE) {
                    dy[i] = 0;
                }
            }
        }

        return dy[m];
    }


    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        m = sc.nextInt();

        System.out.println(T.solution(coins));
    }
}
