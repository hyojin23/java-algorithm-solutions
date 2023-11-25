package Section8_Use_DFS_BFS.Find_Duplicate_Permutations;

import java.util.Scanner;

public class Main_1st {

    static int n, m;
    static int[] pm;

    public void DFS(int L) {

        if (L == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else {
            for (int i = 0; i < n; i++) {
                pm[L] = i + 1;
                DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        pm = new int[m];

        T.DFS(0);
    }
}
