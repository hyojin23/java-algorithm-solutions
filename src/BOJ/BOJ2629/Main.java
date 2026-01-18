package BOJ.BOJ2629;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static String solution(int N, int[] weights, int[] marbles, int max) {

        boolean[][] dp = new boolean[N + 1][max + 1];
        dp[0][0] = true;
        for (int i = 0; i < N; i++) {
            int w = weights[i];

            for (int diff = 0; diff <= max; diff++) {
                if (!dp[i][diff]) continue;
                dp[i + 1][diff] = true;                 //추 사용 안해서 무게차이 그대로
                if (diff + w <= max) {
                    dp[i + 1][diff + w] = true;         //추 왼쪽(무게가 높은 쪽)에 추가해서 무게차이 증가
                }
                dp[i + 1][Math.abs(diff - w)] = true;   //추 오른쪽에 추가해서 무게차이 감소
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int m : marbles) {
            if (m <= max && dp[N][m]) {
                sb.append("Y ");
            }
            else {
                sb.append("N ");
            }
        }
        return sb.toString().trim();
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] weights = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;

        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            max += weights[i];
        }

        int M = Integer.parseInt(br.readLine());
        int[] marbles = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            marbles[i] = Integer.parseInt(st.nextToken());

        }

        System.out.println(solution(N, weights, marbles, max));
    }
}
