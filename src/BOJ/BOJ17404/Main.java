package BOJ.BOJ17404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static final int R = 0;
    static final int G = 1;
    static final int B = 2;
    static final int INF = 1_000_000_000;

    public int solution(int N, int[][] arr) {

        int[][] dp = new int[N][3];
        int answer = Integer.MAX_VALUE;

        for (int select = 0; select < 3; select++) {    //첫 행을 R, G, B로 선택한 뒤 dp 배열을 채움
            Arrays.fill(dp[0], INF);
            dp[0][select] = arr[0][select];
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    if (j == R) {
                        dp[i][j] = arr[i][j] + Math.min(dp[i - 1][G], dp[i - 1][B]);
                    }
                    else if (j == G) {
                        dp[i][j] = arr[i][j] + Math.min(dp[i - 1][R], dp[i - 1][B]);
                    }
                    else {
                        dp[i][j] = arr[i][j] + Math.min(dp[i - 1][R], dp[i - 1][G]);
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                if (i != select) {
                    answer = Math.min(answer, dp[N - 1][i]);
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(main.solution(N, arr));
    }
}
