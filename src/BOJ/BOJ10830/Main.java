package BOJ.BOJ10830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long B;

    public void solution(int[][] A, long B) {

        int[][] result = power(A, B);

        StringBuilder sb = new StringBuilder();
        for (int[] row : result) {
            for (int value : row) {
                sb.append(value).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public int[][] power(int[][] base, long exp) {

        if (exp == 1) {
            int[][] copy = new int[N][N];
            for (int i = 0; i < N; i++) {
                System.arraycopy(base[i], 0, copy[i], 0, N);
            }
            return copy;
        }

        int[][] half = power(base, exp / 2);
        int[][] resultArr = multiply(half, half);

        if (exp % 2 == 1) {
            return multiply(resultArr, base);
        }
        return resultArr;
    }

    public int[][] multiply(int[][] X, int[][] Y) {

        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                long sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += (long) X[i][k] * Y[k][j];
                }
                result[i][j] = (int)(sum % 1000);
            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
        T.solution(A, B);
    }
}
