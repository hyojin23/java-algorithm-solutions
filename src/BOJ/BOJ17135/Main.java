package BOJ.BOJ17135;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

class Point {

    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Main {

    static int N, M, D, cnt, max = Integer.MIN_VALUE;
    static int[][] board, initBoard;
    static int[] archerPos;
    static int[] dx = {0, -1, 0};
    static int[] dy = {-1, 0, 1};

    public Point findEnemy(int x, int y) {

        boolean[][] visited = new boolean[N + 1][M];
        Queue<Point> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new Point(x, y));
        int L = 1;

        while (!q.isEmpty()) {
            int len = q.size();
            if (L > D) {
                return null;
            }
            for (int t = 0; t < len; t++) {
                Point cur = q.poll();
                for (int i = 0; i < 3; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                        if (board[nx][ny] == 1) {
                            return new Point(nx, ny);
                        }
                        else {
                            visited[nx][ny] = true;
                            q.offer(new Point(nx, ny));
                        }
                    }
                }
            }
            L++;
        }
        return null;
    }

    public void placeArchers(int s, int L) {

        if (L == 3) {
            initBoard();
            cnt = 0;
            while (hasEnemy()) {
                List<Point> list = new ArrayList<>();
                for (int pos : archerPos) {
                    Point enemy = findEnemy(N, pos);
                    if (enemy != null && !list.contains(enemy)) {
                        list.add(enemy);
                    }
                }
                for (Point e : list) {
                    cnt++;
                    board[e.x][e.y] = 0;
                }
                moveEnemy();
            }
            max = Math.max(cnt, max);
        }
        else {
            for (int i = s; i < M; i++) {
                archerPos[L] = i;
                placeArchers(i + 1, L + 1);
            }
        }
    }

    public void moveEnemy() {
        for (int i = N - 2; i >= 0; i--) {
            board[i + 1] = Arrays.copyOf(board[i], board[i].length);
        }
        Arrays.fill(board[0], 0);
    }

    public boolean hasEnemy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public void initBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = Arrays.copyOf(initBoard[i], initBoard[i].length);
        }
    }

    public static void main(String[] args) {

        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();
        board = new int[N + 1][M];
        initBoard = new int[N + 1][M];
        archerPos = new int[3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
                initBoard[i][j] = board[i][j];
            }
        }

        main.placeArchers(0, 0);
        System.out.println(max);
    }
}
