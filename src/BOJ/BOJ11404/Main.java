package BOJ.BOJ11404;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static int n, m;
    static final int INF = 100_000_000;

    public String floyd(int[][] dist) {

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) {
                    sb.append("0 ");
                }
                else {
                    sb.append(dist[i][j]).append(" ");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            dist[from][to] = Math.min(dist[from][to], cost);
        }
        System.out.println(T.floyd(dist));
    }
}
