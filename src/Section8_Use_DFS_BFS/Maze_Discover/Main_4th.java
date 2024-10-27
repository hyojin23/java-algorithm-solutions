package Section8_Use_DFS_BFS.Maze_Discover;

import java.util.Scanner;

public class Main_4th {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    static int cnt = 0;
    static int[][] maze, ch;

    public void DFS(int x, int y) {

        if (x == 7 && y == 7) {
            cnt++;
        }
        else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && ch[nx][ny] == 0 && maze[x][y] == 0) {
                    ch[nx][ny] = 1;
                    DFS(nx, ny);
                    ch[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        maze = new int[8][8];
        ch = new int[8][8];

        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        ch[1][1] = 1;
        T.DFS(1, 1);
        System.out.println(cnt);
    }
}
