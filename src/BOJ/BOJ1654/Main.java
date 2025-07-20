package BOJ.BOJ1654;

import java.util.Scanner;

public class Main {

    static int[] cableLen;
    public boolean canMakeCable(int targetCnt, long targetLen) {
        if (targetLen == 0) {
            return false;
        }

        long sum = 0;
        for (int len : cableLen) {
            sum += len / targetLen;
        }
        return sum >= targetCnt;
    }

    public long solution(int K, int N, int max) {

        long lt = 1;
        long rt = max;
        long answer = 0;
        while (lt <= rt) {
            long mid = lt + (rt - lt) / 2;
            if (canMakeCable(N, mid)) {
                answer = mid;
                lt = mid + 1;
            }
            else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();
        cableLen = new int[K];
        int max = 0;
        for (int i = 0; i < K; i++) {
            int len = sc.nextInt();
            if (len > max) {
                max = len;
            }
            cableLen[i] = len;
        }
        System.out.println(T.solution(K, N, max));
    }
}
