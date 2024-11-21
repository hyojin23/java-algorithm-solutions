package Section8_Use_DFS_BFS.The_Shortest_Passageway_Of_A_Maze;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Point_5th {

    int x, y;

    Point_5th(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_5th {

    static int[][] maze;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0,-1};

    public int BFS(int x, int y) {
        Queue<Point_5th> q = new LinkedList<>();
        maze[x][y] = 1;
        q.offer(new Point_5th(x, y));
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point_5th p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && maze[nx][ny] == 0) {
                        if (nx == 7 && ny == 7) {
                            return L + 1;
                        }
                        maze[nx][ny] = 1;
                        q.offer(new Point_5th(nx, ny));
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {

        Main_5th T = new Main_5th();
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
