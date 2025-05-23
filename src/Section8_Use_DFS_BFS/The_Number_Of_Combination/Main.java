package Section8_Use_DFS_BFS.The_Number_Of_Combination;

import java.util.Scanner;

public class Main {

    static int n, r;
    static int[][] arr;

    public int combi(int n, int r) {

        if (arr[n][r] > 0) {
            return arr[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        }
        else {
            return arr[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        r = sc.nextInt();
        arr = new int[n + 1][r + 1];
        System.out.println(T.combi(n, r));
    }
}
