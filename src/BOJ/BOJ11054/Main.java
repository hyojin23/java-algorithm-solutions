package BOJ.BOJ11054;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public int solution(int N, int[] arr) {

        int[] dp = new int[N];
        int[] reverse = new int[N];
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                   max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }
        for (int i = N - 1; i >= 0; i--) {
            int max = 0;
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, reverse[j]);
                }
            }
            reverse[i] = max + 1;
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(dp[i] + reverse[i] - 1, answer);
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(N, arr));
    }
}
