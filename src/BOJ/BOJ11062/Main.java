package BOJ.BOJ11062;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static int solution(int N, int total, int[] cards) {

        int[][] dp = new int[N][N];

        for (int k = 0; k < N; k++) {       //구간 길이
            for (int i = 0; i + k < N; i++) {
                int l = i;
                int r = i + k;

                if (k == 0) {
                    dp[l][r] = cards[l];
                }
                else {
                    int a = cards[l] - dp[l + 1][r];
                    int b = cards[r] - dp[l][r - 1];
                    dp[l][r] = Math.max(a, b);
                }
            }
        }

        return (total + dp[0][N - 1]) / 2;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] cards = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int total = 0;
            for (int i = 0; i < N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
                total += cards[i];
            }
            System.out.println(solution(N, total, cards));
        }
    }
}
