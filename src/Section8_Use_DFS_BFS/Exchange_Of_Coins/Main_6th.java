package Section8_Use_DFS_BFS.Exchange_Of_Coins;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main_6th {

    static int n, m, answer = Integer.MAX_VALUE;
    static Integer[] coins;

    public void DFS(int L, int sum) {

        if (L >= answer) {
            return;
        }

        if (sum > m) {
            return;
        }

        if (sum == m) {
            answer = L;
        }
        else {
            for (int i = 0; i < n; i++) {
                DFS(L + 1, sum + coins[i]);
            }
        }
    }

    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        coins = new Integer[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        m = sc.nextInt();
        Arrays.sort(coins, Collections.reverseOrder());

        T.DFS(0, 0);
        System.out.println(answer);
    }
}
