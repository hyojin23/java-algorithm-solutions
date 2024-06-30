package Section8_Use_DFS_BFS.Find_Permutations;

import java.util.Scanner;
public class Main {

    static int n, m;
    static int[] ch;

    public void DFS(int L, int[] arr, int[] answer) {

        if (L == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
        }
        else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    answer[L] = arr[i];
                    ch[i] = 1;
                    DFS(L + 1, arr, answer);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int[] arr = new int[n];
        int[] answer = new int[m];
        ch = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        T.DFS(0, arr, answer);
    }
}
