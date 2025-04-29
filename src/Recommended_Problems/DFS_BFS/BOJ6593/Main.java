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
        q.offer(new Point(x, y, z));
        while (!q.isEmpty()) {
            Point p = q.poll();
            System.out.println("답 >> " + building[p.z][p.x][p.y]);
            if (building[p.z][p.x][p.y] == 'E') {
                return "Escaped in " + time[p.z][p.x][p.y] + " minute(s).";
            }
            System.out.println(p.x + " " + p.y + " " + p.z);
            for (int i = 0; i < 6; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nz = p.z + dz[i];
                System.out.println("ff >> " + nx + " " + ny + " " + nz);
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && nz >= 0 && nz < L && building[nz][nx][ny] != '#') {
                    System.out.println(building[nz][nx][ny]);
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

        L = sc.nextInt();
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        building = new char[L][R][C];
        time = new int[L][R][C];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                String str = sc.nextLine();
                for (int k = 0; k < C; k++) {
                    building[i][j][k] = str.charAt(k);
                }
            }
            sc.nextLine();
        }

//        for (int i = 0; i < L; i++) {
//            for (int j = 0; j < R; j++) {
//                for (int k = 0; k < C; k++) {
//                    System.out.print(building[i][j][k] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
        System.out.println(T.BFS(0, 0, 0));
    }
}
