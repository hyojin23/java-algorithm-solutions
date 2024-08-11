package Section8_Use_DFS_BFS.The_Shortest_Passageway_Of_A_Maze;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

class Point_3rd {

    int x, y;

    public Point_3rd(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_3rd {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    static int[][] maze;

    public int BFS(int x, int y) {

        Queue<Point_3rd> q = new LinkedList<>();
        q.offer(new Point_3rd(x, y));
        maze[x][y] = 1;
        int L = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point_3rd p = q.poll();
                if (p != null) {
                    for (int j = 0; j < 4; j++) {
                        int nx = p.x + dx[j];
                        int ny = p.y + dy[j];

                        if (nx == 7 && ny == 7) {
                            return ++L;
                        }

                        if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && maze[nx][ny] == 0) {
                            maze[nx][ny] = 1;
                            q.offer(new Point_3rd(nx, ny));
                        }
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
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
