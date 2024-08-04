package Section8_Use_DFS_BFS.A_Subset_Of_Equal_Sums;

import java.util.Scanner;
public class Main {

    static int totSum;
    static int n;
    static int[] arr;
    static String answer = "NO";

    public void DFS(int L, int sum) {

        if (L == n) {
            if (totSum % 2 == 0 && sum == totSum / 2) {
                answer = "YES";
            }
        }
        else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            totSum += arr[i];
        }

        T.DFS(0, 0);
        System.out.println(answer);
    }
}
