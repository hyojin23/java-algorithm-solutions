package BOJ.BOJ16928;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public int BFS(int start, int[] ladder, int[] snake, int[] dis) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dis[start] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == 100) {
                return dis[cur];
            }
            for (int dice = 1; dice <= 6; dice++) {
                int np = cur + dice;
                if (np > 100) {
                    continue;
                }
                if (ladder[np] > 0) {
                    np = ladder[np];
                }
                if (snake[np] > 0) {
                    np = snake[np];
                }
                if (dis[np] == 0) {
                    q.offer(np);
                    dis[np] = dis[cur] + 1;
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dis = new int[101];
        int[] ladder = new int[101];
        int[] snake = new int[101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladder[x] = y;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            snake[u] = v;
        }
        System.out.println(T.BFS(1, ladder, snake, dis));
    }
}
