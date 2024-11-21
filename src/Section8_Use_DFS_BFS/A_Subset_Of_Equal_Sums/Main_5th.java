package Section8_Use_DFS_BFS.A_Subset_Of_Equal_Sums;

import java.util.Scanner;

public class Main_5th {

    static String answer = "NO";
    static int n, total;
    static int[] arr;

    public void DFS(int L, int sum) {

        if (sum > total / 2) {
            return;
        }

        if ("YES".equals(answer)) {
            return;
        }

        if (L == n) {
            if (sum == total - sum) {
                answer = "YES";
            }
        }
        else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        total = 0;
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        T.DFS(0, 0);
        System.out.println(answer);
    }
}
