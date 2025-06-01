package Recommended_Problems.DFS_BFS.BOJ16234;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Point {

    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, L, R;
    static int[][] board;
    static boolean[][] visited;
    static boolean isBorderOpen;
    static List<Point> list;

    public int BFS(int x, int y) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Point> q = new LinkedList<>();
        int sum = 0;
        sum += board[x][y];
        visited[x][y] = true;
        list.add(new Point(x, y));
        q.offer(new Point(x, y));
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    int s = Math.abs(board[cur.x][cur.y] - board[nx][ny]);
                    if (s >= L && s <= R) {
                        visited[nx][ny] = true;
                        isBorderOpen = true;
                        list.add(new Point(nx, ny));
                        sum += board[nx][ny];
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
        return sum;
    }

    public int solution() {

        int answer = 0;
        while (true) {
            isBorderOpen = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    list = new ArrayList<>();
                    if (!visited[i][j]) {
                        int sum = BFS(i, j);
                        int avg = sum / (list.size() == 0 ? 1: list.size());
                        for (Point p : list) {
                            board[p.x][p.y] = avg;
                        }
                    }
                }
            }
            if (!isBorderOpen) {
                break;
            }
            answer++;
        }
        return answer;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution());
    }
}
