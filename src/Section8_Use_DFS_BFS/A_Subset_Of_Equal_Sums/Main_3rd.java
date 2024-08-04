package Section8_Use_DFS_BFS.A_Subset_Of_Equal_Sums;

import java.util.Scanner;

public class Main_3rd {

    static int n;
    static int[] arr;
    static int totSum = 0;
    static String answer = "NO";
    public void DFS(int L, int sum) {

        if ("YES".equals(answer)) {
            return;
        }

        if (sum * 2 > totSum) {
            return;
        }

        if (L == n) {
            if (totSum == sum * 2) {
                answer = "YES";
            }
        }
        else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
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
