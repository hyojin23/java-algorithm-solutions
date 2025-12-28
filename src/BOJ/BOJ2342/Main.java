package BOJ.BOJ2342;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public int solution(List<Integer> list) {

        int N = list.size();
        int INF = 1_000_000_000;
        int[][][] dp = new int[N + 1][5][5];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }
        dp[0][0][0] = 0;

        for (int i = 0; i < N; i++) {
            int next = list.get(i);
            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    if (dp[i][l][r] == INF) {
                        continue;
                    }
                    dp[i + 1][next][r] = Math.min(dp[i + 1][next][r], dp[i][l][r] + cost(l, next));
                    dp[i + 1][l][next] = Math.min(dp[i + 1][l][next], dp[i][l][r] + cost(r, next));
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                answer = Math.min(answer, dp[N][i][j]);
            }
        }

        return answer;
    }

    public int cost(int cur, int next) {

        if (cur == next) {
            return 1;
        }
        else if (cur == 0) {
            return 2;
        }
        else if (Math.abs(cur - next) == 2) {
            return 4;
        }
        else {
            return 3;
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (true) {
            int input = Integer.parseInt(st.nextToken());
            if (input == 0) {
                break;
            }
            list.add(input);
        }
        System.out.println(main.solution(list));
    }
}
