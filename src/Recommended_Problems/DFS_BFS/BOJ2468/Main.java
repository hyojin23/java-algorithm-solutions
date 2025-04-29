package Recommended_Problems.DFS_BFS.BOJ2468;

import java.util.Scanner;

public class Main {

    static int N;
    static int[][] land, ch;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public void DFS(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && ch[nx][ny] == 0) {
                ch[nx][ny] = 1;
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        land = new int[N][N];
        int max = Integer.MIN_VALUE;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                land[i][j] = sc.nextInt();
                if (land[i][j] > max) {
                    max = land[i][j];
                }
            }
        }

        for (int i = 0; i <= max; i++) {
            int water = i;
            ch = new int[N][N];
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (land[j][k] <= water) {
                        ch[j][k] = 1;
                    }
                }
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (ch[j][k] == 0) {
                        cnt++;
                        T.DFS(j, k);
                    }
                }
            }
            answer = Math.max(cnt, answer);
        }
        System.out.println(answer);
    }
}
