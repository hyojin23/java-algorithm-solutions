package Section8_Use_DFS_BFS.A_Subset_Of_Equal_Sums;

import java.util.Scanner;

public class Main {

    static int n, total;
    static int[] arr;
    static String answer = "NO";
    boolean isAnswer = false;

    public void DFS(int sum, int L) {

        if (isAnswer) {
            return;
        }

        if (sum > total / 2) {
            return;
        }

        if (L == n) {
            if (total - sum == sum) {
                answer = "YES";
                isAnswer = true;
            }
        }
        else {
            DFS(sum + arr[L], L + 1);
            DFS(sum, L + 1);
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        for (int i= 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
