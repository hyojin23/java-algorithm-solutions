package Section8_Use_DFS_BFS.The_Number_Of_Combination;

import java.util.Scanner;

public class Main_3rd {

    static int n, m;
    static int[] arr;

    public void DFS(int L, int s) {

        if (L == m) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else {
            for (int i = s; i <= n; i++) {
                arr[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];

        T.DFS(0, 1);
    }
}
