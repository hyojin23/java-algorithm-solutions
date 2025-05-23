package Section8_Use_DFS_BFS.Guessing_The_Sequence;

import java.util.Scanner;

public class Main {

    static int n, f;
    static int[] ch, pm, combi;
    static int[][] arr;
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
                isAnswer = true;
            }
        }
        else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    pm[L] = i;
                    ch[i] = 1;
                    DFS(L + 1, sum + pm[L] * combi[L]);
                    ch[i] = 0;
                }
            }
        }
    }

    public int combi(int n, int r) {

        if (arr[n][r] > 0) {
            return arr[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        }
        else {
            return arr[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();
        ch = new int[n + 1];
        pm = new int[n];
        arr = new int[n][n];
        combi = new int[n];
        for (int i = 0; i < n; i++) {
            combi[i] = T.combi(n - 1, i);
        }
        T.DFS(0, 0);
    }
}
