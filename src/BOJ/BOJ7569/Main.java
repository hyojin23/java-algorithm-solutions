package BOJ.BOJ7569;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Tomato {

    int x, y, z;

    Tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {

    static int M, N, H;
    static int[][][] tomato, time;
    static int ripeCnt, unripeCnt, max = 0;

    public int BFS(Queue<Tomato> q) {

        int[] dx = {-1, 0, 1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        while(!q.isEmpty()) {
            Tomato cur = q.poll();
            for (int i = 0; i < 6; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H && tomato[nx][ny][nz] == 0) {
                    tomato[nx][ny][nz] = 1;
                    ripeCnt++;
                    time[nx][ny][nz] = time[cur.x][cur.y][cur.z] + 1;
                    max = Math.max(max, time[nx][ny][nz]);
                    q.offer(new Tomato(nx, ny, nz));
                }
            }
        }
        if (unripeCnt > ripeCnt) {
            return -1;
        }
        else {
            return max;
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        tomato = new int[N][M][H];
        time = new int[N][M][H];
        Queue<Tomato> q = new LinkedList<>();
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    tomato[i][j][k] = sc.nextInt();
                    if (tomato[i][j][k] == 1) {
                        q.offer(new Tomato(i, j, k));
                    }
                    if (tomato[i][j][k] == 0) {
                        unripeCnt++;
                    }
                }
            }
        }
        System.out.println(T.BFS(q));
    }
}
