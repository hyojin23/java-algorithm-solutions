package BOJ.BOJ2166;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public double solution(int N, long[][] arr) {

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i][0] * arr[i + 1][1] - arr[i][1] * arr[i + 1][0];
        }
        return Math.abs(sum) / 2.0;
    }


    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N + 1][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }
        arr[N] = arr[0];
        System.out.printf("%.1f\n", T.solution(N, arr));
    }
}
