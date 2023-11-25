package Section8_Use_DFS_BFS.The_Shortest_Passageway_Of_A_Maze;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Coordinates_1st {

    int x, y;

    public Coordinates_1st(int x, int y) {

        this.x = x;
        this.y = y;
    }
}

public class Main_1st {

    static int[][] maze, dis;
    static int answer = 0;
    int dx[] = {-1, 0, 1, 0};
    int dy[] = {0, 1, 0, -1};

    public void BFS(int x, int y) {

        Queue<Coordinates_1st> queue = new LinkedList<>();
        queue.offer(new Coordinates_1st(x, y));
        maze[x][y] = 1;

        while (!queue.isEmpty()) {

            Coordinates_1st co = queue.poll();

            if (co.x == 7 && co.y == 7) {
                answer = dis[co.x][co.y];
                break;
            }

            for (int i = 0; i < 4; i++) {

                int nx = co.x + dx[i];
                int ny = co.y + dy[i];

                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && maze[nx][ny] == 0) {
                    Coordinates_1st nc = new Coordinates_1st(nx, ny);
                    queue.offer(nc);
                    maze[nx][ny] = 1;
                    dis[nx][ny] = dis[co.x][co.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        maze = new int[8][8];
        dis = new int[8][8];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        T.BFS(1, 1);
        if (dis[7][7] == 0)
            System.out.println(-1);
        else
            System.out.println(dis[7][7]);
    }
}
