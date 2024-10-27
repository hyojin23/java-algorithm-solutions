package Section8_Use_DFS_BFS.Find_Combination;

import java.util.Scanner;

public class Main_4th {

    static int n, m;
    static int[] arr;

    public void DFS(int L, int a) {

        if (L == m) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else {
            for (int i = a + 1; i <= n; i++) {
                arr[L] = i;
                DFS(L + 1, i);
            }
        }
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];

        T.DFS(0, 0);
    }
}
