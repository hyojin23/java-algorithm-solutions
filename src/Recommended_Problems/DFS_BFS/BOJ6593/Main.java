package Recommended_Problems.DFS_BFS.BOJ6593;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Point {

    int x, y, z;

    Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {

    static int L, R, C;
    static char[][][] building;
    static int[][][] time;

    public String BFS(int x, int y, int z) {

        int[] dx = {-1, 0, 1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        Queue<Point> q = new LinkedList<>();
        building[z][x][y] = '#';
        q.offer(new Point(x, y, z));
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (building[p.z][p.x][p.y] == 'E') {
                return "Escaped in " + time[p.z][p.x][p.y] + " minute(s).";
            }
            for (int i = 0; i < 6; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nz = p.z + dz[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && nz >= 0 && nz < L && building[nz][nx][ny] != '#') {
                    if (building[nz][nx][ny] == '.') {
                        building[nz][nx][ny] = '#';
                    }
                    time[nz][nx][ny] = time[p.z][p.x][p.y] + 1;
                    q.offer(new Point(nx, ny, nz));
                }
            }
        }
        return "Trapped!";
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        while (true) {
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();
            sc.nextLine();
            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            building = new char[L][R][C];
            time = new int[L][R][C];
            int startX = 0;
            int startY = 0;
            int startZ = 0;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = sc.nextLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = str.charAt(k);
                        if (building[i][j][k] == 'S') {
                            startZ = i;
                            startX = j;
                            startY = k;
                        }
                    }
                }
                sc.nextLine();
            }
            System.out.println(T.BFS(startX, startY, startZ));
        }
    }
}
