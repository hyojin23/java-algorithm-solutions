package BOJ.BOJ7453;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    public long solution(int[] AB, int[] CD) {

        Arrays.sort(AB);
        Arrays.sort(CD);

        long answer = 0;
        for (int ab : AB) {
            int target = -ab;
            int lower = lowerBound(CD, target);
            int upper = upperBound(CD, target);
            answer += (upper - lower);
        }
        return answer;
    }

    public int lowerBound(int[] arr, int target) {

        int lt = 0;
        int rt = arr.length;
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] >= target) {
                rt = mid;
            }
            else {
                lt = mid + 1;
            }
        }
        return lt;
    }

    public int upperBound(int[] arr, int target) {

        int lt = 0;
        int rt = arr.length;
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] > target) {
                rt = mid;
            }
            else {
                lt = mid + 1;
            }
        }
        return lt;
    }

    public static void main(String[] args) throws IOException{

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];
        int[] AB = new int[N * N];
        int[] CD = new int[N * N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[i * N + j] = A[i] + B[j];
                CD[i * N + j] = C[i] + D[j];
            }
        }
        System.out.println(main.solution(AB, CD));
    }
}
