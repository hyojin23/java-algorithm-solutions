package BOJ.BOJ1697;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public static int solution(int N, int K) {

        boolean[] visited = new boolean[100_001];
        int[] time = new int[100_001];
        Queue<Integer> q = new LinkedList<>();
        visited[N] = true;
        q.offer(N);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) {
                return time[cur];
            }

            int[] next = {cur - 1, cur + 1, cur * 2};
            for (int nx : next) {
                if (nx >= 0 && nx <= 100_000 && !visited[nx]) {
                    time[nx] = time[cur] + 1;
                    visited[nx] = true;
                    q.offer(nx);
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(solution(N, K));
    }
}
