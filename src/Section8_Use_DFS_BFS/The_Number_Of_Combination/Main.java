package Section8_Use_DFS_BFS.The_Number_Of_Combination;

import java.util.Scanner;

public class Main {

    static int[][] arr;

    public int DFS(int n, int r) {

        if (arr[n][r] != 0) {
            return arr[n][r];
        }

        if (n == r) {
            return 1;
        }

        if (n == 1 || r == 0) {
            return 1;
        }
        else {
            return arr[n][r] = DFS(n - 1, r) + DFS(n - 1, r  - 1);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        arr = new int[n + 1][n + 1];

        System.out.println(T.DFS(n, r));
    }
}
