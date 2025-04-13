package Section8_Use_DFS_BFS.The_Number_Of_Combination;

import java.util.Scanner;

public class Main_7th {

    static int[][] arr;

    public int DFS(int n, int r) {

        if (arr[n][r] > 0) {
            return arr[n][r];
        }

        if (n == r || r == 0) {
            return arr[n][r] = 1;
        }
        else {
            return arr[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        arr = new int[n + 1][r + 1];
        System.out.println(T.DFS(n, r));
    }
}
