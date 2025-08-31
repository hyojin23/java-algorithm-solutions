package BOJ.BOJ2589;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Point {

    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, M;
    static char[][] board;
    static List<Point> landList;

    public int BFS(int x, int y) {

        boolean[][] visited = new boolean[N][M];
        int[][] time = new int[N][M];
        Queue<Point> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new Point(x, y));
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int max = 0;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && board[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    time[nx][ny] = time[cur.x][cur.y] + 1;
                    max = Math.max(max, time[nx][ny]);
                    q.offer(new Point(nx, ny));
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new char[N][M];

        landList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'L') {
                    landList.add(new Point(i, j));
                }
            }
        }
        int answer = 0;
        for (Point land : landList) {
            answer = Math.max(answer, T.BFS(land.x, land.y));
        }
        System.out.println(answer);
    }
}
