package BOJ.BOJ2096;

import java.util.Scanner;

public class Main {

    public void solution(int N, int[][] board) {

        int[][] maxDp = new int[N][3];
        int[][] minDp = new int[N][3];

        for (int i = 0; i < 3; i++) {
            maxDp[0][i] = board[0][i];
            minDp[0][i] = board[0][i];
        }
        for (int i = 1; i < N; i++) {
            int max = maxDp[i - 1][0];
            for (int j = 0; j < 3; j++) {
                if (j == 2) {
                    maxDp[i][j] = board[i][j] + Math.max(maxDp[i - 1][j], maxDp[i - 1][j - 1]);
                }
                else {
                    max = Math.max(max, maxDp[i - 1][j + 1]);
                    maxDp[i][j] = max + board[i][j];
                }
            }
        }
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            maxScore = Math.max(maxScore, maxDp[N - 1][i]);
        }
        for (int i = 1; i < N; i++) {
            int min = minDp[i - 1][0];
            for (int j = 0; j < 3; j++) {
                if (j == 2) {
                    minDp[i][j] = board[i][j] + Math.min(minDp[i - 1][j], minDp[i - 1][j - 1]);
                }
                else {
                    min = Math.min(min, minDp[i - 1][j + 1]);
                    minDp[i][j] = min + board[i][j];
                }
            }
        }
        int minScore = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            minScore = Math.min(minScore, minDp[N - 1][i]);
        }
        System.out.println(maxScore + " " + minScore);
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] board = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        T.solution(N, board);
    }
}
