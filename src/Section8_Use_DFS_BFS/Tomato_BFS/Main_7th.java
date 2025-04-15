package Section8_Use_DFS_BFS.Tomato_BFS;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Tomato_7th {
    int x, y;

    Tomato_7th(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_7th {

    static int n, m;
    static int[][] board, dis;

    public void BFS(Queue<Tomato_7th> q) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Tomato_7th cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        dis[nx][ny] = dis[cur.x][cur.y] + 1;
                        q.offer(new Tomato_7th(nx, ny));
                    }
                }
            }
        }
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[n][m];
        dis = new int[n][m];
        Queue<Tomato_7th> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                   q.offer(new Tomato_7th(i, j));
                }
            }
        }
        T.BFS(q);

        boolean isNotRippen = false;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    isNotRippen = true;
                    break;
                }
                answer = Math.max(answer, dis[i][j]);
            }
        }
        if (isNotRippen) {
            System.out.println(-1);
        }
        else {
            System.out.println(answer);
        }
    }
}
