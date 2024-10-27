package Section8_Use_DFS_BFS.Exchange_Of_Coins;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main_4th {

    static int n, m;
    static Integer[] coins;
    static int answer = Integer.MAX_VALUE;

    public void DFS(int cnt, int sum) {

        if (sum > m) return;

        if (cnt >= answer) return;

        if (sum == m) {
            answer = Math.min(cnt, answer);
        }
        else {
            for (int i = 0; i < n; i++) {
                DFS(cnt + 1, sum + coins[i]);
            }
        }
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        coins = new Integer[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins, Collections.reverseOrder());

        m = sc.nextInt();

        T.DFS(0, 0);
        System.out.println(answer);
    }
}
