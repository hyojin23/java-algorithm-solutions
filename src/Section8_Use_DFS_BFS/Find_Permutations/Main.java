package Section8_Use_DFS_BFS.Find_Permutations;

import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] arr;
    static int[] ch;
    static int[] pm;

    public void DFS(int L) {

        if (L == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else {
            for (int x : arr) {
                if (ch[x] == 0) {
                    pm[L] = x;
                    ch[x] = 1;
                    DFS(L + 1);
                    ch[x] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        ch = new int[11];
        pm = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        T.DFS(0);
    }
}
