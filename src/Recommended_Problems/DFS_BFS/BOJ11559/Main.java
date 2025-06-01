package Recommended_Problems.DFS_BFS.BOJ11559;

import java.util.Scanner;
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
    static int groupCnt, combo;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean isGroup;
    static boolean[][] visited;
    static int cnt;
    static List<Point> list;

    public void DFS(int x, int y, int color) {
        if (cnt >= 4) {
            groupCnt++;
            isGroup = true;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && !visited[nx][ny] && board[nx][ny] == color) {
                visited[nx][ny] = true;
                cnt++;
                list.add(new Point(nx, ny));
                DFS(nx, ny, board[nx][ny]);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        board = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < 6; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        groupCnt = 1;
        boolean isMove = true;
        while (groupCnt > 0 || isMove) {
            groupCnt = 0;
            isMove = false;

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (board[i][j] != '.') {
                        visited = new boolean[12][6];
                        isGroup = false;
                        visited[i][j] = true;
                        cnt = 1;
                        list = new ArrayList<>();
                        list.add(new Point(i, j));
                        T.DFS(i, j, board[i][j]);
                        if (list.size() >= 4) {
                            for (Point p : list) {
                                board[p.x][p.y] = '.';
                            }
                        }
                    }
                }
            }

            // 중력
            for (int i = 10; i >= 0; i--) {
                for (int j = 0; j < 6; j++) {
                    int pos = 11;
                    if (board[i][j] != '.') {
                        for (int k = i + 1; k <= 11; k++) {
                            if (board[k][j] != '.') {
                                pos = k - 1;
                                break;
                            }
                        }
                        if (i != pos) {
                            board[pos][j] = board[i][j];
                            board[i][j] = '.';
                            isMove = true;
                        }
                    }
                }
            }
            if (groupCnt > 0) {
                combo++;
            }
        }
        System.out.println(combo);
    }
}
