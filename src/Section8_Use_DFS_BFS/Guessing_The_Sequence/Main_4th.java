package Section8_Use_DFS_BFS.Guessing_The_Sequence;

import java.util.Scanner;
public class Main_4th {

    static int[][] arr;
    static int n, f;
    static int[] ch, pm, combi;
    boolean flag = false;

    public int combination(int n, int r) {

        if (arr[n][r] != 0) {
            return arr[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        }
        else {
            return arr[n][r] = combination(n - 1, r) + combination(n - 1, r - 1);
        }
    }

    public void DFS(int L, int sum) {

        if (flag) return;

        if (L == n) {
            if (sum == f) {
                for (int x : pm) {
                    System.out.print(x + " ");
                }
                flag = true;
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = i + 1;
                    DFS(L + 1, sum + pm[L] * combi[L]);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();
        arr = new int[n][n];
        combi = new int[n];
        pm = new int[n];
        ch = new int[n];

        for (int i = 0; i < n; i++) {
            combi[i] = T.combination(n - 1, i);
        }

        T.DFS(0, 0);
    }
}
