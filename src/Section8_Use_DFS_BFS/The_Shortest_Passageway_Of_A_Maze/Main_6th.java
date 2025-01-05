package Section8_Use_DFS_BFS.The_Shortest_Passageway_Of_A_Maze;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Point_6th {

    int x, y;

    Point_6th(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_6th {

    static int[][] maze, dis;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public void BFS(int x, int y) {

        Queue<Point_6th> q = new LinkedList<>();
        maze[x][y] = 1;
        q.offer(new Point_6th(x, y));
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point_6th p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && maze[nx][ny] == 0) {
                        maze[nx][ny]= 1;
                        q.offer(new Point_6th(nx, ny));
                        dis[nx][ny] = dis[p.x][p.y] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);
        maze = new int[8][8];
        dis = new int[8][8];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        T.BFS(1, 1);

        if (dis[7][7] > 0) {
            System.out.println(dis[7][7]);
        }
        else {
            System.out.println(-1);
        }
    }
}
