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

    static int n, m;
    static int[][] board, dis;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int BFS(Queue<Tomato> q) {

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Tomato t = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = t.x + dx[j];
                    int ny = t.y + dy[j];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        q.offer(new Tomato(nx, ny));
                        dis[nx][ny] = dis[t.x][t.y] + 1;
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[m][n];
        dis = new int[m][n];
        Queue<Tomato> q = new LinkedList<>();

        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int status = sc.nextInt();
                if (status == 1) {
                    q.offer(new Tomato(i, j));
                }
                sum += status;
                board[i][j] = status;
            }
        }

        T.BFS(q);

        if (sum == n * m) {
            System.out.println(0);
        }
        else {
            int answer = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    else {
                        answer = Math.max(answer, dis[i][j]);
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
