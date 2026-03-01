package BOJ.BOJ1027;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static int solution(int N, int[] h) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            long maxDy = Long.MIN_VALUE;
            long maxDx = 1;
            int visibleCnt = 0;
            for (int j = i + 1; j < N; j++) {
                long dy1 = h[j] - h[i];
                long dx1 = j - i;

                if (maxDy == Long.MIN_VALUE || maxDy * dx1 < maxDx * dy1) {
                    visibleCnt++;
                    maxDx = dx1;
                    maxDy = dy1;
                }
            }

            maxDy = Long.MIN_VALUE;
            maxDx = 1;
            for (int j = i - 1; j >= 0; j--) {
                long dy1 = h[j] - h[i];
                long dx1 = j - i;

                if (maxDy == Long.MIN_VALUE || maxDy * dx1 > maxDx * dy1) {
                    visibleCnt++;
                    maxDx = dx1;
                    maxDy = dy1;
                }
            }
            max = Math.max(max, visibleCnt);
        }
        return max;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] h = new int[N];
        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, h));
    }
}
