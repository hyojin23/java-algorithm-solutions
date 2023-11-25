package Section8_Use_DFS_BFS.The_Shortest_Passageway_Of_A_Maze;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Coordinates {

    int x, y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[][] maze;
    static int[][] ch;
    static int[][] dis;

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int BFS(Coordinates co) {

        Queue<Coordinates> q = new LinkedList<>();
        q.offer(co);

        dis[7][7] = -1;

        while (!q.isEmpty()) {

            int len = q.size();

            for (int i = 0; i < len; i++) {
                Coordinates cur = q.poll();

                for (int j = 0; j < 4; j++) {

                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && ch[nx][ny] == 0 && maze[nx][ny] == 0)  {
                        ch[nx][ny] = 1;
                        dis[nx][ny] = dis[cur.x][cur.y] + 1;
                        q.offer(new Coordinates(nx, ny));
                    }
                }
            }
        }
        return dis[7][7];
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        maze = new int[8][8];
        ch = new int[8][8];
        dis = new int[8][8];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        ch[1][1] = 1;
        System.out.println(T.BFS(new Coordinates(1, 1)));
    }
}
