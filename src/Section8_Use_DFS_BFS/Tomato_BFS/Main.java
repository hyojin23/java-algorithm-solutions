package Section8_Use_DFS_BFS.Tomato_BFS;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Tomato {

    int x, y;

    Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[][] board, dis;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    static int n, m;

    public void BFS(Queue<Tomato> q) {

        while (!q.isEmpty()) {

            int len = q.size();

            for (int i = 0; i < len; i++) {
                Tomato t = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = t.x + dx[j];
                    int ny = t.y + dy[j];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        q.offer(new Tomato(nx, ny));
                        dis[nx][ny] = dis[t.x][t.y] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        Queue<Tomato> q = new LinkedList<>();

        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[n][m];
        dis = new int[n][m];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int a = sc.nextInt();
                board[i][j] = a;

                if (a == 1) {
                    q.offer(new Tomato(i, j));
                    cnt++;
                }
            }
        }

        T.BFS(q);

        int answer = Integer.MIN_VALUE;
        if (cnt == n * m) {
            answer = 0;
        }
        else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(dis[i][j], answer);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j =0 ; j < m; j++) {
                    if (board[i][j] == 0) {
                        answer = -1;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
