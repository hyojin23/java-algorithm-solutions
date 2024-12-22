package Section8_Use_DFS_BFS.A_Subset_Of_Equal_Sums;

import java.util.Scanner;

public class Main_6th {

    static int n, total;
    static int[] arr;
    static String answer = "NO";
    boolean flag = false;

    public void DFS(int L, int sum) {

        if (flag) return;

        if (sum > total / 2) {
            return;
        }

        if (L == n) {
            if (total - sum == sum) {
                answer = "YES";
                flag = true;
            }
        }
        else {

            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        T.DFS(0, 0);
        System.out.println(answer);
    }
}
