package Section8_Use_DFS_BFS.Guessing_The_Sequence;

import java.util.Scanner;

public class Main_6th {

    static int n, f;
    static int[] ch, pm, combi;
    static int[][] arr;
    boolean isAnswer = false;

    public void DFS(int L) {

        if (isAnswer) {
            return;
        }

        if (L == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += pm[i] * combi[i];
            }
            if (sum == f) {
                for (int x : pm) {
                    System.out.print(x + " ");
                }
                isAnswer = true;
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = i + 1;
                    DFS(L + 1);
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
            return arr[n][r] = 1;
        }
        else {
            return arr[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
        }
    }

    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();
        ch = new int[n];
        pm = new int[n];
        arr = new int[n + 1][n + 1];
        combi = new int[n];

        for (int i = 0; i < n; i++) {
            combi[i] = T.combi(n - 1, i);
        }

        T.DFS(0);
    }
}
