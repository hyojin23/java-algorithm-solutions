package Section8_Use_DFS_BFS.Find_Duplicate_Permutations;

import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] arr;

    public void DFS(int L) {
        if (L == m) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else {
            for (int i = 1; i <= n; i++) {
                arr[L] = i;
                DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        T.DFS(0);
    }
}
