package Section8_Use_DFS_BFS.Find_Combination;

import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] cb;
    static int[] ch;

    public void DFS(int L, int s) {

        if (L == m) {
            for (int x : cb) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else {
            for (int i = s; i <= n; i++) {
                cb[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        ch = new int[n + 1];
        cb = new int[m];

        T.DFS(0, 1);
    }
}
