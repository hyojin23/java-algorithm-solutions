package BOJ.BOJ16954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Point {

    int x, y, t;

    Point(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}

public class Main {

    static char[][] board;
    static List<Point> walls;

    public static int movePerson(int x, int y, int t) {

        boolean[][][] visited = new boolean[8][8][9];
        Queue<Point> q = new LinkedList<>();
        visited[x][y][t] = true;
        q.offer(new Point(x, y, t));

        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x - cur.t >= 0 && board[cur.x - cur.t][cur.y] == '#') { //벽에 깔렸는지
                continue;
            }
            if (cur.x == 0 && cur.y == 7) {
                return 1;
            }
            if (cur.t >= 8) {
                return 1;
            }
            for (int i = 0; i < 9; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nt = cur.t + 1;
                if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) {
                    continue;
                }
                if (nx - cur.t >= 0 && board[nx - cur.t][ny] == '#') {  //이동하려는 위치에 벽이 있는지
                    continue;
                }
                if (!visited[nx][ny][nt]) {
                    visited[nx][ny][nt] = true;
                    q.offer(new Point(nx, ny, cur.t + 1));
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[8][8];

        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        System.out.println(movePerson(7, 0, 0));
    }
}
