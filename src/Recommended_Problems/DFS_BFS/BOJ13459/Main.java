package Recommended_Problems.DFS_BFS.BOJ13459;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Turn {

    int rx, ry, bx, by;

    Turn(int rx, int ry, int bx, int by) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
    }
}

class Marble {

    int x, y, dis;

    Marble(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

public class Main {

    static char[][] board;
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][][] visited;

    private Marble move(int x, int y, int dis, int idx) {

        int xx = x;
        int yy = y;
        while (board[xx + dx[idx]][yy + dy[idx]] != '#' && board[xx][yy] != 'O') {
            xx += dx[idx];
            yy += dy[idx];
            dis++;
        }
        return new Marble(xx, yy, dis);
    }


    public int BFS(int rx, int ry, int bx, int by) {

        Queue<Turn> q = new LinkedList<>();
        visited[rx][ry][bx][by] = true;
        q.offer(new Turn(rx, ry, bx, by));
        int L = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Turn now = q.poll();
                for (int j = 0; j < 4; j++) {
                    Marble nRed = move(now.rx, now.ry, 0, j);
                    Marble nBlue = move(now.bx, now.by, 0, j);
                    if (board[nBlue.x][nBlue.y] == 'O') {
                        continue;
                    }
                    if (board[nRed.x][nRed.y] == 'O') {
                        return 1;
                    }
                    if (nRed.x == nBlue.x && nRed.y == nBlue.y) {
                        if (nRed.dis > nBlue.dis) {
                            nRed.x -= dx[j];
                            nRed.y -= dy[j];
                        }
                        else {
                            nBlue.x -= dx[j];
                            nBlue.y -= dy[j];
                        }
                    }
                    if (!visited[nRed.x][nRed.y][nBlue.x][nBlue.y]) {
                        visited[nRed.x][nRed.y][nBlue.x][nBlue.y] = true;
                        q.offer(new Turn(nRed.x, nRed.y, nBlue.x, nBlue.y));
                    }
                }
            }
            L++;
            if (L > 10) {
                return 0;
            }
        }
        return 0;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        board = new char[N][M];
        visited = new boolean[N][M][N][M];
        int rx = 0;
        int ry = 0;
        int bx = 0;
        int by = 0;
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
                if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }
        System.out.println(T.BFS(rx, ry, bx, by));
    }
}
