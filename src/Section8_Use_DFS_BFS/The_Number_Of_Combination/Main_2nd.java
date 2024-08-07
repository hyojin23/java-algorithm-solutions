package Section8_Use_DFS_BFS.The_Number_Of_Combination;

import java.util.Scanner;

public class Main_2nd {

    int[][] dy = new int[35][35];

    public int DFS(int n, int r) {

        if (dy[n][r] > 0) return dy[n][r];

        if (n == r || r == 0) {

            return 1;
        }
        else {
            return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(T.DFS(n, r));
    }
}
