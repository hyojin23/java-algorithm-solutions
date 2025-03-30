package Section8_Use_DFS_BFS.A_Subset_Of_Equal_Sums;

import java.util.Scanner;

public class Main_7th {

    static int n, total;
    static int[] arr;
    static String answer = "NO";
    static boolean findAnswer = false;

    public void DFS(int sum, int L) {

        if (findAnswer) {
            return;
        }

        if (sum > total / 2) {
            return;
        }

        if (L == n) {
            if (total - sum == sum) {
                answer = "YES";
                findAnswer = true;
            }
        }
        else {
            DFS(sum + arr[L], L + 1);
            DFS(sum, L + 1);
        }
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
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
