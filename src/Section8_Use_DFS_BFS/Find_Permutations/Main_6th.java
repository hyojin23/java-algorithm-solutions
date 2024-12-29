package Section8_Use_DFS_BFS.Find_Permutations;

import java.util.Scanner;

public class Main_6th {

    static int n, m;
    static int[] ch, pm, arr;

    public void DFS(int L) {

        if (L == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        arr = new int[n];
        ch = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        T.DFS(0);
    }
}
