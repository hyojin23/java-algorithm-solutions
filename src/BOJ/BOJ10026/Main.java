package BOJ.BOJ10026;

import java.util.Scanner;

public class Main {

    static int N;
    static char[][] board;
    static boolean[][] visited, blindVisited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public void DFS(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && board[x][y] == board[nx][ny]) {
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }

    public void blindDFS(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !blindVisited[nx][ny] && readRB(board[x][y]) == readRB(board[nx][ny])) {
                blindVisited[nx][ny] = true;
                blindDFS(nx, ny);
            }
        }
    }

    public char readRB(char color) {
        if (color == 'R' || color == 'G') {
            return 'R';
        }
        else {
            return color;
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        board = new char[N][N];
        visited = new boolean[N][N];
        blindVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        int cnt = 0;
        int blindCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    cnt++;
                    T.DFS(i, j);
                }
                if (!blindVisited[i][j]) {
                    blindVisited[i][j] = true;
                    blindCnt++;
                    T.blindDFS(i, j);
                }
            }
        }
        System.out.println(cnt + " " + blindCnt);
    }
}
