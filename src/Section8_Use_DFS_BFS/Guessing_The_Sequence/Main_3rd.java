package Section8_Use_DFS_BFS.Guessing_The_Sequence;

import java.util.Scanner;

public class Main_3rd {

    static int n, f;
    static int[] cb;
    static int[] pm, ch;
    static int[][] arr;
    boolean finish = false;

    public int combination(int n, int r) {

        if (arr[n][r] > 0) {
            return arr[n][r];
        }

        if (r == 0 || n == r) {
            return 1;
        }
        else {
            return arr[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
        }
    }

    public void DFS(int L, int sum) {

        if (finish) return;

        if (L == n) {
            if (sum == f) {
                for (int x : pm) {
                    System.out.print(x + " ");
                }
                finish = true;
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    pm[L] = i + 1;
                    ch[i] = 1;
                    DFS(L + 1, sum + pm[L] * cb [L]);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();
        cb = new int[n];
        pm = new int[n];
        ch = new int[n];
        arr = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            cb[i] = T.combination(n -1, i);
        }

        T.DFS(0, 0);
    }
}
