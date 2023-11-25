package Section8_Use_DFS_BFS.Find_Duplicate_Permutations;

import java.util.Scanner;

public class Main {

    static int n, m;

    public void DFS(int L, int[] arr) {

        if (L == m) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        else {
            for (int i = 1; i <= n; i++) {
                arr[L] = i;
                DFS(L + 1, arr);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int[] arr = new int[m];

        T.DFS(0, arr);
    }
}
