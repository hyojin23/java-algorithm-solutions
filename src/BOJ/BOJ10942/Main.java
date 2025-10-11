package BOJ.BOJ10942;

import java.util.Scanner;

public class Main {

    public boolean[][] makeDp(int N, int[] arr) {

        boolean[][] dp = new boolean[N + 1][N + 1];
        for (int i = N; i >= 1; i--) {
            for (int j = i; j <= N; j++) {
                if (i == j) {
                    dp[i][j] = true;
                }
                else if (j - i == 1) {
                    if (arr[i] == arr[j]) {
                        dp[i][j] = true;
                    }
                }
                else {
                    if (dp[i + 1][j - 1] && arr[i] == arr[j]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        boolean[][] isPalindrome = T.makeDp(N, arr);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            if (isPalindrome[S][E]) {
                answer.append(1).append('\n');
            }
            else {
                answer.append(0).append('\n');
            }
        }
        System.out.println(answer);
    }
}
