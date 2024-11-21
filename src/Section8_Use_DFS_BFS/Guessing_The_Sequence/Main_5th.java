package Section8_Use_DFS_BFS.Guessing_The_Sequence;

import java.util.Scanner;

public class Main_5th {

    static int n, f;
    static int[] pm, ch, combiArr;
    static int[][] arr;
    boolean isAnswer = false;

    public void DFS(int L) {

        if (isAnswer) {
            return;
        }

        if (L == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += combiArr[i] * pm[i];
            }
            if (sum == f) {
                for (int x : pm) {
                    System.out.print(x + " ");
                    isAnswer = true;
                }
                System.out.println();
            }
        }
        else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = i;
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
            return 1;
        }
        else {
            return arr[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
        }
    }

    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();
        pm = new int[n];
        ch = new int[n + 1];
        arr = new int[n][n];
        combiArr = new int[n];

        for (int i = 0; i < n; i++) {
            combiArr[i] = T.combi(n - 1, i);
        }

        T.DFS(0);
    }
}
