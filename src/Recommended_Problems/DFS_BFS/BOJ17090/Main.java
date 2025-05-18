package Recommended_Problems.DFS_BFS.BOJ17090;

import java.util.Scanner;

public class Main {

    static int N, M;
    static char[][] board;
    static int[][] memo; // 0: 미방문, 1: 방문중, 2: 탈출 가능, 3: 탈출 불가

    public int canEscape(int x, int y) {

        if (memo[x][y] == 1) {
            return 3;
        }

        if (memo[x][y] != 0) {
            return memo[x][y];
        }

        memo[x][y] = 1;

        int nx = x;
        int ny = y;
        if (board[x][y] == 'U') {
            nx = x - 1;
        }
        else if (board[x][y] == 'R') {
            ny = y + 1;
        }
        else if (board[x][y] == 'D') {
            nx = x + 1;
        }
        else if (board[x][y] == 'L') {
            ny = y - 1;
        }

        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
            return memo[x][y] = 2;
        }
        else {
            return memo[x][y] = canEscape(nx, ny);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        board = new char[N][M];
        memo = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (T.canEscape(i, j) == 2) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
