package Section8_Use_DFS_BFS.Guessing_The_Sequence;

import java.util.Scanner;

public class Main_7th {

    static int n, f;
    static int[] ch, pm, combi;
    static int[][] memo;
    boolean isAnswer = false;

    public void DFS(int L, int sum) {

        if (isAnswer) {
            return;
        }

        if (L == n) {
            if (sum == f) {
                for (int x : pm) {
                    System.out.print(x + " ");
                }
                System.out.println();
                isAnswer = true;
            }
        }
        else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = i;
                    DFS(L + 1, sum + (pm[L] * combi[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static int combi(int n, int r) {

        if (memo[n][r] > 0) {
            return memo[n][r];
        }

        if (n == r || r == 0) {
            return memo[n][r] = 1;
        }
        else {
            return memo[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
        }
    }

    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();
        ch = new int[n + 1];
        pm = new int[n];
        combi = new int[n];
        memo = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            combi[i] = combi(n - 1, i);
        }

        T.DFS(0, 0);
    }
}
