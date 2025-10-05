package BOJ.BOJ10986;

import java.util.Scanner;

public class Main {

    public long solution(int N, int M, int[] arr) {

        long[] preSum = new long[N];
        long[] modCnt = new long[M];
        preSum[0] = arr[0];

        for (int i = 1; i < N; i++) {
            preSum[i] = (arr[i] + preSum[i - 1]);
        }
        for (long x : preSum) {
            int preSumMod = (int) (x % M);
            modCnt[preSumMod]++;
        }
        long answer = modCnt[0];
        for (long x : modCnt) {
            if (x >= 2) {
                answer += x * (x - 1) / 2;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(N, M, arr));
    }
}
