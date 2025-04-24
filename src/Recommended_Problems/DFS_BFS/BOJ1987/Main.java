package Recommended_Problems.DFS_BFS.BOJ1987;

import java.util.Scanner;

public class Main {

    static char[][] board;
    static int[] ch;
    static int R, C, answer = 0;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public void DFS(int x, int y, int cnt) {
        answer = Math.max(answer, cnt);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && ch[board[nx][ny] - 65] == 0) {
                ch[board[nx][ny] - 65] = 1;
                DFS(nx, ny, cnt + 1);
                ch[board[nx][ny] - 65] = 0;
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        board = new char[R][C];
        ch = new int[26];
        for (int i = 0; i < R; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        ch[board[0][0] - 65] = 1;
        int cnt = 1;
        T.DFS(0, 0, cnt);
        System.out.println(answer);
    }
}
