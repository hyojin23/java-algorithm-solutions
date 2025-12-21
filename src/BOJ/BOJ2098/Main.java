package BOJ.BOJ2098;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    static int[][] cost, dp;
    static int N, INF = 1_000_000_000;

    public static int tsp(int cur, int visited) {

        //모든 도시를 방문한 경우
        if (visited == (1 << N) - 1) {
            if (cost[cur][0] != 0) {
                return cost[cur][0];
            }
            return INF;
        }

        //이미 계산한 적 있으면 그대로 반환
        if (dp[cur][visited] != -1) {
            return dp[cur][visited];
        }

        dp[cur][visited] = INF;

        //다음에 방문할 도시 선택
        for (int next = 0; next < N; next++) {

            //이미 방문한 도시는 제외
            if ((visited & (1 << next)) != 0) {
                continue;
            }
            //길이 없는 경우 제외
            if (cost[cur][next] == 0) {
                continue;
            }
            //next 도시 방문 처리
            int nextVisited = visited | (1 << next);

            //최소 비용 갱신
            dp[cur][visited] = Math.min(dp[cur][visited], cost[cur][next] + tsp(next, nextVisited));
        }
        return dp[cur][visited];
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        dp = new int[N][1 << N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(tsp(0, 1));
    }
}
