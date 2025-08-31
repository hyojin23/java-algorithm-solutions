package BOJ.BOJ14499;

import java.util.Scanner;

public class Main {

    static int N, M;
    static int[][] board;
    static int[] command;

/*
   주사위 구조 (배열 내 위치)
       [0][1]  // 윗면 (up)
[1][0] [1][1] [1][2]  // 왼쪽, 바닥, 오른쪽 (left, bottom, right)
       [2][1]  // 아랫면 (down)
       [3][1]  // 상단 (top)
*/

    public String solution(int x, int y) {

        int[] dx = {0, 0, 0, -1, 1};
        int[] dy = {0, 1, -1, 0, 0};
        int[][] dice = new int[4][3];
        StringBuilder sb = new StringBuilder();
        for (int c : command) {
            int nx = x + dx[c];
            int ny = y + dy[c];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (c == 1) {
                    int left = dice[1][0];
                    dice[1][0] = dice[1][1];
                    dice[1][1] = dice[1][2];
                    dice[1][2] = dice[3][1];
                    dice[3][1] = left;
                }
                else if (c == 2) {
                    int right = dice[1][2];
                    dice[1][2] = dice[1][1];
                    dice[1][1] = dice[1][0];
                    dice[1][0] = dice[3][1];
                    dice[3][1] = right;
                }
                else if (c == 3) {
                    int top = dice[3][1];
                    dice[3][1] = dice[2][1];
                    dice[2][1] = dice[1][1];
                    dice[1][1] = dice[0][1];
                    dice[0][1] = top;
                }
                else if (c == 4) {
                    int up = dice[0][1];
                    dice[0][1] = dice[1][1];
                    dice[1][1] = dice[2][1];
                    dice[2][1] = dice[3][1];
                    dice[3][1] = up;
                }
                if (board[nx][ny] == 0) {
                    board[nx][ny] = dice[1][1];
                }
                else {
                    dice[1][1] = board[nx][ny];
                    board[nx][ny] = 0;
                }
                x = nx;
                y = ny;
                sb.append(dice[3][1]).append('\n');
            }
        }
        return sb.toString();
    }



    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int K = sc.nextInt();
        board = new int[N][M];
        command = new int[K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < K; i++) {
            command[i] = sc.nextInt();
        }
        System.out.println(T.solution(x, y));
    }
}
