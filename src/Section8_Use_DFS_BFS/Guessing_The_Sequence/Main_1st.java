package Section8_Use_DFS_BFS.Guessing_The_Sequence;

import java.util.Scanner;

public class Main_1st {

    static int[] b, p, ch;
    static int n, f;
    int[][] dy = new int[35][35];
    boolean flag = false;

    public int combi(int n, int r) {

        if (dy[n][r] > 0)
            return dy[n][r];

        if (n == r || r ==0) {
            return 1;
        }
        else {
            return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
        }
    }

    public void DFS(int L, int sum) {

        if (flag) return;

        if (L == n) {
            if (sum == f) {
                for (int x : p) {
                    System.out.print(x + " ");
                }
                flag = true;
            }
        }
        else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L + 1, sum + b[L] * p[L]);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();

        b = new int[n];
        p = new int[n];
        ch = new int[n + 1];

        for (int i = 0; i < n; i++) {
            b[i] = T.combi(n - 1, i);
        }
        T.DFS(0, 0);
    }
}
