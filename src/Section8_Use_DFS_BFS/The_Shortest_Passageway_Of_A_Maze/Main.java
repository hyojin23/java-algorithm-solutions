package Section8_Use_DFS_BFS.The_Shortest_Passageway_Of_A_Maze;

import java.util.Scanner;
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

    static int[][] maze;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        maze[x][y] = 1;
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point cur = q.poll();
                if (cur.x == 7 && cur.y == 7) {
                    return L;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && maze[nx][ny] == 0) {
                        maze[nx][ny] = 1;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
            L++;
        }
        return -1;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        maze = new int[8][8];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.BFS(1, 1));
    }
}
