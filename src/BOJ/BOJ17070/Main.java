package BOJ.BOJ17070;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Pipe {

    int x, y, t;    //0:가로, 1:세로, 2:대각선

    Pipe(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}


public class Main {

    public int BFS(int N, int[][] board) {

        if (board[N][N] == 1) {
            return 0;
        }

        int[] dx = {0, 1, 1};   //가로, 세로, 대각선 이동
        int[] dy = {1, 0, 1};   //가로, 세로, 대각선 이동
        Queue<Pipe> q = new LinkedList<>();
        q.offer(new Pipe(1, 2, 0));
        int cnt = 0;
        while (!q.isEmpty()) {
            Pipe cur = q.poll();
            for (int i = 0; i < 3; i++) {
                if (cur.t == 0 && i == 1) {
                    continue;
                }
                if (cur.t == 1 && i == 0) {
                    continue;
                }
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && board[nx][ny] != 1) {
                    if (i == 2 && (board[nx - 1][ny] == 1 || board[nx][ny - 1] == 1)) {
                        continue;
                    }
                    if (nx == N && ny == N) {
                        cnt++;
                        continue;
                    }
                    q.offer(new Pipe(nx, ny, i));
                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] board = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.BFS(N, board));
    }
}
