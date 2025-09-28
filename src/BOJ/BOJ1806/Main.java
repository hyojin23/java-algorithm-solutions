package BOJ.BOJ1806;

import java.util.Scanner;

public class Main {

    public int solution(int N, int S, int[] arr) {

        int lt = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int rt = 0; rt < N; rt++) {
            sum += arr[rt];
            while (sum >= S) {
                if (rt - lt + 1 < minLen) {
                    minLen = rt - lt + 1;
                }
                sum -= arr[lt];
                lt++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(N, S, arr));
    }
}
