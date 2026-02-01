package BOJ.BOJ1941;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
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

    static char[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Point[] combi;
    static List<Point> list;
    static boolean isConnected;
    static boolean[][] visited;
    static int answer;

    public static int dfsCount(int x, int y, boolean[][] isSelected) {

        visited[x][y] = true;
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                continue;
            }
            if (isSelected[nx][ny] && !visited[nx][ny]) {
                count += dfsCount(nx, ny, isSelected);
            }
        }
        return count;
    }

    public static void combination(int s, int L) {

        if (L == 7) {
            int x = -1;
            int y = -1;
            int sCnt = 0;
            boolean[][] isSelected = new boolean[5][5];
            for (Point p : combi) {
                isSelected[p.x][p.y] = true;
                if (board[p.x][p.y] == 'S') {
                    sCnt++;
                }
                if (x == -1) {
                    x = p.x;
                }
                if (y == -1) {
                    y = p.y;
                }
            }
            if (sCnt < 4) {
                return;
            }
            isConnected = false;
            visited = new boolean[5][5];
            int connectedCount = dfsCount(x, y, isSelected);  //연결 되어있는지 확인

            if (connectedCount == 7) {
                answer++;
            }
        }
        else {
            for (int i = s; i < list.size(); i++) {
                combi[L] = list.get(i);
                combination(i + 1, L + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[5][5];
        list = new ArrayList<>();
        combi = new Point[7];

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = str.charAt(j);
                list.add(new Point(i, j));
            }
        }

        combination(0, 0);
        System.out.println(answer);
    }
}
